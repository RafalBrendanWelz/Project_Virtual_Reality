package Simulation;

import WORLD.MapObject;
import WORLD.World;
import lombok.Getter;

@Getter
public class Simulation {
    private int turaNum;
    private World swiatSymulacji;

    public Simulation(final int turaNum, final World swiatSymulacji) {
        this.turaNum = turaNum;
        this.swiatSymulacji = swiatSymulacji;
    }

    void makeTurn(){
        this.turaNum++;
        SimulationDrawService.getINSTANCE().drawMap(this);
        swiatSymulacji.getALLObjects().forEach( MapObject::makeAction );
    }


}
