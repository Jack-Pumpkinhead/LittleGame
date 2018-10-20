package game.base;

import game.engine.command.Command;

import java.util.ArrayList;

/**
 * Created by CowardlyLion on 2018/10/3 11:44
 */
public class Scene extends Named{
    public static ArrayList<Scene> mainScenes = new ArrayList<>();

    public Scene(String name, String description) {
        super(name, description);
    }

    public String getHeader() {
        return "----------------" + getName() + "---------------------";
    }

    String concreteDescription;
    @Override
    public String getConcreteDescription() {

        String description = parentScene != null ? parentScene.getHeader(): "";
        description += "\n" + getHeader();
        description += "\n" + getDescription();
        description += "\n" + listAllStuffs();
        description += "\n" + listAllPlayers();
        description += "\n" + listAllSubScenes();
        description += "\n" + listAllNearbyScenes();
        return description;
    }

    public String listAllStuffs() {
        return getListInfo(stuffs, "一些东西： 【", "】【", "】。", "什么也没有。");
    }

    public String listAllPlayers() {
        return getListInfo(players, "一些人：【", "】【", "】。", "一个人都没有。");
    }

    public String listAllSubScenes() {
        return getListInfo(subScenes, "小地方：【", "】【", "】。", "没什么好看的。");
    }

    public String listAllNearbyScenes() {
        return getListInfo(nearbyScenes, "隔壁：【", "】【", "】。", "无路可走。");
    }


    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Stuff> stuffs = new ArrayList<>();
    Scene parentScene;
    ArrayList<Scene> subScenes = new ArrayList<>();
    ArrayList<Scene> nearbyScenes = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public ArrayList<Stuff> getStuffs() {
        return stuffs;
    }
    public Scene getParentScene() {
        return parentScene;
    }
    public ArrayList<Scene> getSubScenes() {
        return subScenes;
    }
    public ArrayList<Scene> getNearbyScenes() {
        return nearbyScenes;
    }


    public void addStuff(Stuff stuff) {
        stuffs.add(stuff);
    }

    public void addSubScene(Scene scene) {
        scene.parentScene = this;
        subScenes.add(scene);
    }

    public void addNearbyScene(Scene scene) {
        scene.nearbyScenes.add(this);
        this.nearbyScenes.add(scene);
    }

    public Scene movePlayer(Player player, Scene scene) {
        if (scene == null) return this;
        players.remove(player);
        scene.players.add(player);
        return scene;
    }

    public Scene back(Player player) {
        return movePlayer(player, parentScene);
    }
    public Scene enter(Player player,String name) {
        return movePlayer(player, lookup(name, subScenes));
    }
    public Scene go(Player player,String name) {
        Scene near = lookup(name, nearbyScenes);
        if (near != null) {
            return movePlayer(player, near);
        } else {
            return movePlayer(player, lookup(name, mainScenes));
        }
    }

    public boolean interact(Player player,String name) {
        Player lookup = lookup(name, players);
        if (lookup != null) {
            lookup.onInteraction(player);
            return true;
        }
        Stuff stuff = lookup(name, stuffs);
        if (stuff != null) {
            stuff.onInteraction(player);
            return true;
        }
        return false;
    }

    private ArrayList<Command> extraCommand = new ArrayList<>();
    public ArrayList<Command> getExtraCommand() {
        return extraCommand;
    }
}
