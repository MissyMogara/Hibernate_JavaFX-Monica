package org.proyect.hibernatejavafx.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity //Mark as entity
@Getter //Autogenerate Getters with lombok
@Setter //Autogenerate Setters with lombok
@AllArgsConstructor //Constructor with all args with lombok
@NoArgsConstructor // Constructor without args with lombok
public class Player {
    //PROPERTIES
    @Id //Mark as ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement value
    private Long id;

    private String name;

    @Column(length = 50, nullable = false)
    private String nick;

    @Column(unique = true)
    private String email;

    private String language;

    @ManyToOne(fetch = FetchType.EAGER)
    private VideoGame favoriteVideoGame;

    private String country;

    //CONSTRUCTOR
    public Player(String name, String nick, String email, String language, String country){
        this.name = name;
        this.nick = nick;
        this.email = email;
        this.language = language;
        this.country = country;
    }


    //TO STRING
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Player{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", nick='").append(nick).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
