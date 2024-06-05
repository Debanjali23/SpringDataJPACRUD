package com.example.SpringDataJPACRUD1.Controller;

import com.example.SpringDataJPACRUD1.DTO.StudentDTO;
import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import com.example.SpringDataJPACRUD1.Response.ResponseEntities;
import com.example.SpringDataJPACRUD1.Service.StudentService;
import com.example.SpringDataJPACRUD1.ServiceImpl.ServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController


public class StudentController {
    @Autowired
    private ServiceImplementation serviceImplementation;

    @Autowired
    private ResponseEntities responseEntities;

    //add student to the database
    @PostMapping("/add/student")
    public ResponseEntity<String> createStudents(@RequestBody Student s){

       String str=serviceImplementation.saveStudents(s);
       if(str.equalsIgnoreCase("success")) {
           return responseEntities.successful();
       }
       return responseEntities.nocontent();
    }

    //Get all the students present in the database
    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAllStudents(){

       List<Student> list=serviceImplementation.getAll();
       if(list.size()==0){
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       return ResponseEntity.of(Optional.of(list));
    }

    //extract student details by id
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Student>> getAllStudents(@PathVariable int id ){

        Optional<Student> student= serviceImplementation.getStudents(id);
        if(student.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(student));
    }



    //get students by first and last name
    @GetMapping("/fullname/{fname}")
    public ResponseEntity<String> findByFullName(@PathVariable String fname){
        String[] sp= fname.split(" ");
        if(sp.length==1){
            return responseEntities.notacceptable();
        }
        Optional<Student> student=serviceImplementation.findByFullName(sp[0],sp[1]);
        if(student==null){
            return responseEntities.notfound();
        }
        return responseEntities.successful();
    }

    //get students by first name and roll
    @GetMapping("/getby/{i}/{s}")
    public ResponseEntity<String> getByNameAndRoll(@PathVariable int i,@PathVariable String s){
        Optional<Student> student=serviceImplementation.findByRollAndName(i,s);
        return responseEntities.successful();
    }

    //delete a student from database by id
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        serviceImplementation.deleteByRoll(id);
        return responseEntities.successful();
    }


    }

