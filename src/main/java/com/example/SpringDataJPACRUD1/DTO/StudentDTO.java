package com.example.SpringDataJPACRUD1.DTO;

import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class StudentDTO {
    private int Roll;
    private String firstName;
    private String lastName;
    private String dob;
    private List<StudentMarks> studentMarks;
}
