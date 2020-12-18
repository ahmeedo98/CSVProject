package com.sparta.ahmed;

import com.sparta.ahmed.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeesTest {

    @Test
    public void checkSetID() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmp_id("12121");
        Assertions.assertEquals("12121", employee.getEmp_id());

    }


    @Test
    public void checkSetNamePrefix() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setNamePrefix("Mr.");
        Assertions.assertEquals("Mr.", employee.getNamePrefix());

    }


    @Test
    public void checkSetFirstName() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setFirstName("Ahmed");
        Assertions.assertEquals("Ahmed", employee.getFirstName());

    }


    @Test
    public void checkSetMiddleInitial() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setMiddleInitial("A");
        Assertions.assertEquals("A", employee.getMiddleInitial());
    }


    @Test
    public void checkSetLastName() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setLastName("Ahmed");
        Assertions.assertEquals("Ahmed", employee.getLastName());
    }


    @Test
    public void checkSetGender() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setGender("M");
        Assertions.assertEquals("M", employee.getGender());
    }


    @Test
    public void checkSetSalary() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setSalary("1000000");
        Assertions.assertEquals(1000000, employee.getSalary());
    }


    @Test
    public void checkSetEmail() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmail("exampleemail@email.com");
        Assertions.assertEquals("exampleemail@email.com", employee.getEmail());
    }

}
