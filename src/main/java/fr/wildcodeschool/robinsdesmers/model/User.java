package fr.wildcodeschool.robinsdesmers.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private Integer score;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Rubbish> rubbishes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<CollectPoint> collectPoints;


    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Rubbish> getRubbishes() {
        return rubbishes;
    }

    public void setRubbishes(List<Rubbish> rubbishes) {
        this.rubbishes = rubbishes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CollectPoint> getCollectPoints() {
        return collectPoints;
    }

    public void setCollectPoints(List<CollectPoint> collectPoints) {
        this.collectPoints = collectPoints;
    }
}
