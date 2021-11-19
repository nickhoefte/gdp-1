import gmbh.kdb.hsw.gdp.Game;

public class Main {

    public static void main(String[] args) {

        Game.create(studio -> {
            TurnCounter.increment();
            System.out.println(TurnCounter.getCounter());
            return true;
        }).start();

        MainMenu menu = new MainMenu();
        //menu.displayMenu(); //starting the menu

    }
}