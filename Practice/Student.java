package practice;

/**
 * Author: Eric Altenburg
 * Date: 8/31/18
 * Project:
 * Project Description:
 **/
public class Student extends Person {
    //data fields
    private int studentID;

    //constructor
    Student (String name, int age, String address, int studentID) {
        super (name, age, address);
        this.studentID = studentID;
    }

    //methods
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCredentials() {
        StringBuilder s = new StringBuilder();

        s.append("The students CWID is ");
        s.append(this.getStudentID());
        return s.toString();
    }
}
