package Events.Actions;


import Events.AI.Goals;
import Animals.Animal;
import Exceptions.NiepoprawnyWykonawca;
import MainMenu.ProgramConstants;
import Mechanics.Position;
import WORLD.MapObject;
import WORLD.World;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Hunt extends Action {

    public Hunt() {
        super(Goals.EAT);
    }

    @Override
    public void Act(final World swiat, final MapObject wykonawca) {
        if (wykonawca instanceof Animal){
            System.out.println("This is Hunt action made by" + wykonawca.getStatystyki().getName());
            Position placeOfTarget = findTargetPreyPosition(swiat, wykonawca);



        }else {
            throw new NiepoprawnyWykonawca(wykonawca.getStatystyki().getName() + " is not a valid performer of Action " + this.getClass());
        }
    }
    private Position findTargetPreyPosition(final World swiat, final MapObject wykonawca){
        List<Animal> neighbourAnimals = swiat.giveAllNeighbourAnimals(wykonawca);

        if (neighbourAnimals.size()==0){
            neighbourAnimals = findNthLayerNeighboursAnimals(swiat.getALLLivingAnimals(), wykonawca, 2);

            if (neighbourAnimals.size()==0){
                return wykonawca.getPozycja();
            }
        }
        return neighbourAnimals.get(0).getPozycja();
    }
    private List<Animal> findNthLayerNeighboursAnimals(final List<Animal> candidates, final MapObject wykonawca, int nthLayer){
        final int currentLayerToSearch = nthLayer;
        List<Animal> wynik = candidates.stream()
                .filter(new Predicate<Animal>() {
                    @Override
                    public boolean test(final Animal animal) {
                        return animal.getPozycja().isNthLayerNeighbourWith(wykonawca.getPozycja(), currentLayerToSearch);
                    }
                }).collect(Collectors.toList());

        return (wynik.size() == 0 && nthLayer <= ProgramConstants.getMAX_POSIT_NEIGH_SAFE()) ? (this.findNthLayerNeighboursAnimals(candidates, wykonawca, ++nthLayer)) : (wynik);
    }



}
