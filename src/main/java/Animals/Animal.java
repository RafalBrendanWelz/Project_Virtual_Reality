package Animals;

import Events.AI.Goals;
import Events.Actions.Action;
import Exceptions.BrakMetodyAct;
import MainMenu.ProgramConstants;
import Mechanics.CollisionEffect;
import Mechanics.CollisionObject;
import Mechanics.Path;
import ObjectsSpecifications.ObjectStatistics;
import WORLD.MapObject;
import ObjectsSpecifications.Moveable;
import WORLD.World;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Animal extends MapObject implements Moveable{
    private boolean czyRoslinozerca;
    private Path ImOnMyWay;

    public Animal(final World przynaleznosc, final ObjectStatistics stats, final boolean roslinTrueMiesoFalse) {
        super(przynaleznosc, stats);
        this.czyRoslinozerca = roslinTrueMiesoFalse;
        this.setCurrentGoal(Goals.EAT);
        this.ImOnMyWay = null;
    }

    @Override
    public boolean reactToCollision(final CollisionEffect whatHappens, final CollisionObject whoDoesThat) {
        return true;
    }

    @Override
    public void makeAction(){
        if ( this.getMyWay().isPresent() ){
            continuePathAction();
        }else {
            makeNewActionNewGoal();
        }
    }
    private void continuePathAction(){

    }
    private void makeNewActionNewGoal(){
        super.makeAction();
    }

    @Override
    public String getDrawSymbol() {
        return this.getStatystyki().getName();
    }

    @Override
    public Optional<Path> getMyWay(){
        if (this.ImOnMyWay == null){
            return Optional.empty();
        }else {
            return Optional.of(this.ImOnMyWay);
        }
    }
    @Override
    public void setNewWay(final Path myWayNew){
        this.ImOnMyWay = myWayNew;
    }

    public boolean isCzyRoslinozerca() {
        return czyRoslinozerca;
    }


}
