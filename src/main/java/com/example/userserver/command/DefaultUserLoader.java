package com.example.userserver.command;

import com.example.userserver.entity.Role;
import com.example.userserver.entity.UserAuthorization;
import com.example.userserver.repository.UserAuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DefaultUserLoader implements CommandLineRunner {
    @Autowired
    private UserAuthorizationRepository userAuthorizationRepository;

    @Override
    public void run(String... args) {
        long count = userAuthorizationRepository.count();
        if (count < 1) {
            UserAuthorization user = new UserAuthorization("admin", "admin", Role.ADMIN);
            userAuthorizationRepository.save(user);
        }
    }
}
