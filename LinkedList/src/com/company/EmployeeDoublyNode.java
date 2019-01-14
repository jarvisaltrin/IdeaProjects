package com.company;

public class EmployeeDoublyNode {

    private Employee employee;
    private EmployeeDoublyNode next;
    private EmployeeDoublyNode previous;

    public EmployeeDoublyNode(Employee employee){
        this.employee = employee;
    }

    public EmployeeDoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeDoublyNode previous) {
        this.previous = previous;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDoublyNode getNext() {
        return next;
    }

    public void setNext(EmployeeDoublyNode next) {
        this.next = next;
    }

    public String toString(){
        return employee.toString();
    }
}
