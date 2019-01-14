package com.company;

import java.util.*;

public class MainChallenge2 {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 124));
        employees.add(new Employee("Mary", "Smith", 22));
        employees.add(new Employee("Mike", "Wilson", 3245));
        employees.add(new Employee("John", "Doe", 124));
        employees.add(new Employee("Bill", "End", 78));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));

        HashMap<Integer, Employee> employeeTable = new HashMap<>();
        ListIterator<Employee> iterator = employees.listIterator();
        List<Employee> remove = new ArrayList<>();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employeeTable.containsKey(employee.getId())){
                remove.add(employee);
            }else{
                employeeTable.put(employee.getId(),employee);
            }
        }
        for(Employee employee: remove){
            employees.remove(employee);
        }
        System.out.println("===========================");
        employees.forEach(e -> System.out.println(e));
    }
}
