package com.example.SpringDataJPACRUD1.Repository;

import com.example.SpringDataJPACRUD1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("Select s from Student s where s.firstName= :firstName and s.lastName= :lastName")
    public Student findByFullName(@Param("firstName") String f_name,@Param("lastName") String l_name);

    @Query("Select s from Student s where s.Roll= :Roll and s.firstName= :firstName")
    public Student findByNameAndRoll(@Param("Roll") int roll,@Param("firstName") String f_name);
}
