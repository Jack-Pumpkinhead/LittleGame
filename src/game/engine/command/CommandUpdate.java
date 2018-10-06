package game.engine.command;

import game.engine.Main;

/**
 * Created by CowardlyLion on 2018/10/5 21:57
 */
public class CommandUpdate extends Command {
    @Override
    public String getDescription() {
        return "输入“F5”以刷新";
    }

    @Override
    public boolean match(String name) {
        return name.equals("F5")||name.equals("刷新");
    }

    @Override
    public void invoke(String[] token) {
        Main.setUpdate();
    }
}
