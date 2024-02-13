package att_work_java.oop_java.java.subclass;

import att_work_java.oop_java.java.abstractions.Animals_abstraction;

public class Pets_subclass extends Animals_abstraction  {

    public Pets_subclass(int id, int subclass, String name, String date_birth, String[] command) {
        super(id, subclass, name, date_birth, command);
    }

    public Pets_subclass(int subclass, String name, String date_birth, String[] command) {
        super(subclass, name, date_birth, command);
    }
}
