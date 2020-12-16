package com.sparta.ahmed;

import com.sparta.ahmed.controller.CSVReader;
import com.sparta.ahmed.controller.EmployeeDAO;
import com.sparta.ahmed.model.EmployeeDTO;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {

        String url = "jdbc:mysql://localhost:3306/csvproject";
        EmployeeDAO.connectToDB(url);
        //UserDAO.insertData("1","ahmed","lol","de","dsds","sds","23","dsd","dsd","dsds");
        //UserDAO.queryDB();

        CSVReader csvReader = new CSVReader();
        ArrayList<EmployeeDTO> employees = csvReader.readEmployees("src/main/resources/EmployeeRecords.csv");
        for (EmployeeDTO employee : employees) {
            EmployeeDAO.insertData(employee.getEmp_id(),employee.getNamePrefix(),employee.getFirstName(),employee.getMiddleInitial(), employee.getLastName(), employee.getGender(), employee.getEmail(), employee.getDateOfBirth(), employee.getDateOfJoining(), employee.getSalary());
        }

        //System.out.println(EmployeeDTO.());
    }
}
