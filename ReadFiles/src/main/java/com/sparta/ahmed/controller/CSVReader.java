package com.sparta.ahmed.controller;

import com.sparta.ahmed.model.EmployeeDTO;
//import com.sparta.mg.model.EmployeeDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CSVReader {

    private ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private ArrayList<EmployeeDTO> employeesDuplicate = new ArrayList<>();

    public ArrayList<EmployeeDTO> readEmployees(String path) {
        HashSet isDuplicate = new HashSet();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String[] employeeArray = stringToArray(line);
                EmployeeDTO employee = new EmployeeDTO(
                        employeeArray[0],
                        employeeArray[1],
                        employeeArray[2],
                        employeeArray[3],
                        employeeArray[4],
                        employeeArray[5],
                        employeeArray[6],
                        employeeArray[7],
                        employeeArray[8],
                        employeeArray[9]
                );
                //isDuplicate.add(employee);
//                if(employees.contains(employeeArray[0])){
//                    employeesDuplicate.add(employee);
//                }
                if (!isDuplicate.add(employeeArray[0])) {
                    employeesDuplicate.add(findEmployee(employeeArray[0]));
                    employees.remove(findEmployee(employeeArray[0]));
                } else {
                    employees.add(employee);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //final statement to make sure bufferreader CLOSES!
        }

        System.out.println("Number of Duplicate records:: " + employeesDuplicate.size() * 2); //convert to menu
        System.out.println("Number of Employees:: " + employees.size()); // convert to menu
        createDuplicatesFile(employeesDuplicate);
        return employees;
    }

    private EmployeeDTO findEmployee(String id) {
        for (EmployeeDTO employee : employees) {
            if (employee.getEmp_id().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    private String[] stringToArray(String line) {
        return line.split(",");
    }

    private void createDuplicatesFile(ArrayList<EmployeeDTO> employeesDuplicate){
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/duplicates.txt");
            for (EmployeeDTO employee: employeesDuplicate) {

                //fileWriter.write(employee.getEmp_id(),employee.getNamePrefix(),employee.getFirstName(),employee.getMiddleInitial(), employee.getLastName(), employee.getGender(), employee.getEmail(), employee.getDateOfBirth(), employee.getDateOfJoining(), employee.getSalary());
                fileWriter.write(employee.toString() + "\n");

            }
            fileWriter.close();
            System.out.println("Created Duplicates txt file");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}