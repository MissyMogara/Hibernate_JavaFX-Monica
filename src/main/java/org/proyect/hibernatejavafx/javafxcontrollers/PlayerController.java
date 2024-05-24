package org.proyect.hibernatejavafx.javafxcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.proyect.hibernatejavafx.View;
import org.proyect.hibernatejavafx.ViewSwitcher;
import org.proyect.hibernatejavafx.entities.Category;
import org.proyect.hibernatejavafx.entities.Player;
import org.proyect.hibernatejavafx.entities.VideoGame;
import org.proyect.hibernatejavafx.repositories.PlayerRepository;
import org.proyect.hibernatejavafx.repositories.VideoGameRepository;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {

    //PROPERTIES

    private String name;
    private String nick;
    private String email;
    private String language;
    private String country;



    //FXML

    @FXML
    private TextField name_player;
    @FXML
    private TextField nick_player;
    @FXML
    private TextField email_player;
    @FXML
    private TextField language_player;
    @FXML
    private TextField country_player;
    @FXML
    private TextArea longestNickPlayer;


    @FXML
    private TableView<Player> playerTable;
    @FXML
    public TableColumn<Player, Long> playerId;
    @FXML
    public TableColumn<Player, String> playerName;
    @FXML
    public TableColumn<Player, String> playerNick;
    @FXML
    public TableColumn<Player, String> playerEmail;
    @FXML
    public TableColumn<Player, String> playerLanguage;
    @FXML
    public TableColumn<Player, String> playerCountry;



    /**
     * This method change the scene to Menu scene.
     */
    public void toMenu(){
        ViewSwitcher.switchTo(View.MENU);
    }

    /**
     * This method insert a new player.
     */
    public void insertNewPlayer(){


        if(name_player != null){
            this.name = name_player.getText();
        }
        if(nick_player != null){
            this.nick = nick_player.getText();
        }
        if(email_player != null){
            this.email = email_player.getText();
        }
        if(language_player != null){
            this.language = language_player.getText();
        }
        if(country_player != null){
            this.country = country_player.getText();
        }
        PlayerRepository playerRepository = new PlayerRepository();
        Player player1 = new Player(this.name,this.nick,this.email, this.language, this.country);
        playerRepository.insert(player1);
        playerRepository.closeSession();
        updateTable();
    }

    /**
     * This method remove the last player created.
     */
    public void deletePlayer(){
        PlayerRepository playerRepository = new PlayerRepository();
        List<Player> players = playerRepository.findAll();

        playerRepository.delete(playerRepository.findById(players.stream().count()));
        updateTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //CALL HIBERNATE TO GET PLAYERS
        PlayerRepository pl = new PlayerRepository();
        List<Player> players = pl.findAll();


        //"id" ATTRIBUTE NAME IN THE PLAYER CLASS
        playerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        playerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        playerNick.setCellValueFactory(new PropertyValueFactory<>("nick"));
        playerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        playerLanguage.setCellValueFactory(new PropertyValueFactory<>("language"));
        playerCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        playerTable.setItems(FXCollections.observableArrayList(players));

        pl.closeSession();

    }

    public void updateTable(){
        PlayerRepository pl = new PlayerRepository();
        List<Player> players = pl.findAll();


        playerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        playerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        playerNick.setCellValueFactory(new PropertyValueFactory<>("nick"));
        playerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        playerLanguage.setCellValueFactory(new PropertyValueFactory<>("language"));
        playerCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        playerTable.setItems(FXCollections.observableArrayList(players));

        pl.closeSession();
    }

    public void searchLongestNickPlayer(){
        PlayerRepository playerRepository = new PlayerRepository();

        List<Player> players = playerRepository.findAll();

        Player longestPlayer = players.stream().max(Comparator.comparing(p -> p.getNick().length())).get();

        longestNickPlayer.setText(longestPlayer.getNick() + " " + "Have " + longestPlayer.getNick().length() + " letters");

        playerRepository.closeSession();
    }

}
