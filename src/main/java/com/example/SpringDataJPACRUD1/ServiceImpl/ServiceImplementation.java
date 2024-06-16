package com.example.SpringDataJPACRUD1.ServiceImpl;

import com.example.SpringDataJPACRUD1.DTO.StudentRequest;
import com.example.SpringDataJPACRUD1.DTO.StudentResponse;
import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Entity.StudentPK;
import com.example.SpringDataJPACRUD1.Exception.ResourceNotFound;
import com.example.SpringDataJPACRUD1.Repository.StudentRepository;
import com.example.SpringDataJPACRUD1.Response.ResponseEntities;
import com.example.SpringDataJPACRUD1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceImplementation implements StudentService {
    //@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ResponseEntities responseEntities;
    @Autowired//constructor injection
    public ServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

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
    public String saveStudents(Student s){
       studentRepository.save(s);
        return "success";
    }

    @Override//for testing purpose
    public Student saveStudent(Student s){
        Student student=studentRepository.save(s);
        return student;
    }

    @Override
    public List<StudentResponse> getAll(){

        List<Student> student= studentRepository.findAll();
        List<StudentResponse> studentResponses=student.stream()
                .map(responseEntities::entityToDto)
                .collect(Collectors.toList());
        return studentResponses;
    }

    @Override
    public List<Student> getAllStudent(){

        List<Student> student= studentRepository.findAll();
//        List<StudentResponse> studentResponses=student.stream()
//                .map(responseEntities::entityToDto)
//                .collect(Collectors.toList());
        return student;
    }
    @Override
    public StudentResponse getStudentsByID(int Roll, String dob){
      Student student= studentRepository.findById(new StudentPK(Roll,dob))
              .orElseThrow(
               ()->new ResourceNotFound("Student","Roll",Roll)
       );
//        if(student==null) return null;
        return responseEntities.entityToDto(student);
    }

    @Override//for testing purpose
    public Student getStudentByID(int Roll, String dob){
        Student student= studentRepository.findById(new StudentPK(Roll,dob))
                .orElseThrow(
                        ()->new ResourceNotFound("Student","Roll",Roll)
                );
//        if(student==null) return null;
        return student;
    }

    @Override
    public StudentResponse getStudents(int Roll){

        Student student= studentRepository.getByRoll(Roll);
        if(student==null) return null;
        return  responseEntities.entityToDto(student);
    }
    @Override
    public StudentResponse findByFullName(String fname,String lname){

       Student student= studentRepository.findByFullName(fname,lname);
       if(student==null) return null;
       return responseEntities.entityToDto(student);
    }
    @Override
    public StudentResponse findByRollAndName(int r,String s){

        Student student= studentRepository.findByNameAndRoll(r,s);
        if(student==null) return null;
        return responseEntities.entityToDto(student);
    }
    @Override
    public Student updateID(int id){
        Student student1= studentRepository.getByRoll(id);
        if(student1==null) return null;
        student1.setFirstName("Mary");
        return studentRepository.save(student1);
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
