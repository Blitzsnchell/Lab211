/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author tungl
 */
public class FibonacciHelper {

    public int fiboHepper(int index) {
        if (index == 0) {
            return 0;
        }
        if (index < 2) {
            return 1;
        }
        return fiboHepper(index - 1) + fiboHepper(index - 2);
    }

    public int fiboOpss(int arr[], int index) {
        if (index == 0) {
            arr[0] = 0;
            return 0;
        }
        if (index == 1) {
            arr[0] = 0;
            arr[1] = 1;
            return 1;
        }
        arr[index] = fiboOpss(arr, index - 1) + fiboOpss(arr, index - 2);
        return arr[index];
    }

    public int[] fiboOpss(int n) {
        if (n <= 0) {
            return new int[0];
        }

        int[] result = new int[n];
        result[0] = 0;
        if (n > 1) {
            result[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result;
    }

    int calculateFibonacci(int[] arr, int index) {
        if (index == 0) {
            arr[0] = 0;
            return 0;
        } else if (index == 1) {
            arr[0] = 0;
            arr[1] = 1;
            return 1;
        }
        int fib1 = calculateFibonacci(arr, index - 1);
        int fib2 = calculateFibonacci(arr, index - 2);
        arr[index] = fib1 + fib2;
        return arr[index];
    }
}
