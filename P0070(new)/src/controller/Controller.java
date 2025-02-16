package controller;

import model.Inputter;
import java.util.Locale;
import java.util.ResourceBundle;
import view.View;

/**
 *
 * @author Admin
 */
public class Controller {

    private View view = new View();
    private Ebank ebank = new Ebank();
    private Inputter inputter = new Inputter();
    
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
                    ebank.setLocale(new Locale.Builder().setLanguage("vi").setRegion("VN").build(), "language/Vi");
                    //chạy hàm xử lý logic
                    handle();
                    break;
                case 2:
                    //set biến local ngôn ngữ 
                    ebank.setLocale(new Locale.Builder().setLanguage("en").setRegion("US").build(), "language/En");
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
    public void handle() {
        while (true) {
            //step 1: nhập chuỗi tài khoản từ bàn phím
            String accountNumber = inputter.getString(ebank.getBundle().getString("account"));
            //step 2: check chuỗi tài khoản có đúng không
            String msg = ebank.checkAccountNumber(accountNumber);
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
            String password = inputter.getString(ebank.getBundle().getString("password"));
            //step 7: check mật khẩu có đúng không
            String msg = ebank.checkPassword(password);
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
            String captchaGenerate = ebank.generateCaptcha();
            //step 12: print chuỗi capcha
            inputter.displayNotice(ebank.getBundle().getString("captcha") + captchaGenerate);     
            //step 13: nhập chuỗi capcha từ bàn phím
            String captchaInput = inputter.getString(ebank.getBundle().getString("captcha"));  
            //step 14: so sánh chuỗi capcha từ bàn phím và chuỗi capcha generate
            String msg = ebank.checkCaptcha(captchaInput, captchaGenerate);            
            //step 15: check xem có tin nhắn lỗi không
            if (msg.isEmpty()) {
                //step 16: nếu không có tin nhắn lỗi, ngắt vòng lặp
                break;
            }
            //step 17: nếu có tin nhắn lỗi, print
            inputter.displayErr(msg);
        }
    }

}