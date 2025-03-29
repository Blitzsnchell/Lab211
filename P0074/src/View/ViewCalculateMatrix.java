package View;

import utils.Validate;

/**
 *
 * @author Admin
 */
public class ViewCalculateMatrix {

    public int menu() {
        System.out.println("======= Calculator program =======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        int choice = Validate.checkInputIntLimit("Your choice: ", 1, 4);
        return choice;
    }
}
