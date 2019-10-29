package com.example.student.repository;

import com.example.student.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findBysid(Long sid);

    @Transactional
    void  deleteBySid(Long sid);

}
