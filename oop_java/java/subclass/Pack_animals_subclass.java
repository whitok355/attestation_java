package att_work_java.oop_java.java.subclass;

import att_work_java.oop_java.java.abstractions.Animals_abstraction;

public class Pack_animals_subclass extends Animals_abstraction{
    
    public Pack_animals_subclass(int id, int subclass, String name, String date_birth, String[] command) {
        super(id, subclass, name, date_birth, command);
    }
    public Pack_animals_subclass(int subclass, String name, String date_birth, String[] command) {
        super(subclass, name, date_birth, command);
    }

}
