package game.base;

/**
 * Created by CowardlyLion on 2018/10/3 11:46
 */
public class Stuff extends Named {
    public static final Stuff empty = new Stuff("empty", "空气");
    public Stuff(String name, String description) {
        super(name, description);
    }

}
