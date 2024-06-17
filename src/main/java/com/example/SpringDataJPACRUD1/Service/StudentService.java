package com.example.SpringDataJPACRUD1.Service;

import com.example.SpringDataJPACRUD1.DTO.StudentRequest;
import com.example.SpringDataJPACRUD1.DTO.StudentResponse;
import com.example.SpringDataJPACRUD1.Entity.Student;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;


public interface StudentService {
//    StudentDTO entityToDto(Student student);
    String saveStudents(Student s);
    List<StudentResponse> getAll();
    StudentResponse getStudentsByID(int id, String dob);
    StudentResponse findByFullName(String fname,String lname);
    StudentResponse findByRollAndName(int r,String s);
    void deleteByRoll(int Roll);
    void deleteall();
    StudentResponse getStudents(int Roll);
    Student updateID(int id);
    Student saveStudent(Student s);//for testing purpose
    Student getStudentByID(int Roll, String dob);//for testing purpose
    List<Student> getAllStudent();//for testing purpose
    Student getStudentsByRoll(int Roll);//for testing purpose

}
