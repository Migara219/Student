package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Student;
import Repository.StudentRepository;

@Service
public class StudnetServiceImpl implements StudentService {


    @Autowired
 private StudentRepository studentRepsitory;

    @Override
    //save student
    public Student saveStudent(Student student) {
        return studentRepsitory.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepsitory.findAll();}

    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepsitory.findById(id);
        if(student.isPresent()){
        return student.get();
        }else {
        throw new RuntimeException();
        }
    }

    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent= 
studentRepsitory.findById(id).orElseThrow(
 ()-> new RuntimeException()
 );
 existingStudent.setFirstName(student.getFirstName());
 existingStudent.setLastName(student.getLastName());
 existingStudent.setEmail(student.getEmail());
 // save
 studentRepsitory.save(existingStudent);
 return existingStudent;}

    @Override
    public void deleteStudent(long id) {
        studentRepsitory.findById(id).orElseThrow(()-> new 
RuntimeException());
 //delete
 studentRepsitory.deleteById(id);
 }
    
}