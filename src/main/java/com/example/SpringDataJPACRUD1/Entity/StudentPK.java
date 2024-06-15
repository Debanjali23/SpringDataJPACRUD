package com.example.SpringDataJPACRUD1.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class StudentPK implements Serializable {

        private int roll;
        private String dob;



}
