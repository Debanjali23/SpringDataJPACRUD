package com.example.SpringDataJPACRUD1.Repository;

import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import com.example.SpringDataJPACRUD1.Entity.StudentPK;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class StudentRepositoryTests {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    //we can also define the student object here and use it in every test
    public void setUp() {

        studentRepository.deleteAll(); // Ensure the repository is clean before each test
   }

    //JUnit test for save student operation(BDD Format)
    @Test
    @DisplayName("JUnit test for save student operation")
    public void givenStudentObject_whenSave_thenReturnSavedStudent(){

        List<StudentMarks> studentMarks=Arrays.asList(StudentMarks.builder()
                        .marks(85)
                        .subject("English")
                        .id(1).build(),
                StudentMarks.builder()
                        .marks(87)
                        .subject("Maths")
                        .id(2).build());

        //given-> precondition or setup
        Student student= Student.builder().studentPK(StudentPK.builder()
                        .roll(1)
                        .dob("2001-07-14")
                        .build())
                .firstName("Alice")
                .lastName("Perry")
                .studentMarks(studentMarks)
                .build();

        //when-> action or the behaviour that we are going to test
        Student savedstudent=studentRepository.save(student);

        //then-> verify the output
        assertThat(savedstudent).isNotNull();
        assertThat(savedstudent.getStudentPK().getRoll()).isGreaterThan(0);

    }

    //JUnit test to get all the students
    @Test
    public void givenStudentList_whenFindAll_thenreturnList(){

        //given-> precondition or setup
        List<StudentMarks> studentMarks=Arrays.asList(StudentMarks.builder()
                .marks(85)
                .subject("English")
                .id(10).build(),
                StudentMarks.builder()
                        .marks(87)
                        .subject("Maths")
                        .id(20).build());

        List<StudentMarks> studentMarks1=Arrays.asList(StudentMarks.builder()
                        .marks(75)
                        .subject("English")
                        .id(3).build(),
                StudentMarks.builder()
                        .marks(95)
                        .subject("Maths")
                        .id(4).build());

        Student student1= Student.builder().studentPK(StudentPK.builder()
                        .roll(10)
                        .dob("2002-03-12")
                        .build())
                .firstName("Diana")
                .lastName("Perry")
                .studentMarks(studentMarks)
                .build();

        Student student2= Student.builder().studentPK(StudentPK.builder()
                        .roll(2)
                        .dob("2000-01-25")
                        .build())
                .firstName("John")
                .lastName("Henry")
                .studentMarks((studentMarks1))
                .build();

        studentRepository.save(student1);
        studentRepository.save(student2);

        //when-> action or the behaviour that we are going to test

        List<Student> studentList = studentRepository.findAll();

        //then-> verify the output

        assertThat(studentList).isNotNull();
        assertThat(studentList.size()).isEqualTo(2);

    }

    //Junit test to get a student by Primary Key
    @Test
    public void givenStudentObject_whenFindByID_thenReturnStudent(){

        //given
        List<StudentMarks> studentMarks=Arrays.asList(StudentMarks.builder()
                        .marks(77)
                        .subject("English")
                        .id(11).build(),
                StudentMarks.builder()
                        .marks(84)
                        .subject("Maths")
                        .id(12).build());

        Student student= Student.builder()
                .studentPK(StudentPK.builder()
                        .dob("2004-12-12")
                        .roll(14)
                        .build())
                .firstName("Ayesha")
                .lastName("Singh")
                .studentMarks(studentMarks)
                .build();
        studentRepository.save(student);

        //when
        Student student1=studentRepository.findById(student.getStudentPK()).get();



        //then
        assertThat(student1).isNotNull();

    }

    //Junit test to find a student by full name
    @Test
    public void givenStudentObject_whenFindByFullName_thenReturnStudent() {

        //given
        List<StudentMarks> studentMarks = Arrays.asList(StudentMarks.builder()
                        .marks(89)
                        .subject("English")
                        .id(51).build(),
                StudentMarks.builder()
                        .marks(84)
                        .subject("Maths")
                        .id(52).build());

        Student student = Student.builder()
                .studentPK(StudentPK.builder()
                        .dob("2004-12-17")
                        .roll(18)
                        .build())
                .firstName("Ayushi")
                .lastName("Sinha")
                .studentMarks(studentMarks)
                .build();
        studentRepository.save(student);

        //when
        Student student1 = studentRepository.findByFullName(student.getFirstName(),student.getLastName());


        //then
        assertThat(student1).isNotNull();
    }

    //JUnit test for update Student operation
    @Test
    public void givenStudentObject_whenUpdate_thenReturnStudent() {

        //given
        List<StudentMarks> studentMarks = Arrays.asList(StudentMarks.builder()
                        .marks(89)
                        .subject("English")
                        .id(71).build(),
                StudentMarks.builder()
                        .marks(84)
                        .subject("Maths")
                        .id(72).build());

        Student student = Student.builder()
                .studentPK(StudentPK.builder()
                        .dob("1999-05-04")
                        .roll(21)
                        .build())
                .firstName("Preeti")
                .lastName("Agarwal")
                .studentMarks(studentMarks)
                .build();
        studentRepository.save(student);

        //when
        Student student1 = studentRepository.findById(student.getStudentPK()).get();
        student1.setFirstName("Avanti");
        student1.setStudentPK(new StudentPK(22,"2000-05-04"));
        student1.setStudentMarks(studentMarks);
        Student updatedStudent=studentRepository.save(student1);



        //then
        assertThat(updatedStudent.getFirstName()).isEqualTo("Avanti");
        assertThat(updatedStudent.getStudentPK().getRoll()).isEqualTo(22);
        assertThat(updatedStudent.getStudentPK().getDob()).isEqualTo("2000-05-04");
        assertThat(updatedStudent.getStudentMarks().size()).isEqualTo(2);
    }

    //JUnit test for delete student operation
    @Test
    public void givenStudentObject_whenDelete_thenRemoveStudent() {

        //given
        List<StudentMarks> studentMarks = Arrays.asList(StudentMarks.builder()
                        .marks(89)
                        .subject("English")
                        .id(71).build(),
                StudentMarks.builder()
                        .marks(84)
                        .subject("Maths")
                        .id(72).build());

        Student student = Student.builder()
                .studentPK(StudentPK.builder()
                        .dob("1999-05-04")
                        .roll(21)
                        .build())
                .firstName("Preeti")
                .lastName("Agarwal")
                .studentMarks(studentMarks)
                .build();
        studentRepository.save(student);

        //when
       studentRepository.delete(student);
       Optional<Student> student1=studentRepository.findById(student.getStudentPK());



        //then
        assertThat(student1).isEmpty();
    }

}
