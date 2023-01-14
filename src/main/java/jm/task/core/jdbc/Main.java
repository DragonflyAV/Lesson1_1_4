package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        String name1 = "Andrei";
        String name2 = "Alexander";
        String name3 = "Alexei";
        String name4 = "Anastasya";
        userService.saveUser(name1, "Vasiliev", (byte) 28);
        System.out.println("User с именем - " + name1 + " добавлен в базу данных");
        userService.saveUser(name2, "Vasiliev", (byte) 27);
        System.out.println("User с именем - " + name2 + " добавлен в базу данных");
        userService.saveUser(name3, "Vasiliev", (byte) 23);
        System.out.println("User с именем - " + name3 + " добавлен в базу данных");
        userService.saveUser(name4, "Vasilieva", (byte) 25);
        System.out.println("User с именем - " + name4 + " добавлен в базу данных");
        System.out.println(userService.getAllUsers().toString());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
