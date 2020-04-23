package Events.Actions;

import Animals.Animal;
import Animals.Wilk;
import Events.Event;
import Plants.Plant;
import Player.LastHuman;
import lombok.Getter;

import java.util.List;

@Getter
public enum AllActions implements Event {
    HUNT(List.of(Animal.class, LastHuman.class, Wilk.class), new Hunt()),
    AVOID_PREDAT(List.of(Animal.class), new Hunt()),
    PLANT_EAT(List.of(Animal.class, LastHuman.class), new Hunt()),
    GROWTH(List.of(Animal.class, LastHuman.class, Plant.class), new Hunt()),
    STAND_GROUND(List.of(Animal.class, LastHuman.class), new Hunt()),
    BREED(List.of(Animal.class, LastHuman.class), new Hunt() ),
    HEAL(List.of(Plant.class, LastHuman.class), new Hunt()),
    MOVEMENT(List.of(Animal.class, LastHuman.class), new Hunt()),
    SPORE_SPRAY(List.of(Plant.class), new Hunt()),
    RECOVERY(List.of(Animal.class, Plant.class), new Hunt());

    private List<Class> AvailableList;
    private Action OdnosnikAkcja;

    AllActions(final List<Class> availableList, final Action odnosnikAkcja) {
        AvailableList = availableList;
        this.OdnosnikAkcja = odnosnikAkcja;
    }



}
