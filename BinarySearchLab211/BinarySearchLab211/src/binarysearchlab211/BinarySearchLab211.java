/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearchlab211;

/**
 *
 * @author tungl
 */
public class BinarySearchLab211 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation input = new Validation();
        ArrayInteraction a = new ArrayInteraction();
        BinarySearch search = new BinarySearch();

        int numberOfArray = input.checkInt("Enter number of array:", "Must be integer!");
        // generate random number in array
        int[] arr = a.getArrRamdom(numberOfArray);
        // in ra chua sort
        // sort array (Bubble sortt)
        //  find number
        int n = input.checkInt("Enter search value:", "Must be integer!");
        // sort r?i in
        arr = a.sortArray(arr);
        a.displayArray(arr);
        int rls = search.binarySearch(arr, n);
        if (rls == -1) {
            System.err.println("Not Found!");
        } else {
            System.out.println("Found " + n + " index: " + rls);
        }
    }

}
