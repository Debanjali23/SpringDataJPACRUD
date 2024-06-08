package com.example.SpringDataJPACRUD1.Controller;

import com.example.SpringDataJPACRUD1.DTO.StudentResponse;
import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Response.ResponseEntities;
import com.example.SpringDataJPACRUD1.ServiceImpl.ServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<StudentResponse>> getAllStudents(){

       List<StudentResponse> list=serviceImplementation.getAll();
       if(list.size()==0){
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       return ResponseEntity.of(Optional.of(list));
    }
    //get students by Primary Keys
    @GetMapping("/pk/{i}/{s}")
    public ResponseEntity<StudentResponse> getByIdandDob(@PathVariable int i,@PathVariable String s){
        StudentResponse studentResponse=serviceImplementation.findByRollAndName(i,s);
        if(studentResponse==null) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.of(Optional.of(studentResponse));
    }

    //extract student details by id
    @GetMapping("/id/{id}")
    public ResponseEntity<StudentResponse> getAllStudents(@PathVariable int id ){

        StudentResponse studentResponse= serviceImplementation.getStudents(id);
        if(studentResponse==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(studentResponse));
    }



    //get students by first and last name
    @GetMapping("/fullname/{fname}")
    public ResponseEntity<StudentResponse> findByFullName(@PathVariable String fname){
        String[] sp= fname.split(" ");
        if(sp.length==1){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        StudentResponse studentResponse=serviceImplementation.findByFullName(sp[0],sp[1]);
        if(studentResponse==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(studentResponse));
    }

    //get students by first name and roll
    @GetMapping("/getby/{i}/{s}")
    public ResponseEntity<StudentResponse> getByNameAndRoll(@PathVariable int i,@PathVariable String s) {
        StudentResponse studentResponse = serviceImplementation.findByRollAndName(i, s);
        if (studentResponse == null) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.of(Optional.of(studentResponse));
    }

    //delete a student from database by id
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        serviceImplementation.deleteByRoll(id);
        return responseEntities.successful();
    }

    //delete all students
    @DeleteMapping("/delall")
    public ResponseEntity<String> deleteall(){
        serviceImplementation.deleteall();
        return responseEntities.successful();
    }

    }

