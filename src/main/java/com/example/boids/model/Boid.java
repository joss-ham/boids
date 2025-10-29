package com.example.boids.model;

public class Boid {
    //declare attributes
    private double x;
    private double y;

    private double vx;
    private double vy;

    private double id;

    public Boid(double x, double y, double vx, double vy, double id) {
        //constructor
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.id = id;
    }
    //getters
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getVx() {
        return vx;
    }
    public double getVy() {
        return vy;
    }
    public double getId() {
        return id;
    }
    //setters
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setVx(double vx) {
        this.vx = vx;

    }
    public void setVy(double vy) {
        this.vy = vy;
    }
    public void setId(double id) {
        this.id = id;
    }

}
