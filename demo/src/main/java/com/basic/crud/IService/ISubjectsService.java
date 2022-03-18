package com.basic.crud.IService;

import com.basic.crud.Model.Student;
import com.basic.crud.Model.Subject;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ISubjectsService {
    public Subject saveSubject(Subject subject);
    public Page<Subject> getAllSubjects (Integer page, Integer size, Boolean enablePagination);
    public void deleteSubject(Long id);
    public Student editSubject (Subject subject);
    public boolean existById(Long id);
    public Optional<Subject> findById(Long id);
}
