package com.example.boids.controller;

import com.example.boids.model.Boid;
import com.example.boids.model.InitRequest;
import com.example.boids.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/boids")
public class BoidController {
    @Autowired
    private SimulationService simulationService;

    @PostMapping("/init")
    public List<Boid> initialize(@RequestBody InitRequest request) {
        return simulationService.initBoids(request.getCount());
    }

    @PostMapping("/step")
    public List<Boid> step(){
        return simulationService.step();
    }
    @GetMapping
    public List<Boid> getState() {
        return simulationService.getState();
    }
}
