package com.sparta.ahmed.model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO {


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

    public static void deleteDB() {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("TRUNCATE `csvproject`.`employees`");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void queryDB(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getString(5));
                System.out.println(resultSet.getString(6));
                System.out.println(resultSet.getString(7));
                System.out.println(resultSet.getDate(8));
                System.out.println(resultSet.getDate(9));
                System.out.println(resultSet.getInt(10));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<EmployeeDTO> readSQLTable() {
        ArrayList<EmployeeDTO> employeesFromSQL = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                //LocalDate localDate = resultSet.getDate(8).toLocalDate();
                LocalDate dob = resultSet.getDate(8).toLocalDate();
                LocalDate doj = resultSet.getDate(9).toLocalDate();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                employeesFromSQL.add(new EmployeeDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        dob.format(dateFormatter),
                        doj.format(dateFormatter),
                        String.valueOf(resultSet.getInt(10))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeesFromSQL;
    }

    public static void insertData(List<EmployeeDTO> employees) {
        for (EmployeeDTO employee : employees) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `csvproject`.`employees` (`emp_id`, `name_prefix`, `first_name`, `middle_initial`, `last_name`, `gender`, `email`, `date_of_birth`, `date_of_joining`, `salary`) VALUES (?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1, employee.getEmp_id());
                preparedStatement.setString(2, employee.getNamePrefix());
                preparedStatement.setString(3, employee.getFirstName());
                preparedStatement.setString(4, employee.getMiddleInitial());
                preparedStatement.setString(5, employee.getLastName());
                preparedStatement.setString(6, employee.getGender());
                preparedStatement.setString(7, employee.getEmail());
                preparedStatement.setDate(8, Date.valueOf(employee.getDateOfBirth()));
                preparedStatement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
                preparedStatement.setInt(10, employee.getSalary());
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
