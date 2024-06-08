package com.example.SpringDataJPACRUD1.DTO;

import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import com.example.SpringDataJPACRUD1.Entity.StudentPK;
import lombok.Data;

import java.util.List;

@Data


public class StudentResponse {
    private StudentPK studentPK;

    private String firstName;
    private String lastName;
    private List<StudentMarks> studentMarks;
}
