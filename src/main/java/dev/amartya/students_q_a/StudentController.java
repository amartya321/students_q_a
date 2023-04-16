package dev.amartya.students_q_a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getallStudents(){
        return  new ResponseEntity<List<Student>>(studentService.allStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/{rollnumber}")
    public ResponseEntity<Student> findStudentByRollnumber(@PathVariable Integer rollnumber){
        Student student = studentService.StudentbyRollnumber(rollnumber);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

}
