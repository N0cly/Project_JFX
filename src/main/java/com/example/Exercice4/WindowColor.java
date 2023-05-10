package com.example.Exercice4;

import com.example.Partie2.HelloWindow;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowColor extends Application {

    private Label topLabel;

    private Button btnG;
    private Button btnR;
    private Button btnB;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();



        // create bottom section with status label
        this.topLabel = new Label("Ceci est un label haut de page");
        VBox top = new VBox(topLabel);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(10));
        root.setTop(top);

        Pane paneCenter = new Pane();
        paneCenter.setPrefSize(400,200);
        paneCenter.setStyle("-fx-background-color: white;");

        root.setCenter(paneCenter);

        HBox hbtn = new HBox();

        this.btnG = new Button("Vert");
        this.btnR = new Button("Rouge");
        this.btnB = new Button("Bleu");

        btnG.addEventHandler(MouseEvent.MOUSE_CLICKED, new WindowColor.ButtonClickHandler(btnG, topLabel, paneCenter));
        btnR.addEventHandler(MouseEvent.MOUSE_CLICKED, new WindowColor.ButtonClickHandler(btnR, topLabel, paneCenter));
        btnB.addEventHandler(MouseEvent.MOUSE_CLICKED, new WindowColor.ButtonClickHandler(btnB, topLabel, paneCenter));


        hbtn.setSpacing(10);
        hbtn.setAlignment(Pos.CENTER);
        hbtn.setPadding(new Insets(10));

        hbtn.getChildren().addAll(btnG,btnR, btnB);

        root.setBottom(hbtn);
        // set the scene
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Window Color");
        primaryStage.show();
    }
    public class ButtonClickHandler implements EventHandler<Event> {

        private Label topLabel;
        private String textColor;

        private Pane paneCenter;

        private String color;

        private static int countG = 1;
        private static int countR = 1;
        private static int countB = 1;

        private int count = 0;
        public ButtonClickHandler(Button btn,Label label, Pane pane) {
             this.textColor = btn.getText();
            this.topLabel = label;
            this.paneCenter = pane;

            if(textColor == "Vert"){
                this.color = "green";
                this.count = countG++;
            }
            if(textColor == "Rouge"){
                this.color = "red";
                this.count = countR++;
            }
            if(textColor == "Bleu"){
                this.color = "blue";
                this.count = countB++;
            }
        }

        @Override
        public void handle(Event event) {
            // Utiliser le Label récupéré
            topLabel.setText( textColor+" cliqué "+ count+" fois");
            paneCenter.setStyle("-fx-background-color: "+color+";");
        }
    }
}
