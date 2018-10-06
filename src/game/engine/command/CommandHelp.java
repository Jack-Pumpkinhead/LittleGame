package game.engine.command;

/**
 * Created by CowardlyLion on 2018/10/5 21:26
 */
public class CommandHelp extends Command {

    @Override
    public String getDescription() {
        return "输入“帮助”以查看帮助";
    }

    @Override
    public boolean match(String name) {
        return name.equals("帮助") || name.equals("?");
    }

    @Override
    public void invoke(String[] token) {
        for (Command command : CmdResolver.commands) {
            System.out.println(command.getDescription());
        }
    }
}
