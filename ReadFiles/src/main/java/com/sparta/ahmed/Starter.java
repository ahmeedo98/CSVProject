package com.sparta.ahmed;

import com.sparta.ahmed.controller.CSVReader;
import com.sparta.ahmed.model.EmployeeDTO;
import com.sparta.ahmed.model.ThreadManager;
import com.sparta.ahmed.viewer.Menu;

import java.util.ArrayList;

public class Starter {

    public static void start() {
        //create reader, menu
        CSVReader csvReader = new CSVReader();
        Menu menu = new Menu();

        String path = menu.printStart();

        ArrayList<EmployeeDTO> employees = csvReader.readEmployees(path);

        long start = System.currentTimeMillis() / 1000;
        ThreadManager threadManager = new ThreadManager(employees);
        threadManager.runThreads();
        long finish = System.currentTimeMillis() / 1000;
        System.out.println("Time taken:: " + (finish - start));

    }
}
