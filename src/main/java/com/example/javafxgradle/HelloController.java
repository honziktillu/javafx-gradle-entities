package com.example.javafxgradle;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Canvas canvas;
    public AnchorPane mainLayout;
    GraphicsContext gc;
    Entity myEntity;
    AnimationTimer mainLoop;
    ArrayList<Entity> entities;
    ArrayList<String> input;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        entities = new ArrayList<>();
        input = new ArrayList<>();
        myEntity = new Entity(10, 10, 20, 30, Paint.valueOf("PINK"), 10.1f);
        spawnEntities(10);
        gc = canvas.getGraphicsContext2D();
        Platform.runLater(() -> {
            mainLayout.requestFocus();
        });
        mainLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //clear canvas
                clearCanvas();

                //update l
                update();

                //render
                render();
            }
        };
        mainLoop.start();
    }

    private void clearCanvas() {
        gc.setFill(Paint.valueOf("WHITE"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void update() {
        myEntity.update(input);
    }

    private void render() {
        myEntity.render(gc);
        entities.forEach(obj -> {
            obj.render(gc);
        });
    }

    private void spawnEntities(int n) {
        for (int i = 0; i < n; i++) {
            entities.add(new Entity(generate(0, canvas.getWidth()), generate(0, canvas.getHeight()), generate(10, 30), generate(10, 30), Paint.valueOf("PINK"), 1.1f));
        }
    }

    private int generate(int min, double max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (!input.contains(keyEvent.getText())) {
            input.add(keyEvent.getText());
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        input.remove(keyEvent.getText());
    }
}