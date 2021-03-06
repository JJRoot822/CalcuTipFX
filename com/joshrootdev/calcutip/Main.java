package com.joshrootdev.calcutip;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));

        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());

        primaryStage.setResizable(false);
        primaryStage.setTitle("CalcuTip");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
