package com.example.SpringDataJPACRUD1.Service;

import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student s){
        return studentRepository.save(s);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student getStudents(int id){
        return studentRepository.findById(id).get();
    }

    public String getStudentByFirstName(String f){
        return "Invalid Input";
    }

    public String getStudentByLastName(String l){
        return "Invalid Input";
    }



    public Student findByFullName(String fname,String lname){
        return studentRepository.findByFullName(fname,lname);
    }

    public Student findByRollAndName(int r,String s){
        return studentRepository.findByNameAndRoll(r,s);
    }

    public void deleteByRoll(int Roll){
        studentRepository.deleteById(Roll);
    }

    public void deleteall(){
        studentRepository.deleteAll();
    }
}
