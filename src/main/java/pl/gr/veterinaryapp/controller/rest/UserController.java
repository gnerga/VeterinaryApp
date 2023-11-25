package pl.gr.veterinaryapp.controller.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gr.veterinaryapp.mapper.VetAppUserMapper;
import pl.gr.veterinaryapp.model.dto.UserDto;
import pl.gr.veterinaryapp.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/users")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;
    private final VetAppUserMapper mapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info("Get list of all users");
        var user =  mapper.mapAsList(userService.getAllUsers());
        log.info("Return list of all users: {}", user);
        return user;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        log.info("Create new user: {}", user);
        var createdUser = mapper.map(userService.createUser(user));
        log.info("Return created user: {}", createdUser);
        return createdUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        log.info("Remove user with id: {}", id);
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id) {
        log.info("Get user with id: {}", id);
        var user = mapper.map(userService.getUser(id));
        log.info("Return user: {}", user);
        return user;
    }
}
