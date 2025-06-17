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
import javax.swing.JOptionPane;

public class EmployeeDataLoader {
    private List<Employee> employees;

    public EmployeeDataLoader() {
        employees = new ArrayList<>();
        loadEmployeeData();
    }

    private void loadEmployeeData() {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("automatedpayrollsystem/MotorPH_Employee_Data_with_Login.csv");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "❌ CSV file not found inside resources!");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    String username = values[0].trim();
                    String password = values[1].trim();
                    String name = values[2].trim();
                    employees.add(new Employee(username, password, name));
                }
            }

            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "❌ Error loading employee data: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}