package practice;

/**
 * Author: Eric Altenburg
 * Date: 8/31/18
 * Project:
 * Project Description:
 **/
public class Graduate extends Person {
    //data fields
    private int graduateID;
    private String major;

    //constructor
    Graduate (String name, int age, String address, int graduateID, String major) {
        super (name, age, address);
        this.graduateID = graduateID;
        this.major = major;
    }

    //methods
    public int getGraduateID() {
        return graduateID;
    }

    public void setGraduateID(int graduateID) {
        this.graduateID = graduateID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCredentials() {
        StringBuilder s = new StringBuilder();
        s.append("The grad's major is ");
        s.append(this.getMajor());
        return s.toString();
    }
}
