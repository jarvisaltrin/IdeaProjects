package com.company;

public class MainArrayStack {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("Jane", "Jones", 123));
        stack.push(new Employee("John", "Doe", 123));
        stack.push(new Employee("Mary", "Smith", 123));
        stack.push(new Employee("Mike", "Wilson", 123));
        stack.push(new Employee("Bill", "End", 123));

        //stack.printStack();

        System.out.println(stack.peek());

        System.out.println("Popped: " + stack.pop());

        System.out.println(stack.peek());
    }
}
