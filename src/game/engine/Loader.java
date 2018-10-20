package game.engine;

import game.base.Player;
import game.base.Scene;
import game.base.Stuff;
import game.struct.NPC;

/**
 * Created by CowardlyLion on 2018/10/3 17:16
 */
public class Loader {
    private Loader(){}

    public static void init() {
        Scene mountain = new Scene("山", "江山。");
        Scene temple = new Scene("庙", "普通的神庙。");
        Player littleMonk = new NPC("小和尚", "听故事的小和尚", temple);
        Player elderMonk = new NPC("老和尚", "见得多的人", temple);

        littleMonk.setConcreteDescription("...");
        elderMonk.setConcreteDescription("我来给你讲个故事吧，Excited！");

        Main.home.addNearbyScene(mountain);
        mountain.addSubScene(temple);

        Stuff health = new Stuff("无穷的血量条", "无穷的血量条");
        elderMonk.addStuff(health);
        elderMonk.setOnHand(health);

        Stuff book = new Stuff("《傅立叶分析导论》", "没学过");
        littleMonk.addStuff(book);
        littleMonk.setOnHand(book);

        Stuff oak = new Stuff("橡树", "很像一棵树");
        Stuff grass = new Stuff("高草丛", "不够高");
        mountain.addStuff(oak);
        mountain.addStuff(grass);

        Scene forest = new Scene("草原", "亚热带稀疏草原");
        Stuff wood = new Stuff("枯木枝", "没有任何水分");
        forest.addStuff(wood);
        mountain.addNearbyScene(forest);

    }
}
