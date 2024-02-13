package att_work_java.oop_java.java.pack_animals;

import att_work_java.oop_java.java.subclass.Pack_animals_subclass;

public class Horse extends Pack_animals_subclass{

    public Horse(int id, int subclass, String name, String date_birth, String[] command) {
        super(id, subclass, name, date_birth, command);
    }

    public Horse(int subclass, String name, String date_birth, String[] command) {
        super(subclass, name, date_birth, command);
    }

}
