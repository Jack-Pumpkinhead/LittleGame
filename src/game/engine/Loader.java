package game.engine;

import game.base.Player;
import game.base.Scene;

/**
 * Created by CowardlyLion on 2018/10/3 17:16
 */
public class Loader {
    private Loader(){}

    public static void init() {
        Scene mountain = new Scene("山", "江山。");
        Scene temple = new Scene("庙", "普通的神庙。");
        Player littleMonk = new Player("小和尚", "听故事的小和尚", temple);
        Player elderMonk = new Player("老和尚", "见得多的人", temple);

        Main.home.addNearbyScene(mountain);
        mountain.addSubScene(temple);

    }
}
