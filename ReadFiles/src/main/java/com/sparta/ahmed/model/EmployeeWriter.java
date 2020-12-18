package com.sparta.ahmed.model;

import com.sparta.ahmed.model.EmployeeDAO;
import com.sparta.ahmed.model.EmployeeDTO;

import java.util.ArrayList;

public class EmployeeWriter implements Runnable {

    private final ArrayList<EmployeeDTO> employees;

    public EmployeeWriter(ArrayList<EmployeeDTO> employees) {
        this.employees = employees;
    }

    @Override
    public void run() {
        String url = "jdbc:mysql://localhost:3306/csvproject";
        EmployeeDAO.connectToDB(url);
        EmployeeDAO.insertData(employees);
    }
}
