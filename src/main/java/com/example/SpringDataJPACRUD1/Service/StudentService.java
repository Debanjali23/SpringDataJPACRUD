package com.example.SpringDataJPACRUD1.Service;

import com.example.SpringDataJPACRUD1.DTO.StudentDTO;
import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO entityToDto(Student student){
        StudentDTO studentDTO=new StudentDTO();
        studentDTO=modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }

    public StudentDTO saveStudent(Student s){
        StudentDTO studentDTO=entityToDto(studentRepository.save(s));
        return studentDTO;
    }

    public List<StudentDTO> getAll(){

        return studentRepository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public StudentDTO getStudents(int id){

        return studentRepository.findById(id).stream().map(this::entityToDto).findFirst().get();
    }

    public StudentDTO findByFullName(String fname,String lname){

        return studentRepository.findByFullName(fname,lname).stream().map(this::entityToDto).findFirst().get();
    }

    public StudentDTO findByRollAndName(int r,String s){

        return studentRepository.findByNameAndRoll(r,s).stream().map(this::entityToDto).findFirst().get();
    }

    public void deleteByRoll(int Roll){

        studentRepository.deleteById(Roll);
    }

    public void deleteall(){

        studentRepository.deleteAll();
    }
}
