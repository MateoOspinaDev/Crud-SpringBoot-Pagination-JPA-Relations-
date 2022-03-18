package com.basic.crud.IService;

import com.basic.crud.Model.Student;
import com.basic.crud.Model.Subject;
import com.basic.crud.Model.Teacher;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IServiceTeacher {
    public Student saveTeacher(Teacher teacher);
    public Page<Teacher> getAllTeachers (Integer page, Integer size, Boolean enablePagination);
    public void deleteTeacher(Long id);
    public Student editTeacher (Teacher teacher);
    public boolean existById(Long id);
    public Optional<Teacher> findById(Long id);
    public void addSubjecToTeacher(Teacher teacher, Subject subject);
}
