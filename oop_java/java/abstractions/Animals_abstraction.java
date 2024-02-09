package att_work_java.oop_java.java.abstractions;

public abstract class Animals_abstraction {
    protected int id;
    protected String name;
    protected String date_birth;
    protected String command;
    
    public Animals_abstraction(int id, String name, String date_birth, String command){

        this.id =id;
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
        return this.command;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setDateBirth(String newDateBirth){
        this.date_birth = newDateBirth;
    }

    //endregion

    @Override
    public String toString() {
        return String.format("Это питомец № %d, его зовут %d, его дата рождения %d", this.id, this.name, this.date_birth);
    }

}
