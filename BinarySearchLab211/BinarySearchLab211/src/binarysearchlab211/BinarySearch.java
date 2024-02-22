/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchlab211;

/**
 *
 * @author tungl
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        if (left > right) {
            return -1;
        }
        ArrayInteraction i = new ArrayInteraction();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("Step: " + (count + 1));
            for (int j = left; j <= right; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.print("\nCompare: " +  arr[mid]+ "(index: "+mid+")" + "-" +value+"(value)");
            if (arr[mid] == value) {
                count++;
                return mid;
            }
            if (arr[mid] > value) {
                count++;
                right = mid - 1;
            }
            if (arr[mid] < value) {
                count++;
                left = mid + 1;
            }
            System.out.println("");
        }
        return -1;
    }
}
