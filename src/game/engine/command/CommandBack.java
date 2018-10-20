package game.engine.command;

import game.engine.Main;

/**
 * Created by CowardlyLion on 2018/10/5 22:59
 */
public class CommandBack extends Command {
    @Override
    public String getDescription() {
        return "输入“返回”以返回";
    }

    @Override
    public boolean match(String name) {
        return name.equals("返回");
    }

    @Override
    public void invoke(String[] token) {
        if (Main.mainPlayer.back()) {
            Main.delayPrint("回到" + Main.mainPlayer.getCurrentScene().getName() + "......");
            Main.setUpdate();
        } else {
            Main.delayPrint("无路可走......");
            Main.setUpdate();
        }
    }
}
