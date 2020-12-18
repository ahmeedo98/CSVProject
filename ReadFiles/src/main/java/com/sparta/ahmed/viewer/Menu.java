package com.sparta.ahmed.viewer;


import java.util.Scanner;

public class Menu {

    public String printStart() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Would you like to:: ");
        System.out.println("1. Add a CSV file to the database?");
        ///System.out.println("2. Reset the SQL server? (DELETE EVERYTHING)");
        System.out.println("2. Exit the program");
        int answer = userInput.nextInt();
        if (answer == 1) {
            return "src/main/resources/EmployeeRecords.csv";
        }
//        } else if (answer == 2) {
//            EmployeeDAO.connectToDB("jdbc:mysql://localhost:3306/csvproject");
//            EmployeeDAO.deleteDB();
//            System.out.println("Everything has been deleted");
//            printStart();
//        }
        else if (answer == 2) {
            System.exit(0);
        } else {
            System.out.println("Please enter 1 or 2");
            printStart();
        }
        return null;
    }


    //show all times for each process (reading csv, printing to database)
    //menu class
    //testing
    //make it fasterrrr!

}
