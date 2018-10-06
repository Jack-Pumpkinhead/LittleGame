package game.struct;

import game.base.Player;
import game.base.Scene;

/**
 * Created by CowardlyLion on 2018/10/6 11:25
 */
public class NPC extends Player {
    public NPC(String name, String description, Scene currentScene) {
        super(name, description, currentScene);
    }

    @Override
    public boolean onInteration(Player player) {
        System.out.println(getDescription());
        return true;
    }
}
