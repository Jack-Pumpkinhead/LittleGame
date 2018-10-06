package game.engine.command;

import game.base.Named;
import game.base.Scene;
import game.engine.Main;

/**
 * Created by CowardlyLion on 2018/10/5 22:04
 */
public class CommandGetDescription extends Command {
    @Override
    public String getDescription() {
        return "输入“info 名字”以查看说明";
    }

    @Override
    public boolean match(String name) {
        return name.equals("info");
    }

    @Override
    public void invoke(String[] token) {
        Scene scene = Main.mainPlayer.getCurrentScene();
        Named lookup;
        if (token.length == 1) {
            System.out.println(scene.getDescription());
        } else if ((lookup = Named.lookup(token[1], scene.getPlayers())) != null){
            System.out.println(lookup.getDescription());
        } else if ((lookup = Named.lookup(token[1], scene.getSubScenes())) != null) {
            System.out.println(lookup.getDescription());
        } else if ((lookup = Named.lookup(token[1], scene.getNearbyScenes())) != null) {
            System.out.println(lookup.getDescription());
        } else {
            System.out.println("一个遥远的地方，我也不知道是啥");
        }
    }
}
