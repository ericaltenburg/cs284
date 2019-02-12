package practice;

/**
 * Author: Eric Altenburg
 * Date: 8/31/18
 * Project:
 * Project Description:
 **/
public class NonTenured extends Person {
    //data fields
    private int nonTenuredID;
    private int howMuchLonger;

    //constructor
    NonTenured (String name, int age, String address, int nonTenuredID, int howMuchLonger) {
        super (name, age, address);
        this.nonTenuredID = nonTenuredID;
        this.howMuchLonger = howMuchLonger;
    }

    //methods
    public int getNonTenuredID() {
        return nonTenuredID;
    }

    public void setNonTenuredID(int nonTenuredID) {
        this.nonTenuredID = nonTenuredID;
    }

    public int getHowMuchLonger() {
        return howMuchLonger;
    }

    public void setHowMuchLonger(int howMuchLonger) {
        this.howMuchLonger = howMuchLonger;
    }

    public String getCredentials() {
        StringBuilder s = new StringBuilder();
        s.append("This person won't be tenured for ");
        s.append(this.getHowMuchLonger());
        s.append(" more year(s)");
        return s.toString();
    }
}
