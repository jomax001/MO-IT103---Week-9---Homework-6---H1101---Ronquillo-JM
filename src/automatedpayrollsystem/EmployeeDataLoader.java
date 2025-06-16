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
import javax.swing.*;

public class EmployeeDataLoader {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeDataLoader() throws FileNotFoundException {
        InputStream input = getClass().getClassLoader().getResourceAsStream("MotorPH_Employee_Data2.csv");
if (input == null) {
    throw new FileNotFoundException("Resource not found: MotorPH_Employee_Data2.csv");
}

try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
    String line;
    boolean firstLine = true;

    while ((line = br.readLine()) != null) {
        if (firstLine) {
            firstLine = false;
            continue;
        }

        String[] values = line.split(",");
        if (values.length >= 3) {
            String username = values[0].trim();
            String password = values[1].trim();
            String name = values[2].trim();

            employees.add(new Employee(username, password, name));
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "⚠ Error loading employee data: " + e.getMessage(), "CSV Load Error", JOptionPane.ERROR_MESSAGE);
}
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
