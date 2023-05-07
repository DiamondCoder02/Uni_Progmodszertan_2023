package Lesson12;

import java.io.File;
import java.util.List;

import Lesson12.first_xml.Student;

public class mainThing {
    public static void main(String[] args) {
        File f = new File("student.xml");
        System.out.println(f);

        List<Student> studentList = Student.getStudentsFromXml(f);
        for (int i=0; i<studentList.size(); i++){
            System.out.println(studentList.get(i));
        }

        studentList.add(new Student("Gay Furry", "prog.info", 3));
        studentList.add(new Student("Aztakurva De Büdös Vagy", "gazd.info", 1));

        System.out.println(studentList);

        Student.writeStudentsFromXml(studentList);
    }
}
