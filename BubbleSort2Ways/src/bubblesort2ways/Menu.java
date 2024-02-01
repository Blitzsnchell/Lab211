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
public class Menu {

    public void menuDisplay() {
        System.out.println("1.	 Input items of the array");
        System.out.println("2.   Sort the array in ascending order");
        System.out.println("3.   Sort the array in descending order");
        System.out.println("4.   Exit");

    }

    public void menuProcess() {
        Validation input = new Validation();
        ArrayInteraction a = new ArrayInteraction();
        int[] arr = new int[0];

        //chay den khi nao return hoac break
        while (true) {
            // step 2: Display a menu and ask a user to select an option.
            menuDisplay();
            //choose option
            int choice = input.checkIntLimit("Enter choice:", "Must be in range!", 1, 4);
            // Step 2 Perform function based on the selected option.
            switch (choice) {
                //Input Element(s)
                case 1:
                    // Input size of arrray
                    System.out.println("----- Input Element -----");
                    System.out.println("Input Length Of Array");
                    int numberOfArray = input.checkPositiveNumber("Enter number :", "Please input number and number is greater than zero");
                    // Enter element in array
                    arr = a.intputArrray(numberOfArray);
                    break;
                //Sort in ascending order
                case 2:
                    a.sortyAscending(arr);
                    break;
                //Sort in Descending order
                case 3:
                    a.sortArrayDescending(arr);
                    break;
                // Exit the program
                case 4:
                    return;
            }
        }
    }
}
