package MainMenu;

import Mechanics.SurvDifficLevel;

public class ProgramConstants {
    private static final String PROGRAM_NAME = "Virtual World Simulation v 1.0";
    private static final WorldStartSettings DEFAULT_SETTINGS = DAJDEFAULTSETTINGS();
    private static final int MAX_ROZMIAR = 20;
    private static final int MAX_START_ANIMAL = 13;
    private static final int MAX_START_PLANTS = 13;
    private static final String NAME_OF_ACTION_METHOD = "Act";
    private static final int MAX_POSIT_NEIGH_SAFE = 6;     //maximum layer number for search nth layer neighbour position function

    private ProgramConstants() {
    }
    private static WorldStartSettings DAJDEFAULTSETTINGS() {
        return new WorldStartSettings.WorldStartSettBuilder()
                .setSizeX(5)
                .setSizeY(5)
                .setIleZwi(2)
                .setIleRosl(6)
                .setDifficulty(SurvDifficLevel.NORMAL)
                .build();
    }

    public static String getProgramName() {
        return PROGRAM_NAME;
    }
    public static WorldStartSettings getDefaultSettings() {
        return DEFAULT_SETTINGS;
    }
    public static int getMAX_ROZM() {
        return MAX_ROZMIAR;
    }
    public static int getMAX_ST_ANIM() {
        return MAX_START_ANIMAL;
    }
    public static int getMAX_ST_PLANT() {
        return MAX_START_PLANTS;
    }
    public static String getNameOfActionMethod(){
        return NAME_OF_ACTION_METHOD;
    }
    public static int getMAX_POSIT_NEIGH_SAFE() {
        return MAX_POSIT_NEIGH_SAFE;
    }

}
