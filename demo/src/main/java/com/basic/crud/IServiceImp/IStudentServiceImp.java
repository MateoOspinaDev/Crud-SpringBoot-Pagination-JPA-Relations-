package com.basic.crud.IServiceImp;

import com.basic.crud.Model.Student;
import com.basic.crud.Repository.IstudentRepository;
import com.basic.crud.IService.IServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IStudentServiceImp implements IServiceStudent {
    @Autowired
    private IstudentRepository istudentRepository;

    @Override
    public Student saveStudent (Student student){
        if (student.getId() == null){
            return istudentRepository.save(student);
        }
        return null;
    }

    //Return a student page
    @Override
    public Page<Student> getAllStudent (Integer page, //page number of request
                                        Integer size, //size of page (number of data in the page)
                                        Boolean enablePagination){
        return istudentRepository.findAll(enablePagination //If enable pagination is true
                ? PageRequest.of(page, size) //request of pagination (with page and size)
                : Pageable.unpaged()); //
    }

    @Override
    public void deleteStudent(Long id){
        istudentRepository.deleteById(id);
    }

    @Override
    public Student editStudent (Student student){
        if (student.getId() != null && istudentRepository.existsById(student.getId())){
            return istudentRepository.save(student);
        }
        return null;
    }
    @Override
    public boolean existById(Long id) {
        return istudentRepository.existsById(id);
    }
    @Override
    public Optional<Student> findById(Long id){
        return istudentRepository.findById(id);
    }
}
