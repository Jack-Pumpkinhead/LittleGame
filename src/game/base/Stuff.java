package game.base;

/**
 * Created by CowardlyLion on 2018/10/3 11:46
 */
public class Stuff extends Named {
    public static final Stuff empty = new Stuff("空气", "空空的，什么也没有");
    public Stuff(String name, String description) {
        super(name, description);
    }
    public void onInteraction(Player player) {
        System.out.println(getDescription());
    }
}
