package com.codedotorg;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        TextTrekkers game = new TextTrekkers(primaryStage, 400, 450);
        game.startApp();
    }

}