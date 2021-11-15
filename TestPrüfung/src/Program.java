import gmbh.kdb.hsw.gdp.*;
import gmbh.kdb.hsw.gdp.domain.GameDevStudio;

public class Program {

    public static void main(String[] args) {

        Program program = new Program();

        Game.create(new IGameHandler() {
            @Override
            public boolean run(GameDevStudio gameDevStudio) {
                return true;
            }
        });

        MainMenu menu = new MainMenu();
        menu.displayMenu(); //starting the menu

    }
}