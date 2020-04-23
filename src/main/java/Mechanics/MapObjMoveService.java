 package Mechanics;

import Events.Actions.Action;
import Exceptions.NiepoprawnyWykonawca;
import WORLD.MapObject;
import WORLD.World;

import java.util.Optional;

public class MapObjMoveService {
    private static MapObjMoveService INSTANCE;

    private MapObjMoveService() {
    }

    public static MapObjMoveService getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new MapObjMoveService();
        }
        return INSTANCE;
    }



    public void move(final MapObject who, final Position where, final World swiat, final Action purpose){
        validateMovement(who, where, swiat);

        Optional<Position> celRuchuToPusteMiejsce = swiat.getMapa().giveAwayEmptyPosition(where);
        if (celRuchuToPusteMiejsce.isPresent()) {
            swiat.getMapa().regainPositionFromObject( who );
            who.setPozycja( celRuchuToPusteMiejsce.get() );

        }else {
            if (swiat.getMapa().isPositionOutOfMap(where)){
                resultIsCollision(who, MapBorder.MAP_BORDER, purpose);
            }else {
                Optional<MapObject> occupier = swiat.getALLObjects().stream()
                        .filter( obj -> obj.getPozycja() == where )
                        .findFirst();
                occupier.ifPresent(mapObject -> resultIsCollision(who, mapObject, purpose));

                if (occupier.isEmpty()) {
                    System.out.println("Object " + who + " cannot move to position " + where);
                }
            }
        }
    }
    private void resultIsCollision(final CollisionObject mover, final CollisionObject occupier, final Action initAction){
        Collision kolizjaWhileMovement = new Collision(mover, occupier, initAction);
        kolizjaWhileMovement.concludeCollision();
    }
    private boolean validateMovement(final MapObject who, final Position where, final World swiat){
        if ( !swiat.getALLObjects().contains(who) ){
            throw new NiepoprawnyWykonawca("Podany w argumencie Obiekt nie należy do podanego świata");
        }
        return true;
    }


}
