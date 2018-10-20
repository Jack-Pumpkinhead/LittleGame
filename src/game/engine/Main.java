package game.engine;

import game.base.Player;
import game.engine.command.CmdResolver;
import game.struct.Home;

import java.util.Scanner;

/**
 * Created by CowardlyLion on 2018/10/3 13:14
 */
public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    private static boolean running = true;
    public static void stop() {
        running = false;
    }
    private static boolean shouldUpdate = false;
    public static void setUpdate() {
        shouldUpdate = true;
    }

    public static final Home home = new Home();
    public static final Player mainPlayer = new Player(null, "A simple player.", home);

    public static void main(String[] args) {
//        Scene main = new Scene("Oz", "The land of everything.");
//        Player Steve = new Player("Steve", "A player called \"Steve\"", main);

        Loader.init();
        CmdResolver.init();

//        System.out.println("Game starting...");
//        System.out.println("Input your name: ");
        System.out.println("开始游戏...");
        System.out.print("输入你的名字：");

        String[] names = nextToken();
        while (names[0].equals("")) {
            System.out.print("名字不能为空：");
            names = nextToken();
        }

        mainPlayer.setName(names[0]);
        home.setOwner(mainPlayer);

        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        mainPlayer.printInformation();

        while (running) {

            if (!CmdResolver.apply(nextToken())) {
                System.out.println("Unknown command. Type \"help\" for help.");
                continue;
            }

            if (shouldUpdate) {
                shouldUpdate = false;
                for (int i = 0; i < 15; i++) {
                    System.out.println();
                }
                mainPlayer.printInformation();
            }

        }
        delayPrint("溜了.......................................");
    }

    public static String[] nextToken() {
        return scanner.nextLine().trim().split("\\s+");
    }

    public static void delayPrint(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
