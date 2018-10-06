package game.struct;

import game.base.Scene;
import game.base.Stuff;

import java.util.ArrayList;

/**
 * Created by CowardlyLion on 2018/10/3 14:23
 */
public class SceneMap extends Stuff {
    public static ArrayList<Scene> scenes = new ArrayList<>();

    public SceneMap(String name, String description) {
        super(name, description);
    }
}
