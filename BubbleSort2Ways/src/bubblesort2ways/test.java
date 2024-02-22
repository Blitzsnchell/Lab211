/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort2ways;

/**
 *
 * @author tuan
 */
public class test {

    private static void BubbleSortTestCase(int[] arr) {
        ArrayInteraction a = new ArrayInteraction();
        int arrayLength = arr.length;
        boolean check = true;
        displayArrayTestCase(arr, "unsorted");
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    if (check) {
                        a.displayArray(arr);
                        System.err.println("a     " + arr[i] + ">" + arr[j] + ", " + "swap");
                    }
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                } else {
                    a.displayArray(arr);
                    System.out.println("     " + arr[i] + "<" + arr[j] + ", " + "ok");
                }
            }
        }
    }

    private static void displayArrayTestCase(int[] arr, String msg) {
        ArrayInteraction a = new ArrayInteraction();
        a.displayArray(arr);
        System.out.println("     " + msg);
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 9, 1, 7};
        BubbleSortTestCase(arr);
    }
}
