package Animals;

import ObjectsSpecifications.ObjectStatistics;
import WORLD.MapObject;
import ObjectsSpecifications.TypeOfObject;
import WORLD.World;
import WORLD.WorldMap;
import lombok.Getter;

import java.util.Optional;

public enum AnimalsTypesData implements TypeOfObject {
    ANIMAL_GENERIC("Animl",10,5,5,1,3),
    WILK("Wilk ",10,5,5,1,4),
    OWCA("Owca ",10,5,5,1,3),
    LIS(" Lis ",10,5,5,1,2),
    ZOLW("Zolw ",10,5,5,1,5),
    ANTYLOPA("Antyl",10,5,5,1,2),
    LEW(" Lew ",10,5,5,1,3),
    ZEBRA("Zebra",10,5,5,1,3),
    MALPA("Malpa",10,5,5,1,3);

    //Map Object
    private String name;
    private int HP;
    private int sila;
    private int inicjatywa;
    private int maxGrowth;

    //Animal Exclusive
    private int predkoscRuchu;

    AnimalsTypesData(final String name, final int HP, final int sila, final int inicjatywa, final int predkoscRuchu, final int max_growth) {
        this.name = name;
        this.HP = HP;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.predkoscRuchu = predkoscRuchu;
        this.maxGrowth = max_growth;
    }

    @Override
    public MapObject createNewObject(final World swiatPrzynalezny) {
        ObjectStatistics stats = new ObjectStatistics(this.name, this.HP, this.sila, this.inicjatywa, this.predkoscRuchu, this.maxGrowth);

        switch (this){
            case WILK:{
                return new Wilk(swiatPrzynalezny, stats, false);
            }
            default:{
                return new Animal(swiatPrzynalezny, stats, true) { };
            }
        }
    }



}
