package fr.wildcodeschool.robinsdesmers.repository;

import fr.wildcodeschool.robinsdesmers.model.Rubbish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubbishRepository extends JpaRepository<Rubbish, Long> {
}
