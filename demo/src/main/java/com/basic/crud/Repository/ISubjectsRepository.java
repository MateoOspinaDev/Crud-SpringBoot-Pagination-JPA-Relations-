package com.basic.crud.Repository;

import com.basic.crud.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectsRepository extends JpaRepository<Subject,Long> {
}
