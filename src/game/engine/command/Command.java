package game.engine.command;

import game.base.Named;

/**
 * Created by CowardlyLion on 2018/10/3 19:39
 */
public abstract class Command extends Named {
    @Override
    public abstract String getDescription();
    public abstract boolean match(String name);
    public abstract void invoke(String[] token);
}
