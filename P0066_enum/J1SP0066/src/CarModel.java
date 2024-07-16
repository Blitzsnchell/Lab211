import java.util.*;

// Enum for Car Types
enum Car {
    AUDI, MERCEDES, BMW
}

// Enum for Days
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Enum for Colors
enum Color {
    WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NO_COLOR
}

public class CarModel{
    public static List<Integer> getPrices(Car car) {
        switch (car) {
            case AUDI:
                return Arrays.asList(5500, 3000, 4500);
            case MERCEDES:
                return Arrays.asList(5000, 6000, 8500);
            case BMW:
                return Arrays.asList(2500, 3000, 3500);
            default:
                return Collections.emptyList();
        }
    }

    public static List<Color> getColors(Car car) {
        switch (car) {
            case AUDI:
                return Arrays.asList(Color.WHITE, Color.YELLOW, Color.ORANGE);
            case MERCEDES:
                return Arrays.asList(Color.GREEN, Color.BLUE, Color.PURPLE);
            case BMW:
                return Arrays.asList(Color.PINK, Color.RED, Color.BROWN);
            default:
                return Collections.emptyList();
        }
    }

    public static List<Day> getDaySells(Car car) {
        switch (car) {
            case AUDI:
                return Arrays.asList(Day.FRIDAY, Day.SUNDAY, Day.MONDAY);
            case MERCEDES:
                return Arrays.asList(Day.TUESDAY, Day.SATURDAY, Day.WEDNESDAY);
            case BMW:
                return Arrays.asList(Day.MONDAY, Day.SUNDAY, Day.THURSDAY);
            default:
                return Collections.emptyList();
        }
    }
    
    public static void addCar(ArrayList<Car> lc) {
        lc.add(Car.AUDI);
        lc.add(Car.MERCEDES);
        lc.add(Car.BMW);
    }  
}