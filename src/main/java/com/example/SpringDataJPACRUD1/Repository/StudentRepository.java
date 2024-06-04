package com.example.SpringDataJPACRUD1.Repository;

import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Entity.StudentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface StudentRepository extends JpaRepository<Student, StudentPK> {
    @Query("Select s from Student s where s.firstName= :firstName and s.lastName= :lastName")
    public Optional<Student> findByFullName(@Param("firstName") String f_name, @Param("lastName") String l_name);

    @Query("Select s from Student s where s.Roll= :Roll and s.firstName= :firstName")
    public Optional<Student> findByNameAndRoll(@Param("Roll") int roll,@Param("firstName") String f_name);
    @Modifying
    @Query("Delete from Student s where s.Roll= :Roll")
    public void deletebyRoll(@Param("Roll") int r);

    @Query("Select s from Student s where s.Roll= :Roll" )
    public Optional<Student> getByRoll(@Param("Roll") int r);
}
