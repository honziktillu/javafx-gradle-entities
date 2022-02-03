package com.example.javafxgradle;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Entity {

    private double x;
    private double y;
    private double w;
    private double h;
    private float v;
    private Paint c;

    public Entity(double x, double y, double w, double h, Paint c, float v) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
        this.v = v;
    }

    public void update(ArrayList<String> input, Canvas canvas) {
        if (input.contains("w")) {
            setY(getY() - v);
            if (y + h < 0) {
                y = canvas.getHeight() - v;
            }
        }
        if (input.contains("s")) {
            setY(getY() + v);
            if (y > canvas.getHeight()) {
                y = -h + v;
            }
        }
        if (input.contains("a")) {
            setX(getX() - v);
            if (x + w < 0) {
                x = canvas.getWidth() - v;
            }
        }
        if (input.contains("d")) {
            setX(getX() + v);
            if (x > canvas.getWidth()) {
                x = -w + v;
            }
        }
    }

    public void render(GraphicsContext gc) {
        gc.setFill(c);
        gc.fillRect(x, y, w, h);
    }

    public float getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Paint getC() {
        return c;
    }

    public void setC(Paint c) {
        this.c = c;
    }
}
