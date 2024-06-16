package com.example.SpringDataJPACRUD1.Service;

import com.example.SpringDataJPACRUD1.Entity.Student;
import com.example.SpringDataJPACRUD1.Entity.StudentMarks;
import com.example.SpringDataJPACRUD1.Entity.StudentPK;
import com.example.SpringDataJPACRUD1.Exception.ResourceNotFound;
import com.example.SpringDataJPACRUD1.Repository.StudentRepository;
import com.example.SpringDataJPACRUD1.ServiceImpl.ServiceImplementation;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private ServiceImplementation studentService;
    private Student student;
    private List<StudentMarks> studentMarks;
    //private StudentService studentService;
    @BeforeEach
    public void setup(){
        //studentRepository= Mockito.mock(StudentRepository.class);
        //studentService=new ServiceImplementation(studentRepository);
        studentRepository.deleteAll();

        studentMarks = Arrays.asList(StudentMarks.builder()
                        .marks(89)
                        .subject("English")
                        .id(71).build(),
                StudentMarks.builder()
                        .marks(84)
                        .subject("Maths")
                        .id(72).build());

         student=Student.builder()
                .studentPK(StudentPK.builder()
                        .roll(1)
                        .dob("2005-12-17")
                        .build())
                .firstName("Ahana")
                .lastName("Singh")
                .studentMarks(studentMarks)
                .build();
    }

    //JUnit test for saveStudent method
    @Test
    public void givenStudentObject_whenSave_thenReturnStudent(){

        //given
        given(studentRepository.save(student)).willReturn(student);
        System.out.println(studentRepository);
        System.out.println(studentService);

        //when
        Student savedStudent=studentService.saveStudent(student);
        System.out.println(savedStudent);

        //then
        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.getStudentMarks().size()).isEqualTo(2);
    }

    //JUnit test to get students by primary key
    @Test
    public void givenStudentObject_whenFindByPK_thenReturnStudent(){

        //given
        given(studentRepository.save(student)).willReturn(student);
        System.out.println(studentRepository);
        System.out.println(studentService);
        Student student1=studentService.saveStudent(student);
       given(studentRepository.findById(new StudentPK(student1.getStudentPK().getRoll(),student1.getStudentPK().getDob())))
               .willReturn(Optional.of(student1));

        //when
        Student student2=studentService.getStudentByID(1,"2005-12-17");
        System.out.println(student2);



        //then
        assertThat(student2).isNotNull();


    }

    //JUnit test to get students by primary key(False condition checking to test exception)
    @Test
    public void givenStudentObject_whenFindByFalsePK_thenReturnStudent(){

        //given
        given(studentRepository.save(student)).willReturn(student);
        studentService.saveStudent(student);
        Student savedStudent=studentService.saveStudent(student);

        //when
        StudentPK studentPK= StudentPK.builder()
                .roll(2)
                .dob("2004-12-17")
                .build();

        given(studentRepository.findById(studentPK))
                .willReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFound.class,()->{
            studentService.getStudentByID(2,"2004-12-17");
        });

        //then
        verify(studentRepository).findById(studentPK);


    }

    //JUnit test to get all students
    @Test
    public void givenStudentObject_whenFindAll_thenReturnStudent(){

       List<StudentMarks> studentMarks1 = Arrays.asList(StudentMarks.builder()
                        .marks(77)
                        .subject("English")
                        .id(74).build(),
                StudentMarks.builder()
                        .marks(98)
                        .subject("Maths")
                        .id(75).build());

        Student student1=Student.builder()
                .studentPK(StudentPK.builder()
                        .roll(2)
                        .dob("2007-01-17")
                        .build())
                .firstName("Ankita")
                .lastName("Singh")
                .studentMarks(studentMarks)
                .build();

        //given
        given(studentRepository.findAll()).willReturn(List.of(student,student1));

        //when
        List<Student> studentList=studentService.getAllStudent();

        //then
        assertThat(studentList).isNotNull();
        assertThat(studentList.size()).isEqualTo(2);


    }
}
