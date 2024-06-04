package com.example.SpringDataJPACRUD1.DTO;

import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import com.example.SpringDataJPACRUD1.Entity.StudentPK;
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
    private StudentPK studentPK;

    private String firstName;
    private String lastName;
    private List<StudentMarks> studentMarks;
}
