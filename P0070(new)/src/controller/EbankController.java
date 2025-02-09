package controller;

import model.Inputter;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import view.EbankView;

/**
 *
 * @author Admin
 */
public class EbankController {

    Inputter inputter = new Inputter();
    EbankView view = new EbankView();
    Locale locale;
    ResourceBundle bundle;

    //hàm xử lý luồng chính
    public void execute() {
        while (true) {
            //print menu
            view.menu();
            //nhập lựa chọn là integer từ bàn phím
            int choice = inputter.getInt(1, 3);
            switch (choice) {
                case 1:
                    //set biến local ngôn ngữ  
                    setLocale(new Locale.Builder().setLanguage("vi").setRegion("VN").build());
                    //lấy tệp ngôn ngữ vi dựa theo biến local
                    bundle = ResourceBundle.getBundle("language/Vi", locale);
                    //chạy hàm xử lý logic
                    handle();
                    break;
                case 2:
                    //set biến local ngôn ngữ 
                    setLocale(new Locale.Builder().setLanguage("en").setRegion("US").build());
                    //lấy tệp ngôn ngữ vi dựa theo biến local
                    bundle = ResourceBundle.getBundle("language/En", locale);
                    //chạy hàm xử lý logic
                    handle();
                    break;
                case 3:
                    return;
            }
            inputter.displayNotice("");
        }
    }

    //Hàm xử lý logic
    void handle() {
        while (true) {
            //step 1: nhập chuỗi tài khoản từ bàn phím
            String accountNumber = inputter.getString(bundle.getString("account"));
            //step 2: check chuỗi tài khoản có đúng không
            String msg = checkAccountNumber(accountNumber);
            //step 3: check có tin nhắn lỗi không
            if (msg.isEmpty()) {
            //step 4: nếu không có tin nhắn lỗi , ngắt vòng lặp
                break;
            }
            //step 5: nếu có tin nhắn lỗi, print
            inputter.displayErr(msg);
        }

        while (true) {
            //step 6: nhập chuỗi mật khẩu từ bàn phím
            String password = inputter.getString(bundle.getString("password"));
            //step 7: check mật khẩu có đúng không
            String msg = checkPassword(password);
            //step 8: check xem có tin nhắn lỗi không
            if (msg.isEmpty()) {
                //step 9: nếu không có tin nhắn lỗi, ngắt vòng lặp
                break;
            }
            //step 10: nếu có tin nhắn lỗi, print
            inputter.displayErr(msg);
        }

        while (true) {
            //step 11: generate chuỗi capcha
            String captchaGenerate = generateCaptcha();
            //step 12: print chuỗi capcha
            inputter.displayNotice(bundle.getString("captcha") + captchaGenerate);     
            //step 13: nhập chuỗi capcha từ bàn phím
            String captchaInput = inputter.getString(bundle.getString("captcha"));  
            //step 14: so sánh chuỗi capcha từ bàn phím và chuỗi capcha generate
            String msg = checkCaptcha(captchaInput, captchaGenerate);            
            //step 15: check xem có tin nhắn lỗi không
            if (msg.isEmpty()) {
                //step 16: nếu không có tin nhắn lỗi, ngắt vòng lặp
                break;
            }
            //step 17: nếu có tin nhắn lỗi, print
            inputter.displayErr(msg);
        }
    }

    void setLocale(Locale locale) {
        this.locale = locale;
    }

    //hàm kiểm tra số tài khoản
    String checkAccountNumber(String accountNumber) {
        //step 1: check số tài khoản có 10 kí tự số hay không
        if (accountNumber.matches("^[0-9]{10}$")) {
            //step 2: nếu có, trả về chuỗi rỗng
            return "";
        }
        //step 3: nếu không, trả về chuỗi lỗi
        return bundle.getString("check.account");
    }

    //hàm kiểm tra mật khẩu
    String checkPassword(String password) {
         //step 1: check số tài khoản có 8-31 kí tự và có cả chữ, số hay không
        if (password.matches("^[0-9a-zA-Z]{8,31}$") && password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*")) {
            //step 2: nếu có, trả về chuỗi rỗng
            return "";
        }
        //step 3: nếu không, trả về chuỗi lỗi
        return bundle.getString("wrong.password");        
    }
    
    //hàm kiểm tra capcha
    String checkCaptcha(String captchaInput, String captchaGenerate) {
        //step 1: check captchaGenerate có giống captchaInput không
        if (captchaGenerate.equals(captchaInput)) {
            //step 2: nếu có, trả về chuỗi rỗng
            return "";
        }
        //step 3: nếu không, trả về chuỗi lỗi
        return bundle.getString("wrong.captcha");       
    }

    //hàm generate capcha
    String generateCaptcha() {
        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String captcha = "";
        
        // step 1: đặt vòng lặp 5 lần
        for (int i = 0; i < 5; i++) {
            //step 2: random số bất kì khoảng bằng độ dài chuỗi kí tự [0-z]
            int index = r.nextInt(s.length());
            //step 3: thêm kí tự ở vị trí index đã random trên chuỗi vào cuối capcha
            captcha = captcha + s.charAt(index);
            //step 4: bỏ kí tự vừa thêm vào capcha ra khỏi chuỗi 
            s = s.substring(0, index) + s.substring(index + 1);
        }
        //step 5: return capcha
        return captcha;
    }

}