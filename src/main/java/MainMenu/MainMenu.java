package MainMenu;

import java.util.Scanner;

class MainMenu {
    private static final int FOR_CHOOSING_FROM1 = 1;

    public static void main(String[] args) {
        startMainMenu();
    }
    static void startMainMenu(){
        System.out.println(drawMainMenu());
        chooseMenuOption();
    }
    private static String drawMainMenu() {
        StringBuilder wynik = new StringBuilder();
        wynik.append( ProgramConstants.getProgramName() );
        wynik.append( "\n\n" );
        for (final MainMenuChoices opcja : MainMenuChoices.values()) {
            wynik.append(opcja.getText());
            wynik.append("\n");
        }
        wynik.append("Wpisz któryś z numerów by wybrac");
        return wynik.toString();
    }


    private static void chooseMenuOption(){
        int wybor = inputInt();
        if (wybor >= MainMenuChoices.values().length + FOR_CHOOSING_FROM1 || wybor < FOR_CHOOSING_FROM1){
            startMainMenu();
        }else {
            MainMenuChoices.values()[wybor - FOR_CHOOSING_FROM1].getAkcja().Action();
        }
    }
    private static int inputInt(){
        Scanner wybor = new Scanner(System.in);
        while (!wybor.hasNextInt()){
            wybor.next();
        }
        return wybor.nextInt();
    }




}
