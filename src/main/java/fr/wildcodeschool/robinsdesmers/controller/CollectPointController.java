package fr.wildcodeschool.robinsdesmers.controller;

import fr.wildcodeschool.robinsdesmers.model.CollectPoint;
import fr.wildcodeschool.robinsdesmers.model.User;
import fr.wildcodeschool.robinsdesmers.repository.CollectPointRepository;
import fr.wildcodeschool.robinsdesmers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollectPointController {

    @Autowired
    private CollectPointRepository collectPointRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/{userId}/collectpoints")
    public CollectPoint create(@PathVariable Long userId,
                               @RequestBody CollectPoint collectPoint) {
        User user = userRepository.findById(userId).get();
        collectPoint.setUser(user);
        return collectPointRepository.save(collectPoint);
    }


    @GetMapping("/collectpoints/{id}")
    public CollectPoint read(@PathVariable Long id) {
        return collectPointRepository.findById(id).get();
    }

    @PostMapping("/collectpoints")
    public CollectPoint create(@RequestBody CollectPoint collectPoint) {
        return collectPointRepository.save(collectPoint);
    }

    @PutMapping("/collectpoints/{id}")
    public CollectPoint update(@PathVariable Long id, @RequestBody CollectPoint collectPoint) {
        CollectPoint collectPointToUpdate = collectPointRepository.findById(id).get();
        if (collectPoint.getInfoCollectPoint() != null) {
            collectPointToUpdate.setInfoCollectPoint(collectPoint.getInfoCollectPoint());
        }
        if (collectPoint.getLatitude() != null) {
            collectPointToUpdate.setLatitude(collectPoint.getLatitude());
        }
        return collectPointRepository.save(collectPointToUpdate);
    }

    @DeleteMapping("/collectpoints/{id}")
    public void delete(@PathVariable Long id) {
        collectPointRepository.deleteById(id);
    }
}
