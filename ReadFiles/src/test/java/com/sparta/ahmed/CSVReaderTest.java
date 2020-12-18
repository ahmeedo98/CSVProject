package com.sparta.ahmed;

import com.sparta.ahmed.controller.CSVReader;
import com.sparta.ahmed.model.EmployeeDAO;
import com.sparta.ahmed.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class CSVReaderTest {

    EmployeeDTO employee2 = new EmployeeDTO("178566", "Mrs.", "Juliette", "M", "Rojo", "F", "juliette.rojo@yahoo.co.uk", "5/8/1967", "6/4/2011", "193912");
    EmployeeDTO employee1 = new EmployeeDTO("198429", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294");
    EmployeeDTO employee5 = new EmployeeDTO("260736", "Ms.", "Zelda", "P", "Forest", "F", "zelda.forest@ibm.com", "11/27/1959", "1/28/2014", "176642");
    EmployeeDTO employee8 = new EmployeeDTO("629539", "Dr.", "Del", "I", "Fernandez", "M", "del.fernandez@hotmail.com", "8/13/1991", "4/7/2016", "138662");
    EmployeeDTO employee3 = new EmployeeDTO("647173", "Mr.", "Milan", "F", "Krawczyk", "M", "milan.krawczyk@hotmail.com", "4/4/1980", "1/19/2012", "123681");
    EmployeeDTO employee10 = new EmployeeDTO("744723", "Hon.", "Bibi", "H", "Paddock", "F", "bibi.paddock@yahoo.co.in", "10/20/1991", "11/2/2016", "87148");
    EmployeeDTO employee9 = new EmployeeDTO("784160", "Dr.", "Corey", "A", "Jackman", "M", "corey.jackman@gmail.com", "4/12/1959", "6/29/1984", "57616");
    EmployeeDTO employee6 = new EmployeeDTO("811306", "Mr.", "Rhett", "P", "Wan", "M", "rhett.wan@hotmail.com", "7/14/1976", "1/21/2009", "59406");
    EmployeeDTO employee4 = new EmployeeDTO("847634", "Mr.", "Elmer", "R", "Jason", "M", "elmer.jason@yahoo.com", "4/9/1996", "5/28/2017", "93504");
    EmployeeDTO employee7 = new EmployeeDTO("956633", "Mr.", "Hal", "H", "Farrow", "M", "hal.farrow@cox.net", "3/15/1967", "2/25/1991", "164580");

    ArrayList<EmployeeDTO> employees = new ArrayList<>();

    @Test
    public void checkCSVReaderMakesEmployee() {

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
        employees.add(employee9);
        employees.add(employee10);

        CSVReader csvReader = new CSVReader();
        ArrayList<EmployeeDTO> employees2 = csvReader.readEmployees("src/test/resources/EmployeeRecordsTest.csv");
        Assertions.assertEquals(employees.toString(), employees2.toString());
    }

    @Test
    public void checkCSVReaderWritesToSQLTable() {
        employees.add(employee2);
        employees.add(employee1);
        employees.add(employee5);
        employees.add(employee8);
        employees.add(employee3);
        employees.add(employee10);
        employees.add(employee9);
        employees.add(employee6);
        employees.add(employee4);
        employees.add(employee7);

        String url = "jdbc:mysql://localhost:3306/csvproject";
        EmployeeDAO.connectToDB(url);
        EmployeeDAO.queryDB("SELECT * FROM employees");
        ArrayList<EmployeeDTO> sqlEmployees = EmployeeDAO.readSQLTable();
        Assertions.assertEquals(sqlEmployees.toString(), employees.toString());
    }

    @Test
    public void checkForDuplicates() {
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee8);
        employees.add(employee9);
        employees.add(employee10);

        CSVReader csvReader = new CSVReader();
        ArrayList<EmployeeDTO> employees2 = csvReader.readEmployees("src/test/resources/EmployeeRecordsTestWithDuplicates.csv");
        Assertions.assertEquals(employees.toString(), employees2.toString());

    }


}
