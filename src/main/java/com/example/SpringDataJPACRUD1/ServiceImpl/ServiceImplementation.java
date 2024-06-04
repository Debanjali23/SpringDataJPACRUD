package com.example.SpringDataJPACRUD1.ServiceImpl;

import com.example.SpringDataJPACRUD1.DTO.StudentDTO;
import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Entity.StudentPK;
import com.example.SpringDataJPACRUD1.Repository.StudentRepository;
import com.example.SpringDataJPACRUD1.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Override
//    public StudentDTO entityToDto(Student student){
//        StudentDTO studentDTO=new StudentDTO();
//        studentDTO=modelMapper.map(student, StudentDTO.class);
//        return studentDTO;
//    }
    @Override
    public Student saveStudents(Student s){
        Student student=(studentRepository.save(s));
        return student;
    }
    @Override
    public List<Student> getAll(){

        return studentRepository.findAll();
    }
    @Override
    public Optional<Student> getStudentsByID(int Roll,String dob){
        return studentRepository.findById(new StudentPK(Roll,dob));
    }

    @Override
    public Optional<Student> getStudents(int Roll){
        return studentRepository.getByRoll(Roll);
    }
    @Override
    public Optional<Student> findByFullName(String fname,String lname){

        return studentRepository.findByFullName(fname,lname);
    }
    @Override
    public Optional<Student> findByRollAndName(int r,String s){

        return studentRepository.findByNameAndRoll(r,s);
    }
    @Override
    public void deleteByRoll(int Roll){

        studentRepository.deletebyRoll(Roll);
    }
    @Override
    public void deleteall(){

        studentRepository.deleteAll();
    }
}
