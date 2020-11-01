package org.hibernate.crud.mvc.spring.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@RequiredArgsConstructor
@Component("userBean")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message="First name must be specified.")
    private String name;

    @Column(name = "last_name")
    @NotNull(message="Last name must be specified.")
    private String lastName;

    @Column(name = "age")
    @NotNull(message="Year of birth must be specified.")
    private Integer year;

    public User(String name, String lastName, int year) {
        this.name = name;
        this.lastName = lastName;
        this.year = year;
    }

}


