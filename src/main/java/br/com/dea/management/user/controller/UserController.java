package br.com.dea.management.user.controller;

import br.com.dea.management.user.domain.User;
import br.com.dea.management.user.dto.UserDto;
import br.com.dea.management.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public Page<UserDto> getUsers(@RequestParam(required = true) Integer page,
                                  @RequestParam(required = true) Integer pageSize) {

        Page<User> usersPaged = this.userService.findAllUsersPaginated(page, pageSize);
        Page<UserDto> users = usersPaged.map(user -> UserDto.fromUser(user));

        return users;
    }

    @GetMapping("/user/{email}")
    public UserDto getUserByEmail(@PathVariable(value = "email") String email) {
        log.info(String.format("Fetching user by email : Email : %s", email));
        UserDto user = UserDto.fromUser(this.userService.findUserByEmail(email));
        log.info(String.format("User loaded successfully : User : %s", user));

        return user;
    }
}
