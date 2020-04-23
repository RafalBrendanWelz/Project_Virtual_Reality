 package Mechanics;

import Events.Actions.Action;
import Exceptions.NiepoprawnyWykonawca;
import WORLD.MapObject;
import WORLD.World;

import java.util.Optional;

 public class PathMakerService {
     private static PathMakerService INSTANCE;

     private PathMakerService() {
     }

     public static PathMakerService getINSTANCE() {
         if (INSTANCE == null){
             INSTANCE = new PathMakerService();
         }
         return INSTANCE;
     }

     public Path createOneStepPath(final Action purpose, final Position initStep){
         return new Path(purpose, new PathNode(initStep));
     }

     public Path createPath(final Action purpose, final Position finalDestination, final Position startingPlace){
        if (startingPlace.isNeighbourWith(finalDestination)){
            return createOneStepPath(purpose, finalDestination);
        }

        Path wynik = new Path(purpose);
        if (startingPlace.equals(finalDestination)){
            return wynik;
        }else if (startingPlace.getX() == finalDestination.getX()){
            //ruch w pionie
            return makePionPath(wynik, finalDestination, startingPlace);
        }else if (startingPlace.getY() == finalDestination.getY()){
            //ruch w poziomie
            return makePoziomPath(wynik, finalDestination, startingPlace);
        }else if ( Math.sqrt(startingPlace.getY() - finalDestination.getY()) == Math.sqrt(startingPlace.getX() - finalDestination.getX()) ){
            //ruch w skosie
            return makeSkosPath(wynik, finalDestination, startingPlace);
        }else {
            //ruch poziom plus pion
            return makePoziomPlusPionPath(wynik, finalDestination, startingPlace);
        }
     }
     private Path makePoziomPlusPionPath(final Path sciezka, final Position finalDestination, final Position startingPlace) {
        Position rightPoziomPosit = new Position(finalDestination.getX(), startingPlace.getY());
        Path wynik = makePoziomPath(sciezka, rightPoziomPosit, startingPlace);
        makePionPath(wynik, finalDestination, rightPoziomPosit);

        return wynik;
     }
     private Path makeSkosPath(final Path sciezka, final Position finalDestination, final Position startingPlace) {
        boolean Xmalejacy = ( finalDestination.getX() < startingPlace.getX() );
        boolean Ymalejacy = ( finalDestination.getY() < startingPlace.getY() );

        
        return null;
     }
     private Path makePoziomPath(final Path sciezka, final Position finalDestination, final Position startingPlace) {
         int heightY = startingPlace.getY();
         if (finalDestination.getX() - startingPlace.getX() > 0){
             for (int i = startingPlace.getX()+1; i <= finalDestination.getX(); i++) {
                 sciezka.offer( new PathNode(new Position(i, heightY)) );
             }
         }else {
             for (int i = startingPlace.getX()-1; i >= finalDestination.getX(); i--) {
                 sciezka.offer( new PathNode(new Position(i, heightY)) );
             }
         }
         return sciezka;
     }
     private Path makePionPath(final Path sciezka, final Position finalDestination, final Position startingPlace) {
         int lengthX = startingPlace.getX();
         if (finalDestination.getY() - startingPlace.getY() > 0){
             for (int i = startingPlace.getY()+1; i <= finalDestination.getY(); i++) {
                 sciezka.offer( new PathNode(new Position(lengthX, i)) );
             }
         }else {
             for (int i = startingPlace.getY()-1; i >= finalDestination.getY(); i--) {
                 sciezka.offer( new PathNode(new Position(lengthX, i)) );
             }
         }
         return sciezka;
     }


 }
