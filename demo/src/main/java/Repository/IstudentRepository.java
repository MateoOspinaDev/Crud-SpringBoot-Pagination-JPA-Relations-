package Repository;

import Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IstudentRepository extends JpaRepository<Student,Long > {

}
