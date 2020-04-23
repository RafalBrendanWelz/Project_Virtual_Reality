package Mechanics;

import Events.Actions.Action;
import Events.Actions.AllActions;
import WORLD.MapObject;
import WORLD.WorldMap;

import java.util.Optional;

public class MapObjCollisionDetectionService {
    private static MapObjCollisionDetectionService INSTANCE;
    private final AllActions DEFAULT_INIT_ACTION;

    private MapObjCollisionDetectionService() {
        DEFAULT_INIT_ACTION = AllActions.MOVEMENT;
    }

    public static MapObjCollisionDetectionService getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new MapObjCollisionDetectionService();
        }
        return INSTANCE;
    }


    public Optional<Collision> twoObjDetect(final MapObject intruzWchodzacy, final MapObject bywalec){
        if ( intruzWchodzacy.getPozycja().equals(bywalec.getPozycja()) ){
            return Optional.of(new Collision(intruzWchodzacy, bywalec, this.DEFAULT_INIT_ACTION.getOdnosnikAkcja()) {});
        }else {
            return Optional.empty();
        }
    }
    public Optional<Collision> twoObjDetect(final MapObject intruzWchodzacy, final MapObject bywalec, final Action akcjaWejscia){
        if ( intruzWchodzacy.getPozycja().equals(bywalec.getPozycja()) ){
            return Optional.of(new Collision(intruzWchodzacy, bywalec, akcjaWejscia) {});
        }else {
            return Optional.empty();
        }
    }

    public Optional<Collision> mapBorderDetect(final MapObject intruzWchodzacy, final WorldMap mapa){
        if ( intruzWchodzacy.getPozycja().getX() < 0 || intruzWchodzacy.getPozycja().getX() > mapa.getSizeX()
                || intruzWchodzacy.getPozycja().getY() < 0 || intruzWchodzacy.getPozycja().getY() > mapa.getSizeY() )
        {
            return Optional.of(new Collision(intruzWchodzacy, MapBorder.MAP_BORDER, this.DEFAULT_INIT_ACTION.getOdnosnikAkcja()) {});
        }else {
            return Optional.empty();
        }
    }


}
