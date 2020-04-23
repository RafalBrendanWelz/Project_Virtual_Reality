package MainMenu;

import Mechanics.SurvDifficLevel;
import Simulation.SimulationMain;
import WORLD.World;

import java.util.Scanner;

class MainMenuFunctions {
    private static WorldStartSettings choosenSettings = ProgramConstants.getDefaultSettings();

    static void SimulationStart(){
        World gameWorld = new World( choosenSettings );
        SimulationMain.start(gameWorld);


    }

    static void chooseStartSettings(){
        choosenSettings = chooseSettings();
        MainMenu.startMainMenu();
    }
    private static WorldStartSettings chooseSettings(){
        WorldStartSettings.WorldStartSettBuilder builder = new WorldStartSettings.WorldStartSettBuilder();

        System.out.println("Podaj Rozmiar X mapy (0 < liczba < " + ProgramConstants.getMAX_ROZM() + ") ");
        builder.setSizeX( inputInt() );
        System.out.println("Podaj Rozmiar Y mapy (0 < liczba < " + ProgramConstants.getMAX_ROZM() + ") ");
        builder.setSizeY( inputInt() );
        System.out.println("Podaj Startową ilość zwierząt (-1 < liczba < " + ProgramConstants.getMAX_ST_ANIM() + ") ");
        builder.setIleZwi( inputInt() );
        System.out.println("Podaj Startową ilość roślin (-1 < liczba < " + ProgramConstants.getMAX_ST_PLANT() + ") ");
        builder.setIleRosl( inputInt() );

        builder.setDifficulty( ustawPoziomTrudnosci() );

        return builder.build();
    }
    private static int ustawPoziomTrudnosci() {
        System.out.println("Wybierz Poziom Trudnosci: ");
        for (int i = 0; i < SurvDifficLevel.values().length; i++) {
            System.out.println(i + " dla " + SurvDifficLevel.values()[i]);
        }

        return inputInt();
    }
    private static int inputInt(){
        Scanner wpisz = new Scanner(System.in);
        while (!wpisz.hasNextInt()){
            wpisz.next();
        }
        return wpisz.nextInt();
    }

    static void textIntroduction(){
        System.out.println("Welcome to " + ProgramConstants.getProgramName() + "\n\n Here is Main Menu where you can choose settings for the new world and start it.\n");
        MainMenu.startMainMenu();
    }





}
