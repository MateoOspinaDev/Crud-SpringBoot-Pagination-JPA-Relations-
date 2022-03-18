package com.basic.crud.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.security.auth.Subject;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    private Integer age;

    @JsonIgnore //Ignora las entidades secundarias directamente, cuando se convierta a JSON no transforme las entidades secundarias
    @ManyToMany(mappedBy = "enrolledStudents")//Nombre de la variable que está referenciando en la otra clase
    private Set<Subject> subjects = new HashSet<>();

    @Embedded
    private ParentStudent parentStudent;


}


