package org.proyect.hibernatejavafx.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity //Mark as entity
@Getter //Autogenerate Getters with lombok
@Setter //Autogenerate Setters with lombok
@AllArgsConstructor //Constructor with all args with lombok
@NoArgsConstructor // Constructor without args with lombok
@ToString // Method to String with lombok
public class VideoGame {
    //PROPERTIES
    @Id //Mark as ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement value
    private Long id;

    private String name;

    private String plataform;

    private Integer pegi;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(50) default null")
    @Cascade(CascadeType.ALL)
    private Category category;

    //CONSTRUCTOR
    public VideoGame(String name, String plataform, Integer pegi, Category category){
        this.name = name;
        this.plataform = plataform;
        this.pegi = pegi;
        this.category = category;
    }
}
