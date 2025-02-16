/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Controller;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Inputter {
    
    private Scanner sc = new Scanner(System.in);
    
    //hàm nhập integer khoảng min - max
    public int getInt(int min, int max) {
        while (true) {
            try {
                //step 1: Print content
                System.out.print("Choose: ");
                //step 2: Parse kí tự nhập từ bàn phím sang integer
                int n = Integer.parseInt(sc.nextLine());
                //step 3: Check integer nhập vào có trong khoảng min max
                if (min <= n && n <= max) {
                //step 4: trả về integer
                    return n;
                }
                //step 5: Nếu integer không trong khoảng thì in ra lỗi
                System.err.println("Must from: " + min + " -> " + max);
            } catch (NumberFormatException ex) {
                //step ^: Nếu kí tự nhập vào không phải integer in ra lỗi
                System.err.println("Wrong format");
            }
        }
    }
    
    //hàm nhập kí tự từ bàn phím
    public String getString(String msg) {
        while (true) {
            //step 1: print tin nhắn
            System.out.print(msg);
            //step 2: nhập kí tự từ bàn phím
            String s = sc.nextLine();
            //step 3: kiểm tra kí tự có rỗng không
            if (!s.isEmpty()) {
            //step 4: trả về kí tự
                return s;
            }
            //step 5: nếu kí tự rỗng, in ra lỗi
            System.err.println("Empty string is not allowed");
        }
    }
    
    public void displayNotice(String notice) {
        System.out.println(notice);
    }
    
    public void displayErr(String err) {
        System.err.println(err);
    }
    
    
}