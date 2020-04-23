package Plants;

import Mechanics.CollisionEffect;
import Mechanics.CollisionObject;
import Mechanics.Position;
import ObjectsSpecifications.ObjectStatistics;
import WORLD.MapObject;
import WORLD.World;

public abstract class Plant extends MapObject {

    public Plant(final World swiat, final ObjectStatistics stats) {
        super(swiat, stats);
    }

    @Override
    public boolean reactToCollision(final CollisionEffect whatHappens, final CollisionObject whoDoesThat) {
        return true;
    }

    @Override
    public String getDrawSymbol() {
        return this.getStatystyki().getName();
    }

    @Override
    public void makeAction(){

    }

}
