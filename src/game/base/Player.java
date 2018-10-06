package game.base;

import java.util.ArrayList;

/**
 * Created by CowardlyLion on 2018/10/3 12:38
 */
public class Player extends Named {
    ArrayList<Stuff> stuffs = new ArrayList<>();
    Stuff onHand = Stuff.empty;
    Scene currentScene;

    public void addStuff(Stuff stuff) {
        stuffs.add(stuff);
    }
    public void removeStuff(Stuff stuff) {
        stuffs.remove(stuff);
    }
    public Stuff contains(String name) {
        return lookup(name, stuffs);
    }

    public Stuff getOnHand() {
        return onHand;
    }
    public Scene getCurrentScene() {
        return currentScene;
    }
    public void setOnHand(Stuff onHand) {
        this.onHand = onHand;
    }
    public boolean setCurrentScene(Scene currentScene) {
        if(this.currentScene==currentScene) return false;
        this.currentScene = currentScene;
        return true;
    }

    public Player(String name, String description, Scene currentScene) {
        super(name, description);
        this.currentScene = currentScene;
        currentScene.getPlayers().add(this);
    }

    public void printInformation() {
        System.out.println(currentScene.getConcreteDescription());
        System.out.println(this.getDescription());
    }

    public String getHeader() {
        return "------------------" + name + "---------------------";
    }
    @Override
    public String getConcreteDescription() {
        String description = getHeader();
        description += "\n" + "手上拿着" + onHand.description;
        return description;
    }

    public boolean back() {
        return setCurrentScene(currentScene.back(this));
    }
    public boolean enter(String name) {
        return setCurrentScene(currentScene.enter(this, name));
    }
    public boolean go(String name) {
        return setCurrentScene(currentScene.go(this, name));
    }

    public boolean onInteration(Player player) {
        return false;
    }
}
