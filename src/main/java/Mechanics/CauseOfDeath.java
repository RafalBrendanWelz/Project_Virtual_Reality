package Mechanics;

import lombok.Getter;

@Getter
public enum CauseOfDeath {
    OUTOFMAPSPAWN("Has Spawned out of Map"),
    SUICIDEJUMP("Commited suicide by jumping out of map"),
    HUNT("Has been eaten"),
    STARVED("Has Starved"),
    POISONED("Has ate something poisonous"),
    BLEEDOUT("Has bled out");

    private String text;

    CauseOfDeath(final String text) {
        this.text = text;
    }



}
