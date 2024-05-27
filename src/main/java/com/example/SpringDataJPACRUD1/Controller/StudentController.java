package com.example.SpringDataJPACRUD1.Controller;

import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    private StudentService studentService;

    //add student to the database
    @PostMapping
    public Student createStudents(@RequestBody Student s){

        return studentService.saveStudent(s);
    }

    //Get all the students present in the database
    @GetMapping("/get")
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }

    //extract student details by id
    @GetMapping("/id/{id}")
    public Student getAllStudents(@PathVariable int id ){
        return studentService.getStudents(id);
    }

    //get student details only by first name
    @GetMapping("/fname/{fname}")
    public String getByFirstName(@PathVariable String fname){
        return studentService.getStudentByFirstName(fname) ;
    }

    //get student details only by last name
    @GetMapping("/lname/{lname}")
    public String getByLastName(@PathVariable String lname){
        return studentService.getStudentByLastName(lname) ;
    }

    //get students by first and last name
    @GetMapping("/flname/{fname}/{lname}")
    public Student findByFullName(@PathVariable String fname,@PathVariable String lname){
        return studentService.findByFAndLName(fname,lname);
    }

    //delete a student from database by id
    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteByRoll(id);
        return "Student Deleted";
    }
}
