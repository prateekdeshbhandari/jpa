package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
    @Setter
    @Entity
    @Table(name="signUp_info")

    public class SingUpEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;

        @Column(name="name")
        private String name;

        @Column(name="email")
        private String email;

        @Column(name="password")
        private String password;
    }

