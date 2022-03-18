package com.basic.crud.Controller;

import com.basic.crud.Model.Student;
import com.basic.crud.IServiceImp.IStudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentServiceImp IStudentServiceImp;

    @PostMapping
    public ResponseEntity<Student> saveStudent (@Valid @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(IStudentServiceImp.saveStudent(student));
    }


    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudent (
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination
    ){
        return ResponseEntity.ok(IStudentServiceImp.getAllStudent(page, size, enablePagination));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable ("id") Long id){
        IStudentServiceImp.deleteStudent(id);
        return ResponseEntity.ok(!IStudentServiceImp.existById(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(IStudentServiceImp.findById(id));
    }

    @PutMapping
    public ResponseEntity<Student> editStudent (@Valid @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(IStudentServiceImp.editStudent(student));
    }
}