package com.example.SpringDataJPACRUD1.Response;

import com.example.SpringDataJPACRUD1.DTO.StudentDTO;
import com.example.SpringDataJPACRUD1.Entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntities {

    public ResponseEntity<String> successful(){
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<String> nocontent(){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<String> notfound(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> notacceptable(){
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
