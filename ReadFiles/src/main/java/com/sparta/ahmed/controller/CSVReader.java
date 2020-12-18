package com.sparta.ahmed.controller;

import com.sparta.ahmed.model.EmployeeDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CSVReader {

    private ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private ArrayList<EmployeeDTO> employeesDuplicate = new ArrayList<>();


    public ArrayList<EmployeeDTO> readEmployees(String path) {
        long start = System.nanoTime() / 1000;
        HashSet isDuplicate = new HashSet();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            String[] splitLine;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                splitLine = line.split(",");
                if (!isDuplicate.add(splitLine[0])) {
                    employeesDuplicate.add(findEmployeeByID(splitLine[0]));
                    employees.remove(findEmployeeByID(splitLine[0]));
                } else if (!isDuplicate.add(splitLine[6])) {
                    employeesDuplicate.add(findEmployeeByEmail(splitLine[6]));
                    employees.remove(findEmployeeByEmail(splitLine[6]));
                } else {
                    employees.add(EmployeeDTO.generateEmployee(splitLine));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long finish = System.nanoTime() / 1000;
        System.out.println("Time taken for copying duplicates and making array etc:: " + (finish - start));
        System.out.println("Number of Duplicate records:: " + employeesDuplicate.size() * 2); //convert to menu
        System.out.println("Number of Employees:: " + employees.size()); // convert to menu
        createDuplicatesFile(employeesDuplicate);

        return employees;
    }

    private EmployeeDTO findEmployeeByID(String id) {
        for (EmployeeDTO employee : employees) {
            if (employee.getEmp_id().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    private EmployeeDTO findEmployeeByEmail(String email) {
        for (EmployeeDTO employee : employees) {
            if (employee.getEmail().equals(email)) {
                return employee;
            }
        }
        return null;
    }

    private String[] stringToArray(String line) {
        return line.split(",");
    }

    private void createDuplicatesFile(ArrayList<EmployeeDTO> employeesDuplicate) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/duplicates.txt");
            for (EmployeeDTO employee : employeesDuplicate) {

                fileWriter.write(employee.toString() + "\n");

            }
            fileWriter.close();
            System.out.println("Created Duplicates txt file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    public ArrayList<EmployeeDTO> readEmployees(String path) {
//        HashSet isDuplicate = new HashSet();
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
//            String line;
//            bufferedReader.readLine();
//            while ((line = bufferedReader.readLine()) != null) {
//                //System.out.println(line);
//                String[] employeeArray = stringToArray(line);
//                EmployeeDTO employee = new EmployeeDTO(
//                        employeeArray[0],
//                        employeeArray[1],
//                        employeeArray[2],
//                        employeeArray[3],
//                        employeeArray[4],
//                        employeeArray[5],
//                        employeeArray[6],
//                        employeeArray[7],
//                        employeeArray[8],
//                        employeeArray[9]
//                );
//                //isDuplicate.add(employee);
////                if(employees.contains(employeeArray[0])){
////                    employeesDuplicate.add(employee);
////                }
//                if (!isDuplicate.add(employeeArray[0])) {
//                    employeesDuplicate.add(findEmployee(employeeArray[0]));
//                    employees.remove(findEmployee(employeeArray[0]));
//                } else {
//                    employees.add(employee);
//                }
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            //final statement to make sure bufferreader CLOSES!
//        }
//
//        System.out.println("Number of Duplicate records:: " + employeesDuplicate.size() * 2); //convert to menu
//        System.out.println("Number of Employees:: " + employees.size()); // convert to menu
//        createDuplicatesFile(employeesDuplicate);
//        return employees;
//    }


}