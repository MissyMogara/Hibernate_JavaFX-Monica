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
import org.proyect.hibernatejavafx.entities.Game;
import org.proyect.hibernatejavafx.entities.Player;
import org.proyect.hibernatejavafx.repositories.GameRepository;
import org.proyect.hibernatejavafx.repositories.PlayerRepository;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    //PROPERTIES
    private LocalDateTime dateHourMatch;
    private Integer matchDuration;


    //FXML
    @FXML
    private TextField dateHourGame;
    @FXML
    private TextField durationGame;
    @FXML
    private TextArea theLongestMatchDuration;



    @FXML
    private TableView<Game> gameTable;
    @FXML
    public TableColumn<Game, Long> gameId;
    @FXML
    public TableColumn<Game, LocalDateTime> gameHour;
    @FXML
    public TableColumn<Game, Integer> gameDuration;


    //METHODS
    /**
     * This method insert a new player.
     */
    public void insertNewGame(){


        if(dateHourGame != null){
            this.dateHourMatch = LocalDateTime.parse(dateHourGame.getText());
        }
        if(durationGame != null){
            this.matchDuration = Integer.parseInt(durationGame.getText());
        }
        GameRepository gr = new GameRepository();
        Game game1 = new Game(dateHourMatch, matchDuration);
        gr.insert(game1);
        gr.closeSession();
        updateTable();
    }

    /**
     * This method remove the last player created.
     */
    public void deleteGame(){
        GameRepository gr = new GameRepository();
        List<Game> games = gr.findAll();

        gr.delete(gr.findById(games.stream().count()));
        updateTable();
    }

    /**
     * This method change the scene to Menu scene.
     */
    public void toMenu(){
        ViewSwitcher.switchTo(View.MENU);
    }

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
        gm.closeSession();
    }

    public void updateTable(){
        //CALL HIBERNATE TO GET PLAYERS
        GameRepository gm = new GameRepository();
        List<Game> games = gm.findAll();


        //"id" ATTRIBUTE NAME IN THE PLAYER CLASS
        gameId.setCellValueFactory(new PropertyValueFactory<>("id"));
        gameHour.setCellValueFactory(new PropertyValueFactory<>("dateHourMatch"));
        gameDuration.setCellValueFactory(new PropertyValueFactory<>("matchDuration"));

        gameTable.setItems(FXCollections.observableArrayList(games));
        gm.closeSession();
    }

    public void longestMatchDuration(){
        GameRepository gm = new GameRepository();
        List<Game> games = gm.findAll();

        theLongestMatchDuration.setText(games.stream().sorted(Comparator.comparing(Game::getMatchDuration).reversed())
                .findFirst().get().getId().toString());

        gm.closeSession();
    }
}
