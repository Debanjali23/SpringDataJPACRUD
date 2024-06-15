package com.example.SpringDataJPACRUD1.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @EmbeddedId
    private StudentPK studentPK;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(referencedColumnName = "roll"),
            @JoinColumn(referencedColumnName = "dob")
    })
    @MapsId("studentPK")
    private List<StudentMarks> studentMarks;
}
