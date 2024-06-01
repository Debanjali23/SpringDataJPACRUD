package com.example.SpringDataJPACRUD1.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor

public class StudentMarksDTO {
    private int Roll;
    private String subject;
    private double marks;
}
