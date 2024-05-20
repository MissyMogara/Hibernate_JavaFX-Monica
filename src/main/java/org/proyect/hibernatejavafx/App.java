package org.proyect.hibernatejavafx;

import jakarta.transaction.Transactional;
import org.proyect.hibernatejavafx.entities.Category;
import org.proyect.hibernatejavafx.entities.VideoGame;
import org.proyect.hibernatejavafx.entities.Player;
import org.proyect.hibernatejavafx.repositories.PlayerRepository;
import org.proyect.hibernatejavafx.repositories.VideoGameRepository;


public class App {
    @Transactional
    public static void main(String[] args) {

        //Create repository
        PlayerRepository playerRepository = new PlayerRepository();
        VideoGameRepository videoGameRepository = new VideoGameRepository();

        Player player1 = new Player("Miqota","Miqotilla","MiqoMiqo@gmail.com","Spanish","Spain");

        VideoGame videoGame1 = new VideoGame("OW2","Steam",12, Category.ACTION);

        player1.setFavoriteVideoGame(videoGame1);

        playerRepository.insert(player1);
        videoGameRepository.insert(videoGame1);

        //Close repository
        playerRepository.closeSession();
        videoGameRepository.closeSession();

    }
}
