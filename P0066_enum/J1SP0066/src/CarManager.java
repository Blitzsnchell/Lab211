import java.util.*;

public class CarManager {
    
    public static final Scanner in = new Scanner(System.in);

    public static String checkInputString(){
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                System.err.println("Not empty");
                System.out.print("ENTER AGAIN: ");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt(){
         while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    System.err.println("Price greater than zero");
                    System.out.print("ENTER AGAIN: ");
                    continue;
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Price is digit");
                System.out.print("ENTER AGAIN: ");
            }
        }
    }

    public static boolean checkYN(){
        while (true) {
            String result = checkInputString();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }else
            System.err.println("Re-input");
        }
    }

    public static boolean checkCarExist(Car car, String color, int price, String today){
        List<Color> availableColors = CarModel.getColors(car);
        List<Integer> availablePrices = CarModel.getPrices(car);
        List<Day> sellingDays = CarModel.getDaySells(car);

        boolean checkColor = false, checkPrice = false, checkDay = false;

        if (!color.equalsIgnoreCase("no color")) {
            checkColor = availableColors.contains(Color.valueOf(color.toUpperCase()));
        } else {
            checkColor = true;
            price += 100;
        }

        checkPrice = availablePrices.contains(price);

        checkDay = sellingDays.contains(Day.valueOf(today.toUpperCase()));

        return checkColor && checkPrice && checkDay;
    }

    public static boolean checkNameCar(ArrayList<Car> lc, String name, String color, int price, String today){
        boolean check = false;
        for (int i = 0; i < lc.size(); i++) {
            if (name.equalsIgnoreCase(lc.get(i).name())) {
                if (checkCarExist(lc.get(i), color, price, today)) {
                    System.out.println("Sell Car");
                    System.out.print("Do you want find more?(Y/N): ");
                    if (!checkYN()) return false;                   
                
                } else {
                    System.out.println("Can't sell Car");
                    System.out.println("Car break");
                }
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Can't find car.");
        }
        return true;
    }
}
