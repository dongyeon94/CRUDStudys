package com.example.root.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
    private int age;
    private boolean sex;

}
