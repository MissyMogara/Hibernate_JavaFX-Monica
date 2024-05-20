package org.proyect.hibernatejavafx.javafxcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.proyect.hibernatejavafx.entities.Game;
import org.proyect.hibernatejavafx.entities.Player;
import org.proyect.hibernatejavafx.repositories.GameRepository;
import org.proyect.hibernatejavafx.repositories.PlayerRepository;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private TableView<Game> gameTable;
    @FXML
    public TableColumn<Player, Long> gameId;
    @FXML
    public TableColumn<Player, LocalDateTime> gameHour;
    @FXML
    public TableColumn<Player, Integer> gameDuration;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //CALL HIBERNATE TO GET PLAYERS
        GameRepository gm = new GameRepository();
        List<Game> games = gm.findAll();

        games.forEach(System.out::println);

        //"id" ATTRIBUTE NAME IN THE PLAYER CLASS
        gameId.setCellValueFactory(new PropertyValueFactory<>("id"));
        gameHour.setCellValueFactory(new PropertyValueFactory<>("dateHourMatch"));
        gameDuration.setCellValueFactory(new PropertyValueFactory<>("matchDuration"));

        gameTable.setItems(FXCollections.observableArrayList(games));
    }
}
