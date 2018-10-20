package game.engine.command;

import game.engine.Main;

/**
 * Created by CowardlyLion on 2018/10/5 19:04
 */
public class CommandQuit extends Command {
    @Override
    public String getDescription() {
        return "输入“溜了”以溜了";
    }

    @Override
    public boolean match(String name) {
        return name.equals("溜了") || name.equals("stop") || name.equals("quit") || name.equals("exit");
    }

    @Override
    public void invoke(String[] token) {
        Main.stop();
    }
}
