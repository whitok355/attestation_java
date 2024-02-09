package att_work_java.oop_java.java.subclass;

import att_work_java.oop_java.java.abstractions.Animals_abstraction;

public class Pets_subclass extends Animals_abstraction  {

    public Pets_subclass(int id, String name, String date_birth, String command) {
        super(id, name, date_birth, command);
    }

    public void move(){
        System.out.println(this.name + "двигается");
    };
    public void jamp(){
        System.out.println(this.name + "прыгает");
    };
    public void sound(){
        System.out.println(this.name + "поет");
    };
    
}
