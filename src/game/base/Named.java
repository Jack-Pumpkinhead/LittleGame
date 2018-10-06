package game.base;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by CowardlyLion on 2018/10/3 12:00
 */
public class Named {
    String name;
    String description;
    String concreteDescription;
    String story;

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setConcreteDescription(String concreteDescription) {
        this.concreteDescription = concreteDescription;
    }
    public void setStory(String story) {
        this.story = story;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getConcreteDescription() {
        return concreteDescription;
    }
    public String getStory() {
        return story;
    }

    public Named(){}
    public Named(String name) {
        this.name = name;
    }
    public Named(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Named(String name, String description, String concreteDescription) {
        this.name = name;
        this.description = description;
        this.concreteDescription = concreteDescription;
    }

    public static <V extends Named> V addToMap(V object, Map<String, V> map) {
        return map.put(object.getName(), object);
    }

    public static <V extends Named> V lookup(String name, Collection<V> list) {
        for (V object : list) {
            if (object.getName().equals(name)) return object;
        }
        return null;
    }

    public static <V extends Named> String getListInfo(List<V> list, String prefix,String infix, String postfix, String emptyInfo) {
        if(list.size()==0) return emptyInfo;
        String result = prefix + list.get(0).getName();
        for (int i = 1; i < list.size(); i++) {
            result += infix + list.get(i).getName();
        }
        result += postfix;
        return result;
    }
}
