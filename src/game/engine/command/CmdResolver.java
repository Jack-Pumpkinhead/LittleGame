package game.engine.command;

import game.engine.Main;

import java.util.ArrayList;

import static game.engine.Main.mainPlayer;

/**
 * Created by CowardlyLion on 2018/10/3 19:28
 */
public class CmdResolver {
    static ArrayList<Command> commands = new ArrayList<>();

    public static void addCommand(Command command) {
        commands.add(command);
    }


    public static boolean apply(String[] token) {
        if (mainPlayer.enter(token[0])) {
            Main.delayPrint("走近" + token[0]+".......");
            Main.setUpdate();
            return true;
        }
        if (mainPlayer.go(token[0])) {
            Main.delayPrint("前往" + token[0]+".......");
            Main.setUpdate();
            return true;
        }
        if (mainPlayer.interact(token[0])) {
            return true;
        }

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
        addCommand(new CommandCheck());
        addCommand(new CommandHelp());
        addCommand(new CommandQuit());
        addCommand(new CommandUpdate());
    }

}
