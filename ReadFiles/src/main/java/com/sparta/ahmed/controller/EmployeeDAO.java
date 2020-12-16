package com.sparta.ahmed.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class EmployeeDAO{


    //CRUD -> Example of abstraction
    private static Connection connection;
    private static Properties properties = new Properties();

    private static void createProperties() {
        try {
            properties.load(new FileReader("src/main/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void connectToDB(String url) {
        createProperties();
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Connected to Database");
    }

    public static void queryDB(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tester.employees");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1)); //column 1
                System.out.println(resultSet.getString(2)); //column 2
                System.out.println(resultSet.getString(3)); //column 3
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insertData(String emp_id, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoining, int salary) {
        try {
            //Statement statement = connection.createStatement();
            //PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `tester`.`employees`(`id`,`user_name`,`email`)values (?, ?, ?)");
            //statement.executeUpdate("INSERT INTO `tester`.`users`(`id`,`user_name)`,`email`)values ('2', 'Astha', 'a@s.com')");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `csvproject`.`employees` (`emp_id`, `name_prefix`, `first_name`, `middle_initial`, `last_name`, `gender`, `email`, `date_of_birth`, `date_of_joining`, `salary`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, emp_id);
            preparedStatement.setString(2, namePrefix);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, middleInitial);
            preparedStatement.setString(5, lastName);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setDate(8, Date.valueOf(dateOfBirth));
            preparedStatement.setDate(9, Date.valueOf(dateOfJoining));
            preparedStatement.setInt(10, salary);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    public static void insertData(int id, String userName, String email){
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("INSERT INTO `tester`.`users`(`id`,`user_name)`,`email`)values ("+ id + userName + email + ")");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
}
