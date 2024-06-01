package com.example.SpringDataJPACRUD1.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Student")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Roll;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    //@Column(nullable = false)
    @Column
    private String dob;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "Roll")
    private List<StudentMarks> studentMarks;
}
