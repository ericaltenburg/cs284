package practice;

/**
 * Author: Eric Altenburg
 * Date: 8/31/18
 * Project:
 * Project Description:
 **/
public class Tenured extends Person {
    //data fields
    private int tenuredID;
    private int howLongTenured;

    //constructor
    Tenured (String name, int age, String address, int tenuredID, int howLongTenured) {
        super (name, age, address);
        this.tenuredID = tenuredID;
        this.howLongTenured = howLongTenured;
    }

    //methods
    public int getTenuredID() {
        return tenuredID;
    }

    public void setTenuredID(int tenuredID) {
        this.tenuredID = tenuredID;
    }

    public int getHowLongTenured() {
        return howLongTenured;
    }

    public void setHowLongTenured(int howLongTenured) {
        this.howLongTenured = howLongTenured;
    }

    public String getCredentials() {
        StringBuilder s = new StringBuilder();
        s.append("This person has been tenured for ");
        s.append(this.getHowLongTenured());
        s.append(" years");
        return s.toString();
    }
}
