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

    public Student findByFAndLName(String f,String l){
        return studentRepository.findByFirstNameAndLastName(f,l);
    }

    public void deleteByRoll(int Roll){
        studentRepository.deleteById(Roll);
    }
}
