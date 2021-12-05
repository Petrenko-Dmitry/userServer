package com.example.userserver.repository;

import com.example.userserver.entity.ColorArticle;
import com.example.userserver.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    Long countAllBy();

    List<Users> findAllByAgeAfter(Integer age);

    @Query("select u from Users u inner join u.article c where c.color = :colorArticle")
    List<Users> findAllByColor(ColorArticle colorArticle);

    @Query("select u from Users u inner join u.article c where count(c)>3 ")
    List<Users> findAllByCount();
}
