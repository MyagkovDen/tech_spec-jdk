package src.homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Directory {
    private List<Employee> directory;

    public Directory() {
        this.directory = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.directory.add(employee);
    }

    public List<Employee> getEmployeeBySeniority(int seniority) {
        return this.directory.stream()
                .filter(employee -> employee.getSeniority() == seniority)
                .toList();
    }

    public void printPhoneByName(String name) {
        this.directory.stream()
                .filter(employee -> employee.getName().equals(name))
                .forEach(employee -> System.out.println(employee.getName() + " " + employee.getPhone()));
    }

    public Employee getEmployeeById(int id) {
        return this.directory.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst().orElse(null);
    }
}
