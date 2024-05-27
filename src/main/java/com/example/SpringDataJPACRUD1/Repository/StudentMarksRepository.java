package com.example.SpringDataJPACRUD1.Repository;

import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentMarksRepository extends JpaRepository<StudentMarks,Integer> {
}
