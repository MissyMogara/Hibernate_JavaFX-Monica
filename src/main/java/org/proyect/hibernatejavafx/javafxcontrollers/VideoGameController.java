package org.proyect.hibernatejavafx.javafxcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.proyect.hibernatejavafx.entities.VideoGame;
import org.proyect.hibernatejavafx.repositories.VideoGameRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class VideoGameController implements Initializable {


    @FXML
    private TableView<VideoGame> videoGameTable;
    @FXML
    public TableColumn<VideoGame, Long> videoGameId;
    @FXML
    public TableColumn<VideoGame, String> videoGameName;
    @FXML
    public TableColumn<VideoGame, String> videoGamePlataform;
    @FXML
    public TableColumn<VideoGame, Integer> videoGamePegi;
    @FXML
    public TableColumn<VideoGame, String> videoGameCategory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //CALL HIBERNATE TO GET VIDEOGAMES
        VideoGameRepository vr = new VideoGameRepository();
        List<VideoGame> videoGames = vr.findAll();

        videoGames.forEach(System.out::println);

        //"id" ATTRIBUTE NAME IN THE VIDEOGAME CLASS
        videoGameId.setCellValueFactory(new PropertyValueFactory<>("id"));
        videoGameName.setCellValueFactory(new PropertyValueFactory<>("name"));
        videoGamePlataform.setCellValueFactory(new PropertyValueFactory<>("plataform"));
        videoGamePegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));
        videoGameCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        videoGameTable.setItems(FXCollections.observableArrayList(videoGames));



    }

}
