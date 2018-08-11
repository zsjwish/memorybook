package com.zsj.study.model;

import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by zsj in 13:43 2018/8/11
 * description:
 **/
@Entity
@Value
public class LoginTicket {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "expired")
    private Date expired;

    @Column(name = "status")
    private int status;
}
