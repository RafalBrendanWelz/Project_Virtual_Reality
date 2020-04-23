package WORLD;

import Animals.AnimalsTypesData;
import Animals.Animal;
import MainMenu.WorldStartSettings;
import Plants.PlantsTypesData;
import Plants.Plant;

import java.util.Optional;
import java.util.Random;

class WorldStartService {
    private final World TARGETWORLD;
    private static WorldStartService INSTANCE;

    private WorldStartService(final World target) {
        TARGETWORLD = target;
    }
    static WorldStartService getINSTANCE(final World target){
        if (INSTANCE == null){
            INSTANCE = new WorldStartService(target);
        }
        return INSTANCE;
    }

    void startSpawner(final WorldStartSettings ustawieniaSwiata){
        randomizeSpawner(ustawieniaSwiata);
    }

    private void randomizeSpawner(final WorldStartSettings ustawieniaSwiata){
        for (int i = 0; i < ustawieniaSwiata.getStartIloscZwierz(); i++) {
            Optional<Animal> nextSpawn = spawnRandomAnimal();
            nextSpawn.ifPresent(animal -> this.TARGETWORLD.getALLLivingAnimals().add(animal));
            nextSpawn.ifPresent(animal -> this.TARGETWORLD.getALLObjects().add(animal));
        }
        for (int i = 0; i < ustawieniaSwiata.getStartIloscRosl(); i++) {
            Optional<Plant> nextSpawn = spawnRandomPlant();
            nextSpawn.ifPresent(Plant -> this.TARGETWORLD.getALLExistingPlants().add(Plant));
            nextSpawn.ifPresent(Plant -> this.TARGETWORLD.getALLObjects().add(Plant));
        }
    }

    private Optional<Animal> spawnRandomAnimal() {
        AnimalsTypesData newAnimalTyp = losAnimalTyp();
        Animal creation = (Animal) newAnimalTyp.createNewObject(this.TARGETWORLD);

        return (Optional<Animal>) MapObjSpawnerService.getINSTANCE().spawn(creation, TARGETWORLD.getMapa());
    }
    private AnimalsTypesData losAnimalTyp(){
        return AnimalsTypesData.values()[ losIndexObjekt(AnimalsTypesData.values().length) ];
    }

    private Optional<Plant> spawnRandomPlant() {
        PlantsTypesData newPlantTypeTyp = losPlantTyp();
        Plant creation = (Plant) newPlantTypeTyp.createNewObject(this.TARGETWORLD);

        return (Optional<Plant>) MapObjSpawnerService.getINSTANCE().spawn(creation, TARGETWORLD.getMapa());
    }
    private PlantsTypesData losPlantTyp(){
        return PlantsTypesData.values()[ losIndexObjekt(PlantsTypesData.values().length) ];
    }

    private int losIndexObjekt(final int ileMozlTablica){
        return new Random().nextInt(ileMozlTablica-1);
    }



}
