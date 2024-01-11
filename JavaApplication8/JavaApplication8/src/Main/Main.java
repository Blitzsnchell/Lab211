/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

public class Main {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        FibonacciHelper helper = new FibonacciHelper();
        for (int i = 0; i < 45; i++) {
            int rls = helper.fiboHepper(i);
            System.out.print(i+":"+rls +", ");
        }
//        int[] arr = new int[45];
////        helper.fiboOpss(arr, 44);
//        arr = helper.fiboOpss(45);
//        for (int i : arr) {
//            System.out.print(i + ", ");
//        }

    }
    
    public static int fiboHepper(int index){
        if(index == 0){
            return 0;
        }
        if(index < 2){
            return 1;
        }
        return fiboHepper(index-1) + fiboHepper(index-2);
    }
    
    public static int fibonnaciHelper(int term, int lower, int higher) {
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + " ");
        return fibonnaciHelper(term - 1, higher, higher + lower);
    }
}