package com.example.Exercice5;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercice5 extends Application {
    private static final int TILE_SIZE = 50;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private int pacManX = 0;
    private int pacManY = 0;

    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane(canvas);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> handleKeyPress(e.getCode()));
        scene.setOnKeyReleased(e -> handleKeyRelease(e.getCode()));

        primaryStage.setTitle("Pac-Man");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render(gc);
            }
        };
        timer.start();
    }

    private void update() {
        if (isMovingUp && pacManY > 0) {
            pacManY -= TILE_SIZE;
        } else if (isMovingDown && pacManY < HEIGHT - TILE_SIZE) {
            pacManY += TILE_SIZE;
        } else if (isMovingLeft && pacManX > 0) {
            pacManX -= TILE_SIZE;
        } else if (isMovingRight && pacManX < WIDTH - TILE_SIZE) {
            pacManX += TILE_SIZE;
        }
    }

    private void render(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.YELLOW);
        gc.fillOval(pacManX, pacManY, TILE_SIZE, TILE_SIZE);
    }

    private void handleKeyPress(KeyCode code) {
        switch (code) {
            case UP:
                isMovingUp = true;
                break;
            case DOWN:
                isMovingDown = true;
                break;
            case LEFT:
                isMovingLeft = true;
                break;
            case RIGHT:
                isMovingRight = true;
                break;
        }
    }

    private void handleKeyRelease(KeyCode code) {
        switch (code) {
            case UP:
                isMovingUp = false;
                break;
            case DOWN:
                isMovingDown = false;
                break;
            case LEFT:
                isMovingLeft = false;
                break;
            case RIGHT:
                isMovingRight = false;
                break;
        }
    }
}
