package fr.wildcodeschool.robinsdesmers.controller;

import fr.wildcodeschool.robinsdesmers.model.User;
import fr.wildcodeschool.robinsdesmers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> read() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User read(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User userToUpdate = userRepository.findById(id).get();
        if (user.getName() != null) {
            userToUpdate.setName(user.getName());
        }
        if (user.getScore() != null) {
            userToUpdate.setScore(user.getScore());
        }
        return userRepository.save(userToUpdate);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
