package com.example.SpringDataJPACRUD1.Controller;

import com.example.SpringDataJPACRUD1.DTO.StudentDTO;
import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    private StudentService studentService;

    //add student to the database
    @PostMapping
    public ResponseEntity<StudentDTO> createStudents(@RequestBody Student s){

       StudentDTO s1=studentService.saveStudent(s);
       return ResponseEntity.ok(s1);
    }

    //Get all the students present in the database
    @GetMapping("/get")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){

       List<StudentDTO> list=studentService.getAll();
       if(list.size()==0){
           return ResponseEntity.badRequest().build();
       }
       return ResponseEntity.ok(list);
    }

    //extract student details by id
    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDTO> getAllStudents(@PathVariable int id ){

        StudentDTO student= studentService.getStudents(id);
        if(student.getRoll()!=id){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(student);
    }



    //get students by first and last name
    @GetMapping("/fullname/{fname}")
    public ResponseEntity<StudentDTO> findByFullName(@PathVariable String fname){
        String[] sp= fname.split(" ");
        if(sp.length==1){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        StudentDTO student=studentService.findByFullName(sp[0],sp[1]);
        if(student==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(student);
    }

    //get students by first name and roll
    @GetMapping("/getby/{i}/{s}")
    public ResponseEntity<StudentDTO> getByNameAndRoll(@PathVariable int i,@PathVariable String s){
        StudentDTO student=studentService.findByRollAndName(i,s);
        return ResponseEntity.ok(student);
    }

    //delete a student from database by id
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        studentService.deleteByRoll(id);
        return ResponseEntity.ok().build();
    }


    }

