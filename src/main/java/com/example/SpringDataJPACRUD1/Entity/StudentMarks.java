package com.example.SpringDataJPACRUD1.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import javax.security.auth.Subject;
import java.util.List;

@Entity
@Table(name="StudentMarks")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class StudentMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Roll;
    private String subject;
    private double marks;
    //@JdbcTypeCode(SqlTypes.JSON)
//    @ManyToOne
//    @JoinColumn(name = "student_roll")
//    private Student student;
}
