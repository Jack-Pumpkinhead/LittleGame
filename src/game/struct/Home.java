package game.struct;

import game.base.Player;
import game.base.Scene;

/**
 * Created by CowardlyLion on 2018/10/3 13:25
 */
public class Home extends Scene {
    public Home() {
        super("home", "空空的，什么都没有。");
    }
    Player owner;
    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String getHeader() {
        return "---------------" + owner.getName() + "的家-------------------";
    }
}
