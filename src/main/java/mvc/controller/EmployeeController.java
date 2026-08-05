package mvc.controller;

import mvc.model.Employee;

import java.util.ArrayList;

public class EmployeeController {

    private final ArrayList<Employee> employees = new ArrayList<>();

    public boolean addEmployee(Employee employee) {
        try {
            if (employee == null ||
                    employee.getName().isBlank() ||
                    employee.getIdNumber().isBlank() ||
                    employee.getDirectorate().isBlank() ||
                    employee.getAge() <= 0) {
                throw new IllegalArgumentException("Semua data employee harus diisi.");
            }
            employees.add(employee);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal menambahkan employee: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Employee> getAllEmployees() {
        try {
            return employees;
        } catch (Exception e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Employee getEmployeeById(String idNumber) {
        try {
            for (Employee employee : employees) {
                if (employee.getIdNumber().equalsIgnoreCase(idNumber)) {
                    return employee;
                }
            }
            throw new Exception("Employee tidak ditemukan.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean updateEmployee(String idNumber, Employee newEmployee) {
        try {
            Employee employee = getEmployeeById(idNumber);
            if (employee == null) {
                throw new Exception("Employee tidak ditemukan.");
            }
            employee.setName(newEmployee.getName());
            employee.setAge(newEmployee.getAge());
            employee.setDirectorate(newEmployee.getDirectorate());

            return true;
        } catch (Exception e) {
            System.out.println("Gagal update: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteEmployee(String idNumber) {
        try {
            Employee employee = getEmployeeById(idNumber);
            if (employee == null) {
                throw new Exception("Employee tidak ditemukan.");
            }
            employees.remove(employee);
            return true;
        } catch (Exception e) {
            System.out.println("Gagal menghapus: " + e.getMessage());
            return false;
        }
    }
}