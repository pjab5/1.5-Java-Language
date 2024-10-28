package Level1;

import java.io.Serializable;

public class Persona implements Serializable {
    private int age;
    private String name;
    Persona(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
