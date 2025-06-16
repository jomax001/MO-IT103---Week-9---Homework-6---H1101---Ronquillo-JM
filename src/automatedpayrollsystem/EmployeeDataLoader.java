/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatedpayrollsystem;

/**
 *
 * @author Jomax
 */
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class EmployeeDataLoader {
    private String csvFilePath;

    public EmployeeDataLoader(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(csvFilePath));
            lines.remove(0); // skip header

            for (String line : lines) {
                String[] tokens = line.split(",");
                if (tokens.length >= 6) {
                    Employee emp = new Employee(
                        tokens[0].trim(),  // Employee Number
                        tokens[1].trim(),  // Username
                        tokens[2].trim(),  // Password
                        tokens[3].trim(),  // Role
                        tokens[4].trim(),  // First Name
                        tokens[5].trim()   // Last Name
                    );
                    employees.add(emp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
