package com.basic.crud.Repository;

import com.basic.crud.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<Teacher,Long> {
}
