package Mechanics;

import MainMenu.ProgramConstants;
import WORLD.WorldMap;
import lombok.Getter;

@Getter
public class Position implements Comparable{
    private final int x;
    private final int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isNeighbourWith(final Position withThis){
        if (Math.sqrt(this.getX() - withThis.getX()) <= 1    &&  Math.sqrt(this.getY() - withThis.getY()) <= 1){
            return this.getX() != withThis.getX() || this.getY() != withThis.getY();
        }else {
            return false;
        }
    }
    public boolean isNthLayerNeighbourWith(final Position withThis, final int nLayer){
        if (nLayer > ProgramConstants.getMAX_POSIT_NEIGH_SAFE()){
            throw new IllegalArgumentException("Function \"isNthLayerNeighbourWith\" started on " + nLayer + " layer search, where max limit for it is " + ProgramConstants.getMAX_POSIT_NEIGH_SAFE()
                    + "\n Function stoped to avoid excessive searching ");
        }

        if (Math.sqrt(this.getX() - withThis.getX()) != Math.sqrt(nLayer) && Math.sqrt(this.getX() - withThis.getX()) != 0 ){
            return false;
        }else if (Math.sqrt(this.getY() - withThis.getY()) != Math.sqrt(nLayer) && Math.sqrt(this.getY() - withThis.getY()) != 0){
            return false;
        }else return this.getX() != withThis.getX() || this.getY() != withThis.getY();
    }


    @Override
    public boolean equals(Object drugiObject) {
        if (this == drugiObject) {
            return true;
        }
        if (drugiObject instanceof Position) {
            Position drugaPos = (Position) drugiObject;
            return (this.getX() == drugaPos.getX() && this.getY() == drugaPos.getY());
        }
        return false;
    }
    @Override
    public String toString(){
        return "X:" + this.getX() + " Y:" + this.getY();
    }

    @Override
    public int compareTo(final Object o) {
        if (o instanceof Position){
            Position druga = (Position) o;
            if (this.getY() > druga.getY()){
                return 1;
            }else if (this.getY() < druga.getY()){
                return -1;
            }else {
                return compareInRowX(druga);
            }
        }else {
            return 0;
        }
    }
    private int compareInRowX(final Position druga){
        return Integer.compare(this.getX(), druga.getX());
    }


}
