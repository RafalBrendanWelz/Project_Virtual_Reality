package Simulation;

import Mechanics.Position;
import WORLD.World;
import WORLD.WorldMap;

import java.util.Iterator;
import java.util.Map;

public class SimulationDrawService {
    private static SimulationDrawService INSTANCE;

    private SimulationDrawService() {
    }

    public static SimulationDrawService getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new SimulationDrawService();
        }
        return INSTANCE;
    }

    public void drawMap(final Simulation swiat){
        drawSimulatInterface(swiat);
        Map<Position, String> graphData = swiat.getSwiatSymulacji().createGraphics();

        drawHorizontalBorder(swiat.getSwiatSymulacji().getMapa());
        Iterator<Map.Entry<Position, String>> obiekty = graphData.entrySet().iterator();

        for (int i = 0; i < swiat.getSwiatSymulacji().getMapa().getSizeY(); i++) {
            System.out.print( "| " );
            for (int j = 0; j < swiat.getSwiatSymulacji().getMapa().getSizeX(); j++) {
                System.out.print( obiekty.next().getValue() );
                System.out.print( " | " );
            }
            System.out.println(" ");
        }
        drawHorizontalBorder(swiat.getSwiatSymulacji().getMapa());

    }
    private void drawSimulatInterface(final Simulation simulation) {
        System.out.println("Game Turn = " + simulation.getTuraNum());
        System.out.println("            MAP         ");
    }
    private void drawHorizontalBorder(final WorldMap mapa){
        for (int i = 0; i < mapa.getSizeX()+1; i++) {
            System.out.print("-");
        }
        System.out.println(" ");
    }



}
