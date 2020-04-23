package WORLD;

import Animals.Animal;
import Mechanics.Position;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Getter
public class WorldMap {
    private int sizeX;
    private int sizeY;
    private final int MAX_LIMIT_OBJECTS;
    private List<Position> emptyPositions;
    private List<Position> ALLPositions;

    WorldMap(final int sizeX, final int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.MAX_LIMIT_OBJECTS = sizeX * sizeY;
        this.ALLPositions = listAllPositions(sizeX, sizeY);
        this.emptyPositions = new LinkedList<>(this.ALLPositions);
    }
    private List<Position> listAllPositions(final int sizeX, final int sizeY){
        List<Position> wynik = new LinkedList<>();
        for (int i = 0; i <= sizeX; i++) {
            for (int j = 0; j <= sizeY ; j++) {
                wynik.add(new Position(i, j));
            }
        }
        return wynik;
    }

    public Optional<Position> getNextEmptyPosition(){
        if (this.emptyPositions.iterator().hasNext()){
            return Optional.of(this.emptyPositions.iterator().next());
        }else {
            return Optional.empty();
        }
    }
    public boolean placeObject(final MapObject tenObjekt){
        if (tenObjekt.isOnMap()){
            return false;
        }
        if (this.emptyPositions.iterator().hasNext()){
            Position toBeTaken = this.emptyPositions.iterator().next();
            tenObjekt.placeOnMap( toBeTaken );
            this.emptyPositions.remove(toBeTaken);
            return true;
        }
        return false;
    }


    public boolean regainPositionFromObject(final MapObject tenObjekt){
        if (tenObjekt.isOnMap()){
            this.emptyPositions.add(tenObjekt.getPozycja());
            return true;
        }else {
            return false;
        }
    }
    public Optional<Position> giveAwayEmptyPosition(final Position takaPosition){
        if (this.emptyPositions.contains(takaPosition)){
            this.emptyPositions.remove(takaPosition);
            return Optional.of(takaPosition);
        }else {
            return Optional.empty();
        }
    }

    public boolean isPositionOutOfMap(final Position taPozycja){
        return (taPozycja.getY() > this.sizeY || taPozycja.getX() > sizeX);
    }

}
