package practice;

/**
 * Author: Eric Altenburg
 * Date: 8/31/18
 * Project:
 * Project Description:
 **/
public class Undergraduate extends Person {
    //data fields
    private int undergradID;
    private double GPA;

    //constructor
    Undergraduate(String name, int age, String address, int undergradID, double GPA) {
        super(name, age, address);
        this.undergradID = undergradID;
        this.GPA = GPA;
    }

    //methods
    public int getUndergradID() {
        return undergradID;
    }

    public void setUndergradID(int undergradID) {
        this.undergradID = undergradID;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getCredentials() {
        StringBuilder s = new StringBuilder();

        s.append("The undergrad's GPA is ");
        s.append(this.getGPA());

        return s.toString();
    }
}