package org.proyect.hibernatejavafx.javafxcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.proyect.hibernatejavafx.View;
import org.proyect.hibernatejavafx.ViewSwitcher;
import org.proyect.hibernatejavafx.entities.Player;
import org.proyect.hibernatejavafx.repositories.PlayerRepository;
import org.proyect.hibernatejavafx.repositories.VideoGameRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {

    public void toMenu(){
        ViewSwitcher.switchTo(View.MENU);
    }

    @FXML
    private TableView<Player> playerTable;
    @FXML
    public TableColumn<Player, Long> playerId;
    @FXML
    public TableColumn<Player, String> playerName;
    @FXML
    public TableColumn<Player, String> playerNick;
    @FXML
    public TableColumn<Player, Integer> playerEmail;
    @FXML
    public TableColumn<Player, String> playerLanguage;
    @FXML
    public TableColumn<Player, String> playerCountry;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //CALL HIBERNATE TO GET PLAYERS
        PlayerRepository pl = new PlayerRepository();
        List<Player> players = pl.findAll();

        players.forEach(System.out::println);

        //"id" ATTRIBUTE NAME IN THE PLAYER CLASS
        playerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        playerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        playerNick.setCellValueFactory(new PropertyValueFactory<>("nick"));
        playerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        playerLanguage.setCellValueFactory(new PropertyValueFactory<>("language"));
        playerCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        playerTable.setItems(FXCollections.observableArrayList(players));

    }
}
