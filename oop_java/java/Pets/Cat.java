package att_work_java.oop_java.java.Pets;


import att_work_java.oop_java.java.subclass.Pets_subclass;

public class Cat extends Pets_subclass{

    public Cat(int id, int subclass, String name, String date_birth, String[] command) {
        super(id, subclass, name, date_birth, command);
    }

    public Cat(int subclass, String name, String date_birth, String[] command) {
        super(subclass, name, date_birth, command);
    }

}
