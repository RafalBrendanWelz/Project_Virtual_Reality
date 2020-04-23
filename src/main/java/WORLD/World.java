package WORLD;


import Animals.Animal;
import MainMenu.WorldStartSettings;
import Mechanics.Position;
import Plants.Plant;
import Player.LastHuman;
import lombok.Getter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class World {
    private WorldMap mapa;
    private List<Animal> ALLLivingAnimals;
    private List<Plant> ALLExistingPlants;
    private List<MapObject> ALLObjects;
    private LastHuman HumanHeroForPlayer;

    public World(final WorldStartSettings ustawSwiat) {
        this.ALLLivingAnimals = new ArrayList<>();
        this.ALLExistingPlants = new ArrayList<>();
        this.ALLObjects = new ArrayList<>();
        this.mapa = new WorldMap(ustawSwiat.getSizeX(), ustawSwiat.getSizeY() );
        WorldStartService.getINSTANCE(this).startSpawner(ustawSwiat);

    }

    public List<Animal> giveAllNeighbourAnimals(final MapObject seeker ){
        return this.ALLLivingAnimals.stream()
                .filter(new Predicate<Animal>() {
                    @Override
                    public boolean test(final Animal animal) {
                        return  animal.getPozycja().isNeighbourWith(seeker.getPozycja());
                    }
                }).collect(Collectors.toList());
    }

    public Map<Position, String> createGraphics(){
        // this.ALLObjects.forEach(obj -> System.out.println(obj.getPozycja() + " : " + obj + " : is on map = " + obj.isOnMap()) );
        //for test

        Map<Position, String> justObjectGraphs = this.ALLObjects.stream()
                .collect(Collectors.toMap(MapObject::getPozycja, MapObject::getDrawSymbol) );

        Map<Position, String> emptyGraphs = this.getMapa().getEmptyPositions().stream()
                .collect(Collectors.toMap(poz -> poz , poz -> "     ") );

        Map<Position, String> wynik = new TreeMap<>();
        wynik.putAll(justObjectGraphs);
        wynik.putAll(emptyGraphs);

        return wynik;
    }



}
