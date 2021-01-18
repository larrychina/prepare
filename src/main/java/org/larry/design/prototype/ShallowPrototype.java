package org.larry.design.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 浅克隆
 */
public class ShallowPrototype implements Cloneable {

    private String name ;
    private String sex ;
    private List<String> hobbies ;

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    protected ShallowPrototype clone() throws CloneNotSupportedException {
        return (ShallowPrototype) super.clone();
    }

    @Override
    public String toString() {
        return "ShallowPrototype{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowPrototype shallowPrototype = new ShallowPrototype() ;
        shallowPrototype.setName("larry");
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("play game");
        shallowPrototype.setHobbies(hobbies);

        // 复制了值类型，没有复制引用对象
        ShallowPrototype clone = shallowPrototype.clone();
        clone.setName("harry");
        clone.getHobbies().add("绘画");
        System.out.println(shallowPrototype.getName());
        System.out.println(shallowPrototype.getHobbies());

        System.out.println(shallowPrototype == clone);
    }
}
