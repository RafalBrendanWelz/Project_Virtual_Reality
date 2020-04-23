package Simulation;

import WORLD.World;

public class SimulationMain {
    private static Simulation symulacja;

    public static void start(final World CreatedWorld){
        symulacja = new Simulation(0, CreatedWorld);
        symulacja.makeTurn();
        for (int i = 0; i < 10; i++) {
            nextTurn();
        }
    }
    private static void nextTurn(){
        symulacja.makeTurn();
    }



}
