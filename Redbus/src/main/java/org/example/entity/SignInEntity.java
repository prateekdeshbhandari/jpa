package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "signIn_info")
@Getter
@Setter
public class SignInEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "email_Id")
    private String email;

    @Column(name = "password")
    private String password;
}
