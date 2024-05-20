package org.proyect.hibernatejavafx.javafxcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.proyect.hibernatejavafx.View;
import org.proyect.hibernatejavafx.ViewSwitcher;
import org.proyect.hibernatejavafx.entities.Category;
import org.proyect.hibernatejavafx.entities.VideoGame;
import org.proyect.hibernatejavafx.repositories.VideoGameRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class VideoGameController implements Initializable {

    //PROPERTIES

    private String name;

    private String plataform;

    private Integer pegi;

    private Category category;

    //FXML

    @FXML
    private TextField name_videogame;

    @FXML
    private TextField plataform_videogame;

    @FXML
    private TextField pegi_videogame;

    @FXML
    private TextField category_videogame;

    //ACTIONS

    public void toMenu(){
        ViewSwitcher.switchTo(View.MENU);
    }

    public void insertNewVideoGame(){

        if(name_videogame.getText() != null){
            this.name = name_videogame.getText();
        }

        if(plataform_videogame.getText() != null){
            this.plataform = plataform_videogame.getText();
        }

        if(pegi_videogame.getText() != null) {
            this.pegi = Integer.parseInt(pegi_videogame.getText());
        }
        //CATEGORY
        //ACTION
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("ACTION")){
                this.category = Category.ACTION;
            }
        }
        //STRATEGY
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("STRATEGY")){
                this.category = Category.STRATEGY;
            }
        }
        //SIMULATOR
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("SIMULATOR")){
                this.category = Category.SIMULATOR;
            }
        }
        //RPG
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("RPG")){
                this.category = Category.RPG;
            }
        }
        //PUZZLE
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("PUZZLE")){
                this.category = Category.PUZZLE;
            }
        }
        //FPS
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("FPS")){
                this.category = Category.FPS;
            }
        }
        //MOBA
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("MOBA")){
                this.category = Category.MOBA;
            }
        }
        //BATTLE_ROYALE
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("BATTLE_ROYALE")){
                this.category = Category.BATTLE_ROYALE;
            }
        }
        //ROGUELIKE
        if(category_videogame.getText() != null){
            if (category_videogame.getText().equals("ROGUELIKE")){
                this.category = Category.ROGUELIKE;
            }
        }

        VideoGameRepository videoGameRepository = new VideoGameRepository();
        VideoGame videoGame1 = new VideoGame(this.name,this.plataform,this.pegi, this.category);
        videoGameRepository.insert(videoGame1);
        videoGameRepository.closeSession();
        updateTable();
    }



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

    public void updateTable(){
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
