package com.example.Exercice1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ManipConteneurs extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException{

        Pane MainWindow = new Pane();


        Menu menu1 = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem closeItem = new MenuItem("Close");
        //menu1.getItems().setAll(newItem, openItem, saveItem, closeItem);
        menu1.getItems().addAll(newItem,new SeparatorMenuItem(),openItem,new SeparatorMenuItem(),saveItem,new SeparatorMenuItem(),closeItem);


        Menu menu2 = new Menu("Edit");
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        menu2.getItems().setAll(cutItem,new SeparatorMenuItem(), copyItem,new SeparatorMenuItem(), pasteItem);


        Menu menu3 = new Menu("Help");

        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);

        menuBar.setPrefWidth(800);


        Pane panCenter = new Pane();

        GridPane pan = new GridPane();
        // marge interne de la scène
        pan.setPadding(new Insets(20, 20, 20, 20));
        pan.setAlignment( Pos.CENTER_RIGHT);
        // Création des labels username & password
        Label lblName = new Label("Name   :   ");
        Label lblMail = new Label("Email  :   ");
        Label lblPass  = new Label("Password");

        pan.setPrefSize(400,600);
        pan.setAlignment(Pos.CENTER_RIGHT);

        pan.setLayoutX(200);

        MainWindow.setPrefSize(800,600);

        // Création des champs de texte
        TextField name = new TextField();
        TextField email = new TextField();
        PasswordField pass = new PasswordField();

        // Ajout des nodes à la scène
        pan.add(lblName ,0,0);
        pan.add(lblMail, 0, 1);
        pan.add(lblPass, 0, 2);
        pan.add(name, 1, 0);
        pan.add(email, 1, 1);
        pan.add(pass, 1, 2);
        pan.setVgap(10);

        Button button = new Button("Se Connecter");

        button.setMaxWidth(200);
        pan.add(button, 1,3);


        VBox buttonControl = new VBox();

        VBox.setVgrow(buttonControl, Priority.ALWAYS);
        buttonControl.setAlignment(Pos.CENTER_LEFT);
        Label txtBtn = new Label("Boutons : ");
        Button btn1 = new Button("Bouton 1");
        Button btn2 = new Button("Bouton 2");
        Button btn3 = new Button("Bouton 3");
        buttonControl.getChildren().addAll(txtBtn,btn1,btn2,btn3);

        buttonControl.setPrefSize(200,600);
        buttonControl.setSpacing(10);
        buttonControl.setPadding(new Insets(10, 10, 10, 10));

        panCenter.getChildren().addAll(
                buttonControl,
                pan
        );

        MainWindow.getChildren().addAll(
                panCenter,
                menuBar
        );

        Scene scene = new Scene(MainWindow);

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Forms");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}