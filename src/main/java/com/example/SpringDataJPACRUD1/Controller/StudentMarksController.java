package com.example.SpringDataJPACRUD1.Controller;

import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import com.example.SpringDataJPACRUD1.Service.StudentMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentmarks")

public class StudentMarksController {
    @Autowired
    private StudentMarksService studentMarksService;
    @PostMapping
    public StudentMarks createMarks(@RequestBody StudentMarks studentMarks){
        return studentMarksService.saveMarks(studentMarks);
    }
}
