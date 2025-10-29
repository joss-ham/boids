# Boids Simulation (Spring Boot + MVC)

A learning project built to explore **Spring Boot** and **Spring MVC** architecture
through a simulation of emergent flocking behavior (Boids).

---

##  Goals

- Practice clean MVC design in Spring Boot
- Separate simulation logic (Model) from controllers (Web API)
- Optionally visualize the simulation in a frontend

---

## Architecture Overview

Controller (SimulationController)
v
Service(SimulationService)
v
Model(SimulationState, Boid, Vector2D)
