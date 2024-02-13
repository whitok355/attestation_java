package att_work_java.oop_java.java;

import java.util.Scanner;

import att_work_java.oop_java.java.Pets.*;
import att_work_java.oop_java.java.pack_animals.*;
import att_work_java.oop_java.java.sql.JavaToMySQL;

public class Registry {

    private JavaToMySQL javaToMySQL = new JavaToMySQL();
    private Scanner scan = new Scanner(System.in);
    private int count = 0;
    String[] commandsPets = {"sit, serve, voice"};
    String[] commandsPackAnimal = {"sit, serve, voice, load, unload"};

    public void start(){
        Boolean flag = true;
        while(flag){
            System.out.println("Начнем: \n1- да \n2-  выход");
            int route = scan.nextInt();

            switch(route){
                case 2:
                    flag = false;
                    System.out.println("До новых встреч");
                    break;
                case 1:
                    System.out.println("Программа-реестр домашних животных");

                    int i = router();
                    if(i == 0){
                        flag = false;
                    };
                    break;
                default: 
                    System.out.println("Такого маршрута не предложено.");
                    break;
            }
        }
    }

    private int router(){

        Boolean flag = true;

        while(flag){
            System.out.println("Выберите действие: \n1- Добавить животное, \n2- Вывести список животных, \n3- Вывести список команд животного, \n4- Обучить животные новым командам, \n5- Вывести список животных по дате рождения");
            int route = scan.nextInt();
    
            switch(route){
                case 1:
                    addAnimal();
                    flag = false;
                break;
                case 2:
                    showAnimals();
                    flag = false;
                case 3:
                    showCommands();
                    flag = false;
                    break;
                case 4:
                    addCommand();
                    flag = false;
                    break;
                case 5:
                    sortAnimals();
                    flag = false;
                default:
                    System.out.println("Такого действия нет");
                break;
            }
        }
        return 1;
    }

    private void addAnimal(){
        Boolean flag = true;
        int res = 0;

        while(flag){
            System.out.println("Введите класс питомца: \n1-Pets \n2-Pack animals");
            int cl = scan.nextInt();
    
            switch(cl){
                case 1:
                    flag = false;
                    res = addPet();
                break;
    
                case 2:
                    flag = false;
                    res = addPackAnimal();
                break;
    
                default:
                    System.out.println("Такого класса питомца нет");
                break;
            }

            if(res == 1){
                System.out.println("Питомец успешно добавлен в БД");
            }
        }
    }

    private int addPet(){
        Boolean flag = true;
        int res = 0;

        while(flag){
            scan.nextLine();
            System.out.println("Введите кличку:");
            String nickname = scan.nextLine();
              
            System.out.println("Выберите тип питомца:\n1-dog\n2-cat\n3-hamster");
            int subclass = scan.nextInt();

            scan.nextLine();

            System.out.println("Введите дату рождения:");
            String date_birth = scan.nextLine();

            switch (subclass) {
                case 1:
                    javaToMySQL.addPetSQLCommand(new Dog(subclass, nickname, date_birth, commandsPets));
                    flag = false;
                    res = 1;
                break;
    
                case 2:
                    javaToMySQL.addPetSQLCommand(new Cat(subclass, nickname, date_birth, commandsPets));
                    flag = false;
                    res = 1;
                break;
    
                case 3:
                    javaToMySQL.addPetSQLCommand(new Hamster(subclass, nickname, date_birth, commandsPets));
                    flag = false;
                    res = 1;
                break;
                default:
                    System.out.println("Такого типа питомца нет");
                    res = 0;
                break;
            }
        }
        return res;
    }

    private int addPackAnimal(){
        Boolean flag = true;
        int res = 1;


        while(flag){

            System.out.println("Введите кличку:");
            String nickname = scan.nextLine();
      
            System.out.println("Выберите тип питомца:\n1-horse\n2-camel\n3-donkey");
            int subclass = Integer.parseInt(scan.nextLine());

            System.out.println("Введите дату рождения:");
            String date_birth = scan.nextLine();
    
            switch (subclass) {
                case 1:
                    javaToMySQL.addPackAnimalSQLCommand(new Horse(subclass, nickname, date_birth, commandsPackAnimal));
                    flag = false;
                    res = 1;
                break;
    
                case 2:
                    javaToMySQL.addPackAnimalSQLCommand(new Camle(subclass, nickname, date_birth, commandsPackAnimal));
                    flag = false;
                    res = 1;
                break;
    
                case 3:
                    javaToMySQL.addPackAnimalSQLCommand(new Donkey(subclass, nickname, date_birth, commandsPackAnimal));
                    flag = false;
                    res = 1;
                break;
                default:
                    System.out.println("Такого типа питомца нет");
                    res = 0;
                break;
            }
        }
        return res;
    };

    private void showAnimals(){
        javaToMySQL.getAnimalsSQLCommand();
    }

    private void showCommands(){
        System.out.println("Укажите класс животного по которому нужно вывести команду:\n1-dog\n2-cat\n3-hamster\n4-horse\n5-camel\n6-donkey");
        int cl = scan.nextInt();

        System.out.println("Укажите id животного по которому нужно показать команды:");
        int idAnimal = scan.nextInt();

        javaToMySQL.showAnimalCommandSQLCommand(getClassString(cl), idAnimal);

    }

    private void addCommand(){

        System.out.println("Укажите класс животных по которым будет добавлена команда:\n1-pets\n2-pack animals");
        int cl = scan.nextInt();

        scan.nextLine();

        System.out.println("Укажите команду");
        String command = scan.nextLine();

        javaToMySQL.addCommandSQLCommand(cl, command);

    }

    private void sortAnimals(){

        System.out.println("Вывожу список животных по дате рождения");

        javaToMySQL.getSortAnimalSQLCommand();

    }

    private String getClassString(int id){
        String cl = null;

        switch(id){
            case 1:
                cl = "dog";
            break;
            case 2:
                cl = "cat";
            break;
            case 3:
                cl = "hamster";
            break;
            case 4:
                cl = "horse";
            break;
            case 5:
                cl = "comle";
            break;
            case 6:
                cl = "donkey";
            break;
        }
        return cl;
    }


}