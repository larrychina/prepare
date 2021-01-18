package org.larry.design.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 深克隆
 */
public class DeepPrototype implements Serializable,Cloneable {

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

    /**
     * 深克隆，会破坏单例模式
     * @return
     */
    public DeepPrototype deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (DeepPrototype) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype shallowPrototype = new DeepPrototype() ;
        shallowPrototype.setName("larry");
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("play game");
        shallowPrototype.setHobbies(hobbies);

        // 复制了值类型，没有复制引用对象
        DeepPrototype clone = shallowPrototype.deepClone();
        clone.setName("harry");
        clone.getHobbies().add("绘画");
        System.out.println(shallowPrototype.getName());
        System.out.println(shallowPrototype.getHobbies());

        System.out.println(shallowPrototype == clone);
    }
}
