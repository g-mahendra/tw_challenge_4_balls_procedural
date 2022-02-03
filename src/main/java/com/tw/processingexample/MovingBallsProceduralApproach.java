package com.tw.processingexample;

import processing.core.PApplet;

import java.util.ArrayList;

class Ball {
    private int xCoordinate;
    private int yCoordinate;
    private int diameter;
    private int speed;
    private PApplet drawingProvider;
    int ballSpeed = 1;

    Ball(int xCoordinate, int yCoordinate, int diameter, int speed, PApplet drawingProvider) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.speed = speed;
        this.diameter = diameter;
        this.drawingProvider = drawingProvider;
    }

    public void drawAndMoveBall() {
        drawingProvider.ellipse(this.xCoordinate, this.yCoordinate, this.diameter, this.diameter);
        this.xCoordinate += speed;
    }
}

public class MovingBallsProceduralApproach extends PApplet {

    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;

    ArrayList<Ball> balls;

    public static void main(String[] args) {
        PApplet.main("com.tw.processingexample.MovingBallsProceduralApproach");
    }

    @Override
    public void settings() {
        super.settings();
        size(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    @Override
    public void setup() {
        super.setup();
        balls = new ArrayList<>();
        for (int iterator = 0; iterator < 4; iterator++) {
            balls.add(new Ball(0, (iterator + 1) * WINDOW_HEIGHT / 5, 15, iterator + 1, this));
        }
    }

    @Override
    public void draw() {
        balls.forEach(Ball::drawAndMoveBall);
    }
}
