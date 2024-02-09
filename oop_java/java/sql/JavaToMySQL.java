package att_work_java.oop_java.java.sql;

import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import att_work_java.oop_java.java.subclass.Pack_animals_subclass;
import att_work_java.oop_java.java.subclass.Pets_subclass;

public class JavaToMySQL {

    private String url;
    private String pas;
    private String user;

    public Connection getConnection(){
        Properties proporties = new Properties();
        FileInputStream fis;

        try{
            fis = new FileInputStream("att_work_java/oop_java/resources/Config.properties");
            proporties.load(fis);
            url = proporties.getProperty("url");
            pas = proporties.getProperty("password");
            user = proporties.getProperty("username");
            
        } catch (IOException e){
            System.out.print("FileInputStream error" + e);
        }

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, user, pas);
        } catch(SQLException e){
            System.out.print("Create connection SQL error" + e);
        }

        return connection;
    }

    public void addPet(Pets_subclass pet){

        try(Connection connection = getConnection()){
            Statement stm = connection.createStatement();
            String command = "";
            String cl = pet.getClass().getSimpleName();

            switch(cl.toLowerCase()){
                case "dog":
                    command = "INSERT INTO dog (id_subclass_pet, nickname, date_birth, commands) VALUES (1, '" + pet.getName() + "','" + pet.getDateBirth() + "','"+ pet.getCommand()+"');";
                    stm.executeUpdate(command);
                ;
                case "cat":
                    command = "INSERT INTO cat (id_subclass_pet, nickname, date_birth, commands) VALUES (2, '" + pet.getName() + "','" + pet.getDateBirth() + "','"+ pet.getCommand()+"');";
                    stm.executeUpdate(command);
                ;

                case "hamster":
                    command = "INSERT INTO hamster (id_subclass_pet, nickname, date_birth, commands) VALUES (3, '" + pet.getName() + "','" + pet.getDateBirth() + "','"+ pet.getCommand()+"');";
                    stm.executeUpdate(command);
            }

        } catch(SQLException e){
            System.out.println("При добавление питомца в БД возникла ошибка   " + e);
        }
        
    }

    public void addPackAnumal(Pack_animals_subclass pack_animal){

        try(Connection connection = getConnection()){
            Statement stm = connection.createStatement();
            String command = "";
            String cl = pack_animal.getClass().getSimpleName();

            switch(cl.toLowerCase()){
                case "dog":
                    command = "INSERT INTO horse (id_subclass_pet, nickname, date_birth, commands) VALUES (1, '" + pack_animal.getName() + "','" + pack_animal.getDateBirth() + "','"+ pack_animal.getCommand()+"');";
                    stm.executeUpdate(command);
                ;
                case "cat":
                    command = "INSERT INTO camel (id_subclass_pet, nickname, date_birth, commands) VALUES (2, '" + pack_animal.getName() + "','" + pack_animal.getDateBirth() + "','"+ pack_animal.getCommand()+"');";
                    stm.executeUpdate(command);
                ;

                case "hamster":
                    command = "INSERT INTO donkey (id_subclass_pet, nickname, date_birth, commands) VALUES (3, '" + pack_animal.getName() + "','" + pack_animal.getDateBirth() + "','"+ pack_animal.getCommand()+"');";
                    stm.executeUpdate(command);
            }

        } catch(SQLException e){
            System.out.println("При добавление питомца в БД возникла ошибка   " + e);
        }
        
    }

}