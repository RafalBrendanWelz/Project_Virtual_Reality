package Player;

import Mechanics.CollisionEffect;
import Mechanics.CollisionObject;
import Mechanics.Path;
import Mechanics.Position;
import ObjectsSpecifications.Moveable;
import ObjectsSpecifications.ObjectStatistics;
import WORLD.MapObject;
import WORLD.World;

public class LastHuman extends MapObject implements Moveable {
    //Controllable Object for Player (only 1 existing)
    public static LastHuman INSTANCE;
    private static final ObjectStatistics HUMAN_STATS = new ObjectStatistics("Human", 5, 3, 7, 2,4);
    private Path currentPathWayAI;

    private LastHuman(final World swiat, final ObjectStatistics stats){
        super(swiat, stats);
    }
    public static LastHuman getINSTANCE(final World swiat){
        if (INSTANCE == null){
            INSTANCE = new LastHuman(swiat, HUMAN_STATS);
        }
        return INSTANCE;
    }

    @Override
    public String getDrawSymbol() {
        return null;
    }

    @Override
    public void makeAction() {

    }

    @Override
    public Path getMyWay() {
        return this.currentPathWayAI;
    }
    @Override
    public void setNewWay(final Path myWayNew) {
        this.currentPathWayAI = myWayNew;
    }

    @Override
    public boolean reactToCollision(final CollisionEffect whatHappens, final CollisionObject whoDoesThat) {
        return false;
    }



}
