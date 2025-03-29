package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Validate {

    private final Scanner in = new Scanner(System.in);
    private final String DATE_VALID = "^(0[1-9]|[12][0-9]|3[01])-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{4}$";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputDate() {
        dateFormat.setLenient(false);
        while (true) {
            String result = in.nextLine().trim();
            if (result.matches(DATE_VALID)) {
                try {
                    Date inputDate = dateFormat.parse(result);
                    Date currentDate = new Date();
                    if (!inputDate.after(currentDate)) {
                        return result;
                    } else {
                        System.err.println("Invalid input! The date cannot be in the future. Please re-enter.");
                    }
                } catch (ParseException e) {
                    System.err.println("Invalid format! Please enter again (dd-MMM-yyyy), e.g., 05-Jun-2024");
                }
            } else {
                System.err.println("Invalid format! Please enter again (dd-MMM-yyyy), e.g., 05-Jun-2024");
            }
        }
    }

    public double checkInputDouble() {
        while (true) {
            try {
                return Double.parseDouble(in.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.err.println("Re-input");
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }
}
