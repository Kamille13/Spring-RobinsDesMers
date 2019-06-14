package fr.wildcodeschool.robinsdesmers.repository;

import fr.wildcodeschool.robinsdesmers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long >{

}
