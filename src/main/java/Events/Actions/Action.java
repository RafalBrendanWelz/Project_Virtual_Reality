package Events.Actions;

import Events.AI.Goals;
import Animals.Animal;
import Events.Event;
import WORLD.MapObject;
import WORLD.World;
import WORLD.WorldMap;
import lombok.Getter;

@Getter
public abstract class Action implements Event {
    Goals fullfilledGoal;

    public Action(final Goals fullfilledGoal) {
        this.fullfilledGoal = fullfilledGoal;
    }

    public abstract void Act(final World swiat, final MapObject wykonawca);
    //public abstract void MakeNewAct(final World swiat, final MapObject wykonawca); //older idea

}
