package game.engine;

import game.base.Player;
import game.base.Scene;
import game.engine.command.CmdResolver;
import game.struct.Home;

import java.util.Scanner;

/**
 * Created by CowardlyLion on 2018/10/3 13:14
 */
public class Main {
    private static boolean running = true;
    private static boolean shouldUpdate = false;
    public static void stop() {
        running = false;
    }
    public static void setUpdate() {
        shouldUpdate = true;
    }

    public static final Home home = new Home();
    public static final Player mainPlayer = new Player(null, "A simple player.", home);

    public static void main(String[] args) {
        Scene main = new Scene("Oz", "The land of everything.");
        Player Steve = new Player("Steve", "A player called \"Steve\"", main);
        Scanner scanner = new Scanner(System.in);

        Loader.init();
        CmdResolver.init();

//        System.out.println("Game starting...");
//        System.out.println("Input your name: ");
        System.out.println("开始游戏...");
        System.out.print("输入你的名字：");
        String name = scanner.nextLine();
        String[] names = name.trim().split("\\s+");

        while (names[0].equals("")) {
            System.out.print("名字不能为空：");
            name = scanner.nextLine();
            names = name.trim().split("\\s+");
        }

        mainPlayer.setName(names[0]);
        home.setOwner(mainPlayer);

        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        mainPlayer.printInformation();

        while (running) {
            String line = scanner.nextLine();
            String[] token = line.trim().split("\\s+");

            if (!CmdResolver.apply(token)) {
                System.out.println("这是啥..");
                continue;
            }


            if (shouldUpdate) {
                for (int i = 0; i < 3; i++) {
                    System.out.println();
                }
                mainPlayer.printInformation();
                shouldUpdate = false;
            }

        }
    }
}
