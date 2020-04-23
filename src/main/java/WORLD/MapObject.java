package WORLD;

import Events.AI.Goals;
import Events.Actions.Action;
import Events.Actions.AllActions;
import MainMenu.ProgramConstants;
import Mechanics.CauseOfDeath;
import Mechanics.CollisionObject;
import Mechanics.Position;
import ObjectsSpecifications.ObjectStatistics;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
public abstract class MapObject implements CollisionObject {
    private Position pozycja;
    private boolean isOnMap;
    private boolean isWounded;
    private List<Action> allPossibleActions;
    private Goals currentGoal;

    private World swiatPrzynalezny;
    private ObjectStatistics statystyki;

    public MapObject(final World swiat, final ObjectStatistics stats) {
        this.swiatPrzynalezny = swiat;
        this.statystyki = stats;
        this.isOnMap = false;
        this.isWounded = false;
        allPossibleActions = dajListeAkcji();
    }
    List<Action> dajListeAkcji(){
        List<Action> wynik = new ArrayList<>();
        for (AllActions akcja: AllActions.values()) {
            if ( akcja.getAvailableList().contains(this.getClass()) ){
                wynik.add( akcja.getOdnosnikAkcja() );
            }
        }
        return wynik;
    }
    public abstract String getDrawSymbol();

    public void setCurrentGoal(final Goals nowyCel){
        this.currentGoal = nowyCel;
    }
    public void setPozycja(final Position nowaPosition){
        this.pozycja = nowaPosition;
    }

    void DIE(final CauseOfDeath causeOfDeath){
        this.isOnMap = false;
        this.pozycja = null;
        //wpisz informacje do loga
    }
    void placeOnMap(final Position taPozycja){
        this.pozycja = taPozycja;
        this.isOnMap = true;
    }


    public void makeAction(){
        if (this.getAllPossibleActions().size() > 0){
            List<Action> ToDo = getCurrentGoalActionsList(this);
            ToDo.get(losujAction( ToDo.size() )).Act(this.swiatPrzynalezny, this);
        }
    }
    private List<Action> getCurrentGoalActionsList(final MapObject kogo){
        return kogo.getAllPossibleActions().stream()
                .filter( akc -> akc.getFullfilledGoal().equals(this.getCurrentGoal()) )
                .collect(Collectors.toList());
    }
    private int losujAction(final int iloscAkcji){
        Random losuj = new Random();
        return losuj.nextInt(iloscAkcji);
    }


    public void checkHP(final CauseOfDeath potentialCause){
        if (this.isWounded()){
            this.statystyki.setHP( this.statystyki.getHP()-1 );
        }
        if (this.statystyki.getHP() <= 0){
            this.DIE(potentialCause);
        }
    }


    @Override
    public String toString(){
        return (this.getStatystyki().getName() == null) ? ("Unidentified Object") : (this.getStatystyki().getName()) ;
    }

}
