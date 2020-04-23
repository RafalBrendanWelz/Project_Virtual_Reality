package Plants;

import Animals.Animal;
import Animals.Wilk;
import ObjectsSpecifications.ObjectStatistics;
import WORLD.MapObject;
import ObjectsSpecifications.TypeOfObject;
import WORLD.World;

public enum PlantsTypesData implements TypeOfObject {
    PLANT_GENERIC("Plant", 10, 0, 1,5),
    TRAWA("Trawa", 10, 0, 1,3),
    MLECZ("Mlecz", 10, 0, 1,2),
    GUARANA("Guarn", 10, 0, 1,5),
    JABLON("Jabln", 10, 0, 1,9),
    WILCZE_JAGODY("WJago", 10, 0, 1,4);

    private String name;
    private int HP;
    private int sila;
    private int inicjatywa;
    private int maxGrowth;

    PlantsTypesData(final String name, final int HP, final int sila, final int inicjatywa, final int max_growth) {
        this.name = name;
        this.HP = HP;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.maxGrowth = max_growth;
    }

    @Override
    public MapObject createNewObject(final World swiatPrzynalezny) {
        ObjectStatistics stats = new ObjectStatistics(this.name, this.HP, this.sila, this.inicjatywa, 0, this.maxGrowth);

        switch (this){

            default:{
                return new Plant(swiatPrzynalezny, stats) { };
            }
        }
    }

}
