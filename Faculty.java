package practice;

/**
 * Author: Eric Altenburg
 * Date: 8/31/18
 * Project:
 * Project Description:
 **/
public class Faculty extends Person {
    //data fields
    private int facultyID;
    private String job;

    //constructor
    Faculty (String name, int age, String address, int facultyID, String job) {
        super (name, age, address);
        this.facultyID = facultyID;
        this.job = job;
    }

    //methods
    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCredentials() {
        StringBuilder s = new StringBuilder();

        s.append("This faculty's job is ");
        s.append(this.getJob());

        return s.toString();
    }
}
