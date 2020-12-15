package com.sparta.ahmed;

import com.sparta.ahmed.model.EmployeeDTO;
import com.sparta.ahmed.model.EmployeeRepository;

public class App
{
    public static void main( String[] args )
    {
        CSVReader.readEmployees("src/main/resources/EmployeeRecords.csv").toString();
        //System.out.println(EmployeeDTO.());
    }
}
