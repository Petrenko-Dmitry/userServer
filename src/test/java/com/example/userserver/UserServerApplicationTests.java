package com.example.userserver;

import com.example.userserver.converter.UsersToUserDto;
import com.example.userserver.dto.UserDto;
import com.example.userserver.entity.Article;
import com.example.userserver.entity.ColorArticle;
import com.example.userserver.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;

@SpringBootTest
class UserServerApplicationTests {
    @Autowired
    private UsersToUserDto usersToUserDto;

    @Test
    void converterUsersToUserDto() {
        Article article = new Article("text", ColorArticle.RED);
        Article article1 = new Article("text1", ColorArticle.BLACK);
        Users user = new Users("Vasya0", 10, Arrays.asList(article, article1));
        user.setId(1L);

        UserDto userDto = usersToUserDto.convert(user);

        Assert.isTrue(userDto != null, "userDto not be Null");
        Assert.isTrue(userDto.getId().equals(user.getId()), "id not equals");
        Assert.isTrue(userDto.getName().equals(user.getName()), "name not equals");
        Assert.isTrue(userDto.getAge().equals(user.getAge()), "age not equals");
        Assert.isTrue(userDto.getArticle().equals(user.getArticle()), "article not equals");
    }

}
