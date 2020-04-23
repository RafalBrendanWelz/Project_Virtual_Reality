package Mechanics;

import Animals.Animal;
import Events.Actions.Action;
import Plants.Plant;
import Player.LastHuman;

public class Collision {
    private CollisionObject intruz;     //who entered into position
    private CollisionObject bywalec;    //who was occupying position
    private Action intruzInitializeAction;

    //Kolizja (Kto zaczął, z kim zaczął, co takiego robił)
    public Collision(final CollisionObject intruz, final CollisionObject bywalec, final Action intruzInitializeAction) {
        this.intruz = intruz;
        this.bywalec = bywalec;
        this.intruzInitializeAction = intruzInitializeAction;
    }

    boolean concludeCollision(){
        CollisionEffect intruzEffect;
        CollisionEffect bywalecEffect;

        if (this.bywalec instanceof MapBorder){
            bywalecEffect = CollisionEffect.IGNORE;
            intruzEffect = HitMapBorderReaction();
        }else if (!(this.bywalec instanceof Plant) && !(this.intruz instanceof Plant) ){
            bywalecEffect = BywalecFightReact();
            intruzEffect = IntruzFightReact();
        }else if (this.bywalec instanceof Plant && !(this.intruz instanceof Plant) ){
            bywalecEffect = BywalecPlantUse();
            intruzEffect = IntruzPlantUse();
        }else {
            bywalecEffect = CollisionEffect.BOUNCE;
            intruzEffect = CollisionEffect.BOUNCE;
        }

        return (forceReaction(this.intruz, intruzEffect, this.bywalec)  &&  forceReaction(this.bywalec, bywalecEffect, this.intruz));
    }

    private CollisionEffect IntruzFightReact(){

        if ((this.intruz instanceof Animal)) {
            return CollisionEffect.HUNT_ATTACK;
        }else if (this.intruz instanceof LastHuman){
            return CollisionEffect.HUNT_ATTACK;
        }else {
            return CollisionEffect.TAKE_DAM;
        }
    }
    private CollisionEffect BywalecFightReact(){
        return CollisionEffect.DEFEND;
    }

    private CollisionEffect IntruzPlantUse(){

        if ((this.intruz instanceof Animal)) {
            return CollisionEffect.DEFEND;
        }else if (this.intruz instanceof LastHuman){
            return CollisionEffect.DEFEND;
        }else {
            return CollisionEffect.TAKE_DAM;
        }
    }
    private CollisionEffect BywalecPlantUse(){
        return CollisionEffect.TAKE_DAM;
    }

    private CollisionEffect HitMapBorderReaction(){
        if ((this.intruz instanceof Animal)) {
            return CollisionEffect.SUICIDE_JUMP;
        }else if (this.intruz instanceof LastHuman){
            return CollisionEffect.BOUNCE;
        }else {
            return CollisionEffect.SUICIDE_IN_PLACE;
        }
    }

    private boolean forceReaction(final CollisionObject whose, final CollisionEffect whatReaction, final CollisionObject fromWho){
        if ( !whatReaction.equals(CollisionEffect.IGNORE) ){
            return whose.reactToCollision(whatReaction, fromWho);
        }
        return true;
    }


}
