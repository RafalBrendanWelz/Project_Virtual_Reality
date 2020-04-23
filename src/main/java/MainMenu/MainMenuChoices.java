package MainMenu;

import lombok.Getter;

@Getter
enum MainMenuChoices {
    CREATENEWWORLD("1) Start New World", new AbstractMenuChoiceAction() {
        @Override
        public void Action() {
            MainMenuFunctions.SimulationStart();
        }
    }),
    CUSTOMIZEOPTIONS("2) Set World", new AbstractMenuChoiceAction() {
        @Override
        public void Action() {
            MainMenuFunctions.chooseStartSettings();
        }
    }),
    SHOWINTRODUCTION("3) Intro Text", new AbstractMenuChoiceAction() {
        @Override
        public void Action() {
            MainMenuFunctions.textIntroduction();
        }
    }),
    EXIT("4) Exit", new AbstractMenuChoiceAction() {
        @Override
        public void Action() { }//do nothing so it quits Program
    });

    private String text;
    private AbstractMenuChoiceAction akcja;

    MainMenuChoices(final String text, final AbstractMenuChoiceAction akcja) {
        this.text = text;
        this.akcja = akcja;
    }




}
