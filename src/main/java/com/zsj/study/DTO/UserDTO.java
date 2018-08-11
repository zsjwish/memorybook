package com.zsj.study.DTO;

import com.zsj.study.model.User;
import lombok.NonNull;

import javax.persistence.Column;
import java.util.Date;

/**
 * created by zsj in 20:54 2018/8/11
 * description:
 **/
public class UserDTO {
    private long id;

    private String name;

    private String password;

    private String nickName;

    private String phone;

    private String email;

    private String address;

    private String company;

    private Date registerDate;

    private Date lastLoginDate;

    private User toOrder(UserDTO userDTO) {
        return null;
    }
}
