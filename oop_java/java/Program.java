package att_work_java.oop_java.java;

import att_work_java.oop_java.java.Pets.Dog;
import att_work_java.oop_java.java.sql.JavaToMySQL;

/**
 * Program
 */
public class Program {

    public static void main(String[] args) {
        JavaToMySQL javaToMySQL = new JavaToMySQL();

        Dog dog = new Dog(1, "Моряк", "2022-02-02", "sit, serve, voice");
        // javaToMySQL.addPet(dog);

        System.out.println(dog.getCommand());
        
    }
}