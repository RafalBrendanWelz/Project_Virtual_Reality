package MainMenu;

import Mechanics.SurvDifficLevel;
import lombok.Getter;

@Getter
public class WorldStartSettings {
    private int sizeX;
    private int sizeY;
    private int startIloscZwierz;
    private int startIloscRosl;
    private SurvDifficLevel difLevel;

    private WorldStartSettings(final int sizeX, final int sizeY, final int startIloscZwierz, final int startIloscRosl, final SurvDifficLevel difLevel) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.startIloscZwierz = startIloscZwierz;
        this.startIloscRosl = startIloscRosl;
        this.difLevel = difLevel;
    }


    static class WorldStartSettBuilder{
        private int sizeX;
        private int sizeY;
        private int startIloscZwierz;
        private int startIloscRosl;
        private SurvDifficLevel difLevel;

        WorldStartSettBuilder setSizeX(final int sizeX){
            if (sizeX < 0){
                this.sizeX = ProgramConstants.getDefaultSettings().getSizeX();
            }else if (sizeX > ProgramConstants.getMAX_ROZM()){
                this.sizeX = ProgramConstants.getMAX_ROZM();
            }else {
                this.sizeX = sizeX;
            }
            return this;
        }

        WorldStartSettBuilder setSizeY(final int sizeY){
            if (sizeY < 0){
                this.sizeY = ProgramConstants.getDefaultSettings().getSizeY();
            }else if (sizeY > ProgramConstants.getMAX_ROZM()){
                this.sizeY = ProgramConstants.getMAX_ROZM();
            }else {
                this.sizeY = sizeY;
            }
            return this;
        }

        WorldStartSettBuilder setIleZwi(final int ileZwierzat){
            if (ileZwierzat < 0){
                this.startIloscZwierz = ProgramConstants.getDefaultSettings().startIloscZwierz;
            }else if (ileZwierzat > ProgramConstants.getMAX_ST_ANIM()){
                this.startIloscZwierz = ProgramConstants.getMAX_ST_ANIM();
            }else {
                this.startIloscZwierz = ileZwierzat;
            }
            return this;
        }

        WorldStartSettBuilder setIleRosl(final int ileRoslin){
            if (ileRoslin < 0){
                this.startIloscRosl = ProgramConstants.getDefaultSettings().startIloscRosl;
            }else if (ileRoslin > ProgramConstants.getMAX_ST_PLANT()){
                this.startIloscRosl = ProgramConstants.getMAX_ST_PLANT();
            }else {
                this.startIloscRosl = ileRoslin;
            }
            return this;
        }

        WorldStartSettBuilder setDifficulty(final SurvDifficLevel level){
            this.difLevel = level;
            return this;
        }
        WorldStartSettBuilder setDifficulty(final int level){
            if (level >= SurvDifficLevel.values().length){
                this.difLevel = SurvDifficLevel.HELL;
            }else if (level < 0){
                this.difLevel = ProgramConstants.getDefaultSettings().difLevel;
            }else {
                this.difLevel = SurvDifficLevel.values()[level];
            }
            return this;
        }


        WorldStartSettings build(){
            return new WorldStartSettings(this.sizeX, this.sizeY, this.startIloscZwierz, this.startIloscRosl, this.difLevel);
        }
    }

}
