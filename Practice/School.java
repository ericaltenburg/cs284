package practice;

/**
 * Author: Eric Altenburg
 * Date: 8/31/18
 * Project:
 * Project Description:
 **/
public class School {
    private String[] faculty;
    private String[] students;

    public String printFaculty() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.faculty.length; i ++) {
            s.append(this.faculty[i]);
            s.append(" ");
        }

        return s.toString();
    }

    public String printStudent() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.students.length; i ++) {
            s.append(this.students[i]);
            s.append(" ");
        }

        return s.toString();
    }


    public static void main(String[] args) {
        Student s = new Student("Eric", 18,"100 Hempstead Road", 123);
        Undergraduate u = new Undergraduate("Kyle", 19, "99 Hempstead Road", 321, 4.001);
        Graduate g = new Graduate("Erica", 20, "2488 Sylvan Avenue", 897, "CS");
        Faculty f = new Faculty("Eduardo", 34, "44 Edgemont Avenue", 8888, "janitor");
        NonTenured n = new NonTenured("Ziegler", 78, "1 West Street", 2345, 2);
        Tenured t = new Tenured("James", 34, "76 Ave Avenue", 999, 5);

        System.out.println(s.getName() + "'s age and address is: " +s.getAge()+ " and " +s.getAddress()+". And their ID is: " +s.getStudentID());
        System.out.println(s.getCredentials());
        System.out.println(u.getName() + "'s age and address is: " +u.getAge()+ " and " +u.getAddress()+". And their ID is: " +u.getUndergradID());
        System.out.println(u.getCredentials());
        System.out.println(g.getName() + "'s age and address is: " +g.getAge()+ " and " +g.getAddress()+". And their ID is: " +g.getGraduateID());
        System.out.println(g.getCredentials());
        System.out.println(f.getName() + "'s age and address is: " +f.getAge()+ " and " +f.getAddress()+". And their ID is: " +f.getFacultyID());
        System.out.println(f.getCredentials());
        System.out.println(n.getName() + "'s age and address is: " +n.getAge()+ " and " +n.getAddress()+". And their ID is: " +n.getNonTenuredID());
        System.out.println(n.getCredentials());
        System.out.println(t.getName() + "'s age and address is: " +t.getAge()+ " and " +t.getAddress()+". And their ID is: " +t.getTenuredID());
        System.out.println(t.getCredentials());

    }
}
