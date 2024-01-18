/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab63_person;

/**
 *
 * @author tungl
 */
public class Main {

    public static void main(String[] args) {
        ManagementPerson manager = new ManagementPerson();
        // Header of Program
        System.out.println("====Management Person Programer====");
        // number of person
        int numberOfPerson = 3;
        // 3 person in arrray
        Person[] persons = new Person[numberOfPerson];
        // input for 3 person
//        for (int i = 0; i < numberOfPerson; i++) {
//            persons[i] = manager.inputPersonInfo();
//        }
        for (Person p : persons) {
            p = manager.inputPersonInfo();
        }
        // Sort persons
        Person[] personsSorted = new Person[numberOfPerson];
        personsSorted = manager.sortBySalary(persons);
        // Display Sort persons
        manager.displayPersonsInfo(personsSorted);

    }
}
