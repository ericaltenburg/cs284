package practice;

/**
 * Author: Eric Altenburg
 * Date: 8/31/18
 * Project: 1
 * Project Description: Implement a class Person with at least the following data fields:
 * name, age, address, and the corresponding getters and setters.  Try out your class by adding a main method,
 * as seen in the video, that creates a couple of instances of your class and then prints out the name, age and address.
 */
public class Person {
    //data fields
    private String name;
    private int age;
    private String address;

    //constructor
    /**
     * This creates a person with the given name, age, and address
     * @param name
     * @param age
     * @param address
     */
    Person (String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //methods
    /**
     * when called, this method returns the name
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * this method changes the person's name
     * @param  name you want to change to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * this method returns the age of the person
     * @return persons age
     */
    public int getAge() {
        return age;
    }

    /**
     * This method allows you to change the person's age
     * @param age you want to change it to
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * this method returns the address of the person
     * @return the persons address
     */
    public String getAddress() {
        return address;
    }

    /**
     * allows the user to change the person's address
     * @param address you want to change to
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /*
    public static void main(String[] args) {
        Person p1 = new Person ("James", 18, "100 Hempstead Road");
        Person p2 = new Person ("Addy", 3, "5 Broad Street");
        Person p3 = new Person ("Eric", 19, "15 Sullivan Way");

        System.out.println(p1.getName() + "'s age and address is: " +p1.getAge()+ " and " +p1.getAddress());
        System.out.println(p2.getName() + "'s age and address is: " +p2.getAge()+ " and " +p2.getAddress());
        System.out.println(p3.getName() + "'s age and address is: " +p3.getAge()+ " and " +p3.getAddress());
    }
    */
}
