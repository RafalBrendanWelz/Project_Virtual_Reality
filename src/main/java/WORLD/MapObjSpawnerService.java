package WORLD;

import ObjectsSpecifications.TypeOfObject;
import lombok.Getter;

import java.util.Optional;

@Getter
public class MapObjSpawnerService<T extends MapObject> {
    private static MapObjSpawnerService INSTANCE;

    private MapObjSpawnerService() {
    }
    public static MapObjSpawnerService getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new MapObjSpawnerService();
        }
        return INSTANCE;
    }


    public Optional<T> spawn(final T whatToPut, final WorldMap whereToPut){
        if ( whereToPut.placeObject(whatToPut) ){
            return Optional.of(whatToPut);
        }else {
            return Optional.empty();
        }
    }



    public Optional<MapObject> createAndSpawn(final TypeOfObject typeOfObjectToCreate, final World swiat){
        MapObject whatToPut = typeOfObjectToCreate.createNewObject(swiat);
        WorldMap whereToPut = swiat.getMapa();

        if ( whereToPut.placeObject(whatToPut) ){
            return Optional.of(whatToPut);
        }else {
            return Optional.empty();
        }
    }




}
