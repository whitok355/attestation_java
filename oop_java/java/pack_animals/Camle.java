package att_work_java.oop_java.java.pack_animals;

import att_work_java.oop_java.java.subclass.Pack_animals_subclass;

public class Camle extends Pack_animals_subclass{
    
    public Camle(int id, int subclass, String name, String date_birth, String[] command) {
        super(id, subclass, name, date_birth, command);
    }
    public Camle(int subclass, String name, String date_birth, String[] command) {
        super(subclass, name, date_birth, command);
    }    

}
