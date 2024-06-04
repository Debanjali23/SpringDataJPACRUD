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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @EmbeddedId
    private StudentPK Roll;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    //@Column(nullable = false)

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(referencedColumnName = "RollNo"),
            @JoinColumn(referencedColumnName = "dob")
    })
    @MapsId("Roll")
    private List<StudentMarks> studentMarks;
}
