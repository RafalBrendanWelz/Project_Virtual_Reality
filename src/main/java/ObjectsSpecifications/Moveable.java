package ObjectsSpecifications;


import Events.Actions.Action;
import Mechanics.Path;

import java.util.Optional;


public interface Moveable {

    public Optional<Path> getMyWay();
    public void setNewWay(final Path myWayNew);


}
