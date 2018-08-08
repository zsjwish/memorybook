package com.zsj.study.dao;

import com.zsj.study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * created by zsj in 21:02 2018/8/8
 * description:
 **/
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    User getUserByName(String name);

    User getUserByEmail(String Email);

    User save(User user);

    void deleteByEmail(String email);



}
