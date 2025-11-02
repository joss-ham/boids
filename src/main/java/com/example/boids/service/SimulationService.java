package com.example.boids.service;


import com.example.boids.model.Boid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class SimulationService {
    Random random = new Random();
    private List<Boid> boids;
    private final double width = 800;
    private final double height = 600;

    public  List<Boid> initBoids(int count) {
        boids = new ArrayList<>();
        int idCounter = 0;
        for (int i = 0; i < count; i++) {
            int newX = random.nextInt(800);
            int newY = random.nextInt(600);
            int newVx = random.nextInt(-2,2);
            int newVy = random.nextInt(-2,2);
            int newId = idCounter++;
            boids.add(new Boid(newX,newY,newVx,newVy,newId));
        }
        return boids;
    }

    public List<Boid> step(){
            for (Boid boid : boids){
                double x = boid.getX();
                x += boid.getVx();
                double y = boid.getY();
                y += boid.getVy();

                //check in bounds
                if(x < 0){x = width+x;}
                if(x>width){x = width-x;};
                if(y < 0){y = height+y;}
                if(y > height){y =  height-y;};

                boid.setX(x);
                boid.setY(y);
            }
        return boids;
    }
    public List<Boid> getState(){
        return boids;
    }
}
