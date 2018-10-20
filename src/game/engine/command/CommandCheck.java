package game.engine.command;

import game.base.Named;
import game.base.Scene;
import game.engine.Main;

/**
 * Created by CowardlyLion on 2018/10/19 18:03
 */
public class CommandCheck extends Command {
    @Override
    public String getDescription() {
        return "输入“check 名字”以查看仔细说明";
    }

    @Override
    public boolean match(String name) {
        return name.equals("check");
    }

    @Override
    public void invoke(String[] token) {
        Scene scene = Main.mainPlayer.getCurrentScene();
        Named lookup;
        if (token.length == 1) {
            System.out.println(scene.getConcreteDescription());
        } else if ((lookup = Named.lookup(token[1], scene.getPlayers())) != null) {
            System.out.println(lookup.getConcreteDescription());
        } else if ((lookup = Named.lookup(token[1], scene.getSubScenes())) != null) {
            System.out.println(lookup.getConcreteDescription());
        } else if ((lookup = Named.lookup(token[1], scene.getNearbyScenes())) != null) {
            System.out.println(lookup.getConcreteDescription());
        } else {
            System.out.println("没找到" + token[1]);
        }
    }
}
