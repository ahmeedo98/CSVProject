package com.sparta.ahmed;
import com.sparta.ahmed.model.EmployeeDTO;
//import com.sparta.mg.model.EmployeeDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CSVReader {
    public static ArrayList<EmployeeDTO> readEmployees(String path) {
        ArrayList<EmployeeDTO> employees = new ArrayList<>();
        ArrayList<EmployeeDTO> employeesDuplicate = new ArrayList<>();
        int countDuplicates = 0;
        HashSet isDuplicate = new HashSet();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String[] employeeArray = line.split(",");
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
                if(!isDuplicate.add(employeeArray[0])){
                    employeesDuplicate.add(employee);
                    countDuplicates++;
                    System.out.println(countDuplicates);
                }
                else{
                    employees.add(employee);
                }

            }
            System.out.println(countDuplicates);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}