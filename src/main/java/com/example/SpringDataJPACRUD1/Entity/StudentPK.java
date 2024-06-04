package com.example.SpringDataJPACRUD1.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPK implements Serializable {

        private int RollNo;
        private String dob;
}
