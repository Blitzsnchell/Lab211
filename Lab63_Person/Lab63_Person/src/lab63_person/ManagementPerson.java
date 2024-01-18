/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab63_person;

/**
 *
 * @author tungl
 */
public class ManagementPerson {

    public Validation input = new Validation();

    public Person inputPersonInfo() {
        // header input
        System.out.println("Input Information of Person");
        String name = input.checkEmpty("Please input name: ");
        String address = input.checkEmpty("Please input address: ");
        Double salary = input.checkSalary("Please input salary: ", "Must be a possitive number!");
        Person p = new Person(name, address, salary); 
        return p;
    }

    public void displayPersonInfo(Person person) {
        System.out.println("Information of Person you have entered:");
        System.out.println(person);
    }
    public void displayPersonsInfo(Person[] person){
        for (Person p : person) {
            displayPersonInfo(p);
        }
    }
    public Person[] sortBySalary(Person[] person) {
        for (int i = 0; i < person.length; i++) {
            for (int j = i + 1; j < person.length; j++) {
                if (person[i].getSalary() > person[j].getSalary()) {
                    Person temp = new Person();
                    temp.setName(person[i].getName());
                    temp.setAddress(person[i].getAddress());
                    temp.setSalary(person[i].getSalary());
                    
                    person[i].setName(person[j].getName());
                    person[i].setAddress(person[j].getAddress());
                    person[i].setSalary(person[j].getSalary());

                    person[j].setName(temp.getName());
                    person[j].setAddress(temp.getAddress());
                    person[j].setSalary(temp.getSalary());
                }
            }
        }
        return person;
    }
}
