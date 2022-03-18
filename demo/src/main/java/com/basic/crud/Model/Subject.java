package com.basic.crud.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(
            name = "Student_Enrolled",//Name of the new union table
            joinColumns = @JoinColumn(name = "subject_id"), //Name FK of the one column owner of the relationship
            inverseJoinColumns = @JoinColumn(name = "student_id")//Name FK of the other column
    )
    Set<Student> enrolledStudents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id", //Name of FK of column
            referencedColumnName = "id")//Name of column that takes the reference
    Teacher teacher;
}
