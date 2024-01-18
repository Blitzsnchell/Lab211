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
//            for (int j = left; j < right; j++) {
//                System.out.print(arr[j]+" ");
//            }
//            System.out.println("10");
//            count ++;
            
            if (arr[mid] == value) {
//                System.out.println("Step:"+count);
                return mid;
            } 
            if (arr[mid] > value) {
                right = mid - 1;
            } 
            if (arr[mid] < value) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
