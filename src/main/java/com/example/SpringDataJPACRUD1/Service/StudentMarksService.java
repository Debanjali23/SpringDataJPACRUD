package com.example.SpringDataJPACRUD1.Service;

import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import com.example.SpringDataJPACRUD1.Repository.StudentMarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class StudentMarksService {
    @Autowired
    private StudentMarksRepository studentMarksRepository;

    public StudentMarks saveMarks(StudentMarks studentMarks){
        return (StudentMarks) studentMarksRepository.save(studentMarks);
    }

    public List<StudentMarks> getStudentMarks(){
        return studentMarksRepository.findAll();
    }
}
