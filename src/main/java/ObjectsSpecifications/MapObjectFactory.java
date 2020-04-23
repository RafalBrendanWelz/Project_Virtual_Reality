package ObjectsSpecifications;

import WORLD.MapObject;

import java.util.Optional;

public class MapObjectFactory {
    private static MapObjectFactory INSTANCE;

    private MapObjectFactory() {
    }

    public static MapObjectFactory getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new MapObjectFactory();
        }
        return INSTANCE;
    }






}
