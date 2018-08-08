package com.zsj.study.model;

import lombok.NonNull;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by zsj in 20:39 2018/8/8
 * description:
 **/
@Entity
@Value
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "company")
    private String company;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "last_login_date")
    private Date lastLoginDate;
}
