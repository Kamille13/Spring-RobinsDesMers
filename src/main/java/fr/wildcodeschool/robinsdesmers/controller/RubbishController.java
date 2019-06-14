package fr.wildcodeschool.robinsdesmers.controller;

import fr.wildcodeschool.robinsdesmers.model.Rubbish;
import fr.wildcodeschool.robinsdesmers.model.User;
import fr.wildcodeschool.robinsdesmers.repository.RubbishRepository;
import fr.wildcodeschool.robinsdesmers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RubbishController {

    @Autowired
    private RubbishRepository rubbishRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/{userId}/rubbishes")
    public Rubbish create(@PathVariable Long userId,
                          @RequestBody Rubbish rubbish) {
        User user = userRepository.findById(userId).get();
        rubbish.setUser(user);
        return rubbishRepository.save(rubbish);
    }


    @GetMapping("/rubbishes/{id}")
    public Rubbish read(@PathVariable Long id) {
        return rubbishRepository.findById(id).get();
    }

    @PostMapping("/rubbishes")
    public Rubbish create(@RequestBody Rubbish rubbish) {
        return rubbishRepository.save(rubbish);
    }

    @PutMapping("/rubbishes/{id}")
    public Rubbish update(@PathVariable Long id, @RequestBody Rubbish rubbish) {
        Rubbish rubbishToUpdate = rubbishRepository.findById(id).get();
        if (rubbish.getInfoRubbish() != null) {
            rubbishToUpdate.setInfoRubbish(rubbish.getInfoRubbish());
        }
        if (rubbish.getLatitude() != null) {
            rubbishToUpdate.setLatitude(rubbish.getLatitude());
        }
        return rubbishRepository.save(rubbishToUpdate);
    }

    @DeleteMapping("/rubbishes/{id}")
    public void delete(@PathVariable Long id) {
        rubbishRepository.deleteById(id);
    }
}
