/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author admin
 */
public class Ebank {
   
    private Locale locale;
    private ResourceBundle bundle;

    public Ebank() {
        setLocale(new Locale.Builder().setLanguage("en").setRegion("US").build(), "language/En");
    }
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale, String msg) {
        this.locale = locale;
        this.bundle = ResourceBundle.getBundle(msg, locale); // Ràng buộc ResourceBundle với Locale
    }

    public ResourceBundle getBundle() {
        return bundle;
    }
    
    //hàm kiểm tra số tài khoản
    public String checkAccountNumber(String accountNumber) {
        //step 1: check số tài khoản có 10 kí tự số hay không
        if (accountNumber.matches("^[0-9]{10}$")) {
            //step 2: nếu có, trả về chuỗi rỗng
            return "";
        }
        //step 3: nếu không, trả về chuỗi lỗi
        return bundle.getString("check.account");
    }

    //hàm kiểm tra mật khẩu
    public String checkPassword(String password) {
         //step 1: check số tài khoản có 8-31 kí tự và có cả chữ, số hay không
        if (password.matches("^[0-9a-zA-Z]{8,31}$") && password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*")) {
            //step 2: nếu có, trả về chuỗi rỗng
            return "";
        }
        //step 3: nếu không, trả về chuỗi lỗi
        return bundle.getString("wrong.password");        
    }
    
    //hàm kiểm tra capcha
    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        //step 1: check captchaGenerate có giống captchaInput không
        if (captchaGenerate.equals(captchaInput)) {
            //step 2: nếu có, trả về chuỗi rỗng
            return "";
        }
        //step 3: nếu không, trả về chuỗi lỗi
        return bundle.getString("wrong.captcha");       
    }

    //hàm generate capcha
    public String generateCaptcha() {
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
