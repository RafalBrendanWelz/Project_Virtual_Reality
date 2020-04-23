package Mechanics;

import Events.Actions.Action;
import Events.Actions.AllActions;
import lombok.Getter;

import java.util.*;

@Getter
public class Path extends AbstractQueue {
    private PathNode firstStep;
    private PathNode lastStep;
    private Action purpose;
    private int size;

    public Path() {
        this.size = 0;
        purpose = AllActions.MOVEMENT.getOdnosnikAkcja();
    }
    public Path(final Action purpose) {
        this.size = 0;
        this.purpose = purpose;
    }
    public Path(final Action purpose, final PathNode initStep){
        this.size = 1;
        this.purpose = purpose;
        this.firstStep = initStep;
        PathNode ostatni = initStep;
        while (!ostatni.isItTheEnd()){
            ostatni = ostatni.getNextStep();
            this.size++;
        }
        this.lastStep = ostatni;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public boolean offer(final Object o) {
        if (o instanceof PathNode){
            PathNode nowyStep = (PathNode) o;
            this.size++;
            this.lastStep = nowyStep;

            if (this.size == 0){
                this.firstStep = nowyStep;
            }else {
                this.firstStep.setNextStep(nowyStep);
            }
            return true;
        }
        return false;
    }
    @Override
    public Optional<PathNode> poll() {
        if (this.size == 0){
            return Optional.empty();
        }else {
            PathNode stepToMake = this.firstStep;
            this.firstStep = this.firstStep.getNextStep();
            this.size--;
            return Optional.of(stepToMake);
        }
    }
    @Override
    public Optional<PathNode> peek() {
        if (this.size > 0){
            return Optional.of(this.firstStep);
        }else {
            return Optional.empty();
        }
    }



}
