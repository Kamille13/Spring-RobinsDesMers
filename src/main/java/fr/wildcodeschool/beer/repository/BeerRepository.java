package fr.wildcodeschool.beer.repository;

import fr.wildcodeschool.beer.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

}
