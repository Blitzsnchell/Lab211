
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<Car> lc = new ArrayList<>();
        CarModel.addCar(lc);
        System.out.println("Input information of car");
        while (true) {
            System.out.print("Name: ");
            String name = CarManager.checkInputString();
            System.out.print("Color: ");
            String color = CarManager.checkInputString();
            System.out.print("Price: ");
            int price = CarManager.checkInputInt();
            System.out.print("Today: ");
            String today = CarManager.checkInputString();
            if (!CarManager.checkNameCar(lc, name, color, price, today)) {
                break;
            }
        }
    }
}