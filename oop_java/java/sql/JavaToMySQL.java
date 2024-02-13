package att_work_java.oop_java.java.sql;

import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import att_work_java.oop_java.java.subclass.*;

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

    public int addPetSQLCommand(Pets_subclass pet){
        try(Connection connection = getConnection()){
            Statement stm = connection.createStatement();
            stm.executeUpdate("INSERT INTO " + pet.getClass().getSimpleName().toLowerCase() +" (id_subclass, nickname, date_birth, commands) VALUES ("+ pet.getSubClass() +", '" + pet.getName() + "','" + pet.getDateBirth() + "','"+ pet.getCommand()+"');");
            return 1;
        } catch(SQLException e){
            System.out.println("При добавление питомца в БД возникла ошибка\n" + e);
            return 0;
        }
        
    }

    public int addPackAnimalSQLCommand(Pack_animals_subclass animal){

        try(Connection connection = getConnection()){
            Statement stm = connection.createStatement();

            stm.executeUpdate("INSERT INTO " + animal.getClass().getSimpleName().toLowerCase() +" (id_subclass, nickname, date_birth, commands) VALUES ("+ animal.getSubClass() +", '" + animal.getName() + "','" + animal.getDateBirth() + "','"+ animal.getCommand()+"');");
            
            return 1;
        } catch(SQLException e){
            System.out.println("При добавление питомца в БД возникла ошибка\n" + e);
            return 0;
        }
        
    }

    public void getAnimalsSQLCommand(){

        try(Connection connection = getConnection()){
            Statement stm = connection.createStatement();
            String sql = "SELECT *, \"camel\" as subclass  FROM camel union SELECT *, \"cat\" as subclass FROM cat union SELECT *, \"dog\" as subclass FROM dog union SELECT *, \"donkey\" as subclass FROM donkey union SELECT *, \"hamster\" as subclass FROM hamster union SELECT *, \"horse\" as subclass FROM horse";

            ResultSet res = stm.executeQuery(sql);

            while(res.next()){
                String str = String.format("Id питомца: %s, класс субпитомца %s кличка питомца %s, дата рождения %s, список команд: %s",  
                res.getInt("id"), 
                res.getString("subclass"), 
                res.getString("nickname"),
                res.getString("date_birth"),
                res.getString("commands")
                );
                System.out.println(str);
            }
        } catch(SQLException e){
            System.out.println("Ошибка при получение списка животных из БД" + e);

        }
    }

    public void getSortAnimalSQLCommand(){
        try(Connection connection = getConnection()){
            Statement stm = connection.createStatement();
            String sql = "SELECT *  FROM camel union SELECT * FROM cat union SELECT * FROM dog union SELECT * FROM donkey union SELECT * FROM hamster union SELECT * FROM horse order by date_birth desc";

            ResultSet res = stm.executeQuery(sql);

            while(res.next()){
                String str = String.format("Id питомца: %s кличка питомца %s, дата рождения %s, список команд: %s",  
                res.getInt("id"), 
                res.getString("nickname"),
                res.getString("date_birth"),
                res.getString("commands")
                );
                System.out.println(str);
            }
        } catch(SQLException e){
            System.out.println("Ошибка при получение списка животных из БД" + e);

        }
    }
    public void showAnimalCommandSQLCommand(String cl, int idAnimal){
        try(Connection connection = getConnection()){
            Statement stm = connection.createStatement();

            String sql = "SELECT * FROM " + cl + " WHERE id=" + idAnimal +";";
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                String str = String.format("Питомец по кличеке: %s, умеет: %s",  
                    rs.getString("nickname"),
                    rs.getString("commands")
                    );
                System.out.println(str);
            }
        } catch(SQLException e){
            System.out.println("Ошибка при получение списка команд по классу " + e);

        }
    }

    public void addCommandSQLCommand(int cl, String command){


        try(Connection connection = getConnection()){
            Statement stm = connection.createStatement();
            String sql = null;
            String line = "";

            if(cl == 1){
                sql = "SELECT commands FROM dog UNION SELECT commands FROM cat UNION SELECT commands FROM hamster";
            } else if(cl == 2) {
                sql = "SELECT commands FROM horse UNION SELECT commands FROM camle UNION SELECT commands FROM donkey";
            }

            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                line = rs.getString("commands");
            }

            line = line +", " + command;

            PreparedStatement prs1 = null;
            PreparedStatement prs2 = null;
            PreparedStatement prs3 = null;

            if(cl == 1){
                prs1 = connection.prepareStatement("UPDATE `dog` SET `commands`=?;");
                prs2 = connection.prepareStatement("UPDATE `cat` SET `commands`=?");
                prs3 = connection.prepareStatement("UPDATE `hamster` SET `commands`=?;");
            } else if(cl == 2) {
                prs1 = connection.prepareStatement("UPDATE `horse` SET `commands`=?;");
                prs2 = connection.prepareStatement("UPDATE `camle` SET commands=?;");
                prs3 = connection.prepareStatement("UPDATE `donkey` SET commands=?;");
            }
            prs1.setString(1, line);
            prs2.setString(1, line);
            prs3.setString(1, line);

            prs1.executeUpdate();
            prs2.executeUpdate();
            prs3.executeUpdate();

        } catch(SQLException e){
            System.out.println("При подключение к БД для добавления комманды проиошла ошибка " + e);
        }
    }
}