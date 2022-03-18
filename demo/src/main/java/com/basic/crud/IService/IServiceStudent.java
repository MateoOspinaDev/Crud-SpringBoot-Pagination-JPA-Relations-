package com.basic.crud.IService;

import com.basic.crud.Model.Student;
import com.basic.crud.Model.Subject;
import com.basic.crud.Model.Teacher;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IServiceStudent {
    public Student saveStudent(Student student);
    public Page<Student> getAllStudent (Integer page,Integer size,Boolean enablePagination);
    public void deleteStudent(Long id);
    public Student editStudent (Student student);
    public boolean existById(Long id);
    public Optional<Student> findById(Long id);
    public void addSubjecToStudent(Student student, Subject subject);
}
