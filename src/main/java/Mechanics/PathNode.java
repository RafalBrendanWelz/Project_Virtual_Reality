package Mechanics;

import lombok.Getter;

@Getter
public class PathNode {
    private PathNode nextStep;
    private Position currentPosition;
    private boolean isItTheEnd;

    public PathNode(final Position whereItIs, final PathNode nextStep) {
        this.nextStep = nextStep;
        this.currentPosition = whereItIs;
        this.isItTheEnd = false;
    }
    public PathNode(final Position whereItIs) {
        this.currentPosition = whereItIs;
        this.nextStep = this;
        this.isItTheEnd = true;
    }

    void setNextStep(final PathNode newerStepToAdd){
        if (isItTheEnd()){
            this.isItTheEnd = false;
            this.nextStep = newerStepToAdd;
        }else {
            this.nextStep.setNextStep(newerStepToAdd);
        }
    }


}
