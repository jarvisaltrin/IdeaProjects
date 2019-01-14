package com.company;



public class MainLinkedStack {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 123);
        Employee marySmith = new Employee("Mary", "Smith", 123);
        Employee mikeWilson = new Employee("Mike", "Wilson", 123);
        Employee billEnd = new Employee("Bill", "End", 123);

        LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);

        stack.printStack();

        System.out.println("Peek: " + stack.peek());

        System.out.println("Popped: " + stack.pop());

        System.out.println("Peek: " + stack.peek());

    }
}
