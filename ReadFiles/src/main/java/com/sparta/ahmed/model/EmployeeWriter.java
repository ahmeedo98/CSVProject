package com.sparta.ahmed.model;

import java.util.ArrayList;

public class EmployeeWriter implements Runnable {

    private final ArrayList<EmployeeDTO> employees;

    public EmployeeWriter(ArrayList<EmployeeDTO> employees) {
        this.employees = employees;
    }

    @Override
    public void run() {
        String url = "jdbc:mysql://localhost:3306/"; // Enter the database name here!!!!!
        EmployeeDAO.connectToDB(url);
        EmployeeDAO.insertData(employees);
    }
}
