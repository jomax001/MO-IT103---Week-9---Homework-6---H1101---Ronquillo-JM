/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatedpayrollsystem;

/**
 *
 * @author Jomax
 */
public class Employee {
    public String employeeNumber;
    public String username;
    public String password;
    public String role;
    public String firstName;
    public String lastName;

    public Employee(String employeeNumber, String username, String password, String role, String firstName, String lastName) {
        this.employeeNumber = employeeNumber;
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}