package com.sparta.ahmed.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDTO {
    String emp_id;
    String namePrefix;
    String firstName;
    String middleInitial;
    String lastName;
    String gender;
    String email;
    LocalDate dateOfBirth;
    LocalDate dateOfJoining;
    Integer salary;

    public EmployeeDTO(){

    }

    public EmployeeDTO(String emp_id, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dateOfBirth, String dateOfJoining, String salary) {
        this.emp_id = emp_id;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        setDateOfBirth(dateOfBirth);
        setDateOfJoining(dateOfJoining);
        setSalary(salary);
    }



    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = LocalDate.parse(dateOfJoining, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = Integer.valueOf(salary);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "emp_id='" + emp_id + '\'' +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoining=" + dateOfJoining +
                ", salary=" + salary +
                '}';
    }

    public static EmployeeDTO generateEmployee(String[] arrayOfStrings){
        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmp_id(arrayOfStrings[0]);
        employee.setNamePrefix(arrayOfStrings[1]);
        employee.setFirstName(arrayOfStrings[2]);
        employee.setMiddleInitial(arrayOfStrings[3]);
        employee.setLastName(arrayOfStrings[4]);
        employee.setGender(arrayOfStrings[5]);
        employee.setEmail(arrayOfStrings[6]);
        employee.setDateOfBirth(arrayOfStrings[7]);
        employee.setDateOfJoining(arrayOfStrings[8]);
        employee.setSalary(arrayOfStrings[9]);
        return employee;
    }

}
