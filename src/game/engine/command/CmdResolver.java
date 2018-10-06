package game.engine.command;

import java.util.ArrayList;

/**
 * Created by CowardlyLion on 2018/10/3 19:28
 */
public class CmdResolver {
    static ArrayList<Command> commands = new ArrayList<>();

    public static void addCommand(Command command) {
        commands.add(command);
    }

    public static boolean apply(String[] token) {
        for (Command command : commands) {
            if (command.match(token[0])) {
                command.invoke(token);
                return true;
            }
        }

        return false;
    }

    private CmdResolver(){}

    public static void init() {
        addCommand(new CommandBack());
        addCommand(new CommandEmpty());
        addCommand(new CommandGetDescription());
        addCommand(new CommandHelp());
        addCommand(new CommandQuit());
        addCommand(new CommandUpdate());
    }

}
