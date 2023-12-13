package src.homework4;

import java.util.List;

public class Employee {
    private int id;
    private List<String> phone;
    private String name;
    private int seniority;

    public Employee(int id, List<String> phone, String name, int seniority) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.seniority = seniority;
    }

    public int getId() {
        return id;
    }

    public List<String> getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getSeniority() {
        return seniority;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", seniority=" + seniority +
                '}';
    }
}
