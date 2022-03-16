package Service;

import Model.Student;
import Repository.IstudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private IstudentRepository istudentRepository;

    public Student saveStudent(Student student){
        if(student.getId()!=null) istudentRepository.save(student);
        return null;
    }

    //Return a student page
    public Page<Student> getAllStudent (Integer page, //page number of request
                                        Integer size, //size of page (number of data in the page)
                                        Boolean enablePagination){
        return istudentRepository.findAll(enablePagination //If enable pagination is true
                ? PageRequest.of(page, size) //request of pagination (with page and size)
                : Pageable.unpaged()); //
    }

    public void deleteStudent(Long id){
        istudentRepository.deleteById(id);
    }

    public Student editStudent (Student student){
        if (student.getId() != null && istudentRepository.existsById(student.getId())){
            return istudentRepository.save(student);
        }
        return null;
    }
    public boolean existById(Long id) {
        return istudentRepository.existsById(id);
    }
    public Optional<Student> findById(Long id){
        return istudentRepository.findById(id);
    }
}
