package att_work_java.oop_java.java.abstractions;

public abstract class Animals_abstraction {
    protected int id;
    protected int subclass;
    protected String name;
    protected String date_birth;
    protected String[] command;

    public Animals_abstraction(int id, int subclass, String name, String date_birth, String[] command){
        this.id = id;
        this.subclass = subclass;
        this.name = name;
        this.date_birth = date_birth;
        this.command = command;
    }
    public Animals_abstraction(int subclass, String name, String date_birth, String[] command){
        this.subclass = subclass;
        this.name = name;
        this.date_birth = date_birth;
        this.command = command;
    }

    //region setters & getters
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDateBirth(){
        return this.date_birth;
    }
    public String getCommand(){
        return String.join(",", this.command);
    }
    public int getSubClass(){
        return this.subclass;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setDateBirth(String newDateBirth){
        this.date_birth = newDateBirth;
    }
    
    void showCommand(){
        for(String comm: command){
            System.out.println(comm);
        }
    }

    //endregion

    @Override
    public String toString() {
        return String.format("Это питомец № %d, его зовут %d, его дата рождения %d", this.id, this.name, this.date_birth);
    }

}
