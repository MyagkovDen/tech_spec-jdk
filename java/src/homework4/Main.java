package src.homework4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, List.of("+71234567890", "+72134567890"), "Alex", 8);
        Employee emp2 = new Employee(2, List.of("+71236547890"), "Petr", 3);
        Employee emp3 = new Employee(3, List.of("+73214567890"), "Maria", 8);
        Employee emp4 = new Employee(4, List.of("+71234567809", "+71324567809", "+71243567809"), "Elena", 12);
        Employee emp5 = new Employee(5, List.of("+71234568790"), "Egor", 5);
        Employee emp6 = new Employee(6, List.of("+71234658790"), "Anna", 8);
        Employee emp7 = new Employee(7, List.of("+71234657890"), "Alex", 5);

        //создать справочник сотрудников
        Directory handbook  = new Directory();

        //добавить новых сотрудников в справочник
        handbook.addEmployee(emp1);
        handbook.addEmployee(emp2);
        handbook.addEmployee(emp3);
        handbook.addEmployee(emp4);
        handbook.addEmployee(emp5);
        handbook.addEmployee(emp6);
        handbook.addEmployee(emp7);

        //найти сотрудника по стажу
        List<Employee> list = handbook.getEmployeeBySeniority(8);
        System.out.println(list);

        //вывести телефоны по имени
        handbook.printPhoneByName("Alex");

        //найти сотрудника по табельному номеру
        Employee employee = handbook.getEmployeeById(3);
        System.out.println(employee);

    }
}
