package dev.amartya.students_q_a;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public List<Student> allStudents(){
        return  studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.insert(student);
    }

    public void addStudent(List<Student> student){
        studentRepository.saveAll(student);
    }

    public Student StudentbyRollnumber(Integer rollnumber){
        return  studentRepository.findByrollnumber(rollnumber);

    }
}
