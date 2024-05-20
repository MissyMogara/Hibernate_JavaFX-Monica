package org.proyect.hibernatejavafx.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity //Mark as entity
@Getter //Autogenerate Getters with lombok
@Setter //Autogenerate Setters with lombok
@AllArgsConstructor //Constructor with all args with lombok
@NoArgsConstructor // Constructor without args with lombok
@ToString // Method to String with lombok
public class Game {
    @Id //Mark as ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement value
    private Long id;

    private LocalDateTime dateHourMatch;
    private Integer matchDuration;

    @ManyToOne
    private VideoGame videoGame;

    @ManyToOne
    private Player winner;

    @ManyToMany
    @JoinTable(name = "Game_Players",
        joinColumns = @JoinColumn(name = "Game_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "Player_id", referencedColumnName = "id"))
    private List<Player> playerList;

    //CONSTRUCTOR
    public Game(LocalDateTime dateHourMatch, Integer matchDuration){
        this.dateHourMatch = dateHourMatch;
        this.matchDuration = matchDuration;
    }
}
