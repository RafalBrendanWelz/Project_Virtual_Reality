package ObjectsSpecifications;


import Animals.AnimalsTypesData;
import Mechanics.Position;
import WORLD.MapObject;
import WORLD.World;
import WORLD.WorldMap;

import java.util.Optional;

public interface TypeOfObject {
    MapObject createNewObject(final World swiatPrzynalezny);
}
