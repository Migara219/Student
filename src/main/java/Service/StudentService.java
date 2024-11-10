package Service;

import java.util.List;

import Entity.Student;

public interface StudentService {

    Student saveStudent(Student student);
    List <Student>getAllStudent();
    Student getStudentById(long id);
 Student updateStudent(Student student,long id);
 void deleteStudent(long id);

    
}
