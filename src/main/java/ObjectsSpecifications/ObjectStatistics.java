package ObjectsSpecifications;

import lombok.Getter;

@Getter
public class ObjectStatistics {

    private String name;
    private int HP;
    private int sila;
    private int inicjatywa;
    private int predkoscRuchu;
    private int maxGrowth;
    private int maxHP;

    public void setHP(final int HP) {
        this.HP = HP;
    }
    public void setSila(final int sila) {
        this.sila = sila;
    }
    public void setInicjatywa(final int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }
    public void setMaxHP(final int maxHP) {
        this.maxHP = maxHP;
    }

    public ObjectStatistics(final String name, final int HP, final int sila, final int inicjatywa, final int predkoscRuchu, final int MaxGrowth) {
        this.name = name;
        this.HP = HP;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.predkoscRuchu = predkoscRuchu;
        this.maxGrowth = MaxGrowth;
        this.maxHP = HP;
    }



}
