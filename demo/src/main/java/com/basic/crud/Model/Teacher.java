package com.basic.crud.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.security.auth.Subject;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    private Integer age;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects;
}
