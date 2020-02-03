import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String name;
    private String studentNumber;
    Scanner s = new Scanner;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

//Start of methods
    public String getName() {
        return this.name;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }
    public String toString() {
        return this.name + " " + "(" + this.studentNumber + ")";
    }

    public ArrayList<Student> listOfStudents() {
        System.out.println("Name: ");
        String studentName = s.nextLine();
        while(!studentName.isEmpty()) {
        System.out.println("Studentnumber: ");
            String studentNumber = s.nextLine();

            Student s = new Student(studentName, studentNumber);
            listOfStudents().add(s);
        }
        return listOfStudents();
    }
}
