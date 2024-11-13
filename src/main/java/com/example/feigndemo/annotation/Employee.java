package com.example.feigndemo.annotation;

public class Employee {
    public void setSalary(double salary) {
        System.out.println("Employee.setSalary(" + salary + ")");
    }
}

class Manager extends Employee {
    public void setSalary(int salary) {
        System.out.println("Manager.setSalary(" + salary + ")");
    }
}

class Main {

    public static void main(String[] args) {
        Employee e = new Manager();
        int salary = 200;
        e.setSalary(salary);
    }
}