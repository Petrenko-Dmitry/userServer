package com.example.userserver.command;

import com.example.userserver.entity.Article;
import com.example.userserver.entity.ColorArticle;
import com.example.userserver.entity.Users;
import com.example.userserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
public class BasicLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        Long count = userRepository.countAllBy();
        if (count < 1) {
            List<Users> usersList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Article article = new Article("text", ColorArticle.RED);
                Article article1 = new Article("text1", ColorArticle.BLACK);
                Article article3 = new Article("text1", ColorArticle.YELLOW);
                Article article4 = new Article("text1", ColorArticle.GREEN);
                String name = "Vasya" + i;
                Users user;
                if (i == 2 || i == 7) {
                    user = new Users(name, i + 10, Arrays.asList(article, article1, article3, article4));
                } else {
                    user = new Users(name, i + 10, Arrays.asList(article, article1));
                }
                usersList.add(user);
            }
            userRepository.saveAll(usersList);
        }
    }
}
