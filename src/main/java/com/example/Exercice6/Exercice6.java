package com.example.Exercice6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercice6 extends Application {


    Dico mot= new Dico();

    private String motSecret = mot.getMot();


    private int viesRestantes = 7;
    private StringBuilder motActuel;

    private Label labelMotActuel;
    private Label labelViesRestantes;
    private TextField textFieldLettre;
    private ImageView imageViewPendu;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        System.out.println(motSecret);
        // Création de l'image du pendu
        Image imagePendu = new Image(getClass().getResourceAsStream("pendu7.png"));
        imageViewPendu = new ImageView(imagePendu);
        root.setCenter(imageViewPendu);

        // Création du label pour le mot actuel
        labelMotActuel = new Label();
        labelMotActuel.setTextFill(Color.BLACK);
        root.setTop(labelMotActuel);

        // Création du TextField pour les lettres disponibles
        textFieldLettre = new TextField();
        textFieldLettre.setPrefWidth(200);
        textFieldLettre.setOnAction(event -> {
            String lettre = textFieldLettre.getText().toLowerCase();
            textFieldLettre.clear();
            verifierLettre(lettre);
        });
        root.setLeft(textFieldLettre);

        // Création du label pour le nombre de vies restantes
        labelViesRestantes = new Label("Vies restantes : " + viesRestantes);
        root.setRight(labelViesRestantes);

        // Affichage de la fenêtre
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Jeu du Pendu");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initialisation du mot actuel avec des tirets
        motActuel = new StringBuilder();
        for (int i = 0; i < motSecret.length(); i++) {
            motActuel.append("-");
        }
        labelMotActuel.setText(motActuel.toString());
    }

    private void verifierLettre(String lettre) {
        boolean lettreTrouvee = false;
        for (int i = 0; i < motSecret.length(); i++) {
            if (Character.toString(motSecret.charAt(i)).equals(lettre)) {
                motActuel.setCharAt(i, lettre.charAt(0));
                lettreTrouvee = true;
            }
        }

        if (!lettreTrouvee) {
            viesRestantes--;
            mettreAJourImagePendu();
        }

        if (viesRestantes == 0) {
            finPartie(false);
            labelViesRestantes.setText("Vies restantes : 0");
        } else if (motActuel.indexOf("-") == -1) {
            finPartie(true);
        } else {
            labelMotActuel.setText(motActuel.toString());
            labelViesRestantes.setText("Vies restantes : " + viesRestantes);
        }
    }

    private void mettreAJourImagePendu() {
        int indexImage = 0 + viesRestantes;
        Image imagePendu = new Image(getClass().getResourceAsStream("pendu" + indexImage + ".png"));
        imageViewPendu.setImage(imagePendu);

    }

    private void finPartie(boolean victoire) {
        textFieldLettre.setDisable(true);

        if (victoire) {
            labelMotActuel.setText("Bravo ! Vous avez trouvé le mot : " + motActuel.toString());
            imageViewPendu.setImage(new Image(getClass().getResourceAsStream("penduWin.png")));
        } else {
            labelMotActuel.setText("Dommage ! Le mot était : " + motSecret);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
