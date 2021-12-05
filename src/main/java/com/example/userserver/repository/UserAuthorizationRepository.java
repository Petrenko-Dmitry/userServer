package com.example.userserver.repository;

import com.example.userserver.entity.UserAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorizationRepository extends JpaRepository<UserAuthorization, Long> {
    UserAuthorization findByLogin(String login);
}
