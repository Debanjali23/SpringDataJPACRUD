package com.example.SpringDataJPACRUD1.Service;

import com.example.SpringDataJPACRUD1.DTO.StudentDTO;
import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



public interface StudentService {
//    StudentDTO entityToDto(Student student);
    Student saveStudents(Student s);
    List<Student> getAll();
    Optional<Student> getStudentsByID(int id, String dob);
    Optional<Student> findByFullName(String fname,String lname);
    Optional<Student> findByRollAndName(int r,String s);
    void deleteByRoll(int Roll);
    void deleteall();
    Optional<Student> getStudents(int Roll);


}
