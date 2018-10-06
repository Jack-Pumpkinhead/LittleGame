package game.engine.command;

/**
 * Created by CowardlyLion on 2018/10/5 19:03
 */
public class CommandEmpty extends Command {
    @Override
    public String getDescription() {
        return "输入“”以输入";
    }

    @Override
    public boolean match(String name) {
        return name.equals("");
    }

    @Override
    public void invoke(String[] token) {

    }
}
