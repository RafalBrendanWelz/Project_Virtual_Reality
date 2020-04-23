package Mechanics;


public interface CollisionObject {
    default boolean reactToCollision(final CollisionEffect whatHappens, final CollisionObject whoDoesThat) {
        return true;
    }

}
