package org.proyect.hibernatejavafx;

public enum View {
    MENU("menu-view.fxml"),
    VIDEOGAMES("videogames-view.fxml"),
    PLAYERS("players-view.fxml"),
    GAMES("games-view.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }

}
