package com.company;

public class EmployeeDoublyLinkedList {

    private EmployeeDoublyNode head;
    private EmployeeDoublyNode tail;
    private int size;

    public void addToFront(Employee employee){
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);
        node.setNext(head);
        if(head == null){
            tail = node;
        }else{
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    public void addToEnd(Employee employee){
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);
        if(tail == null){
            head = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public EmployeeDoublyNode removeFromFront(){
        if (isEmpty())
            return null;
        EmployeeDoublyNode removeNode = head;

        if(head.getNext() == null){
            tail = null;
        }else{
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public EmployeeDoublyNode removeFromEnd(){
        if(isEmpty())
            return null;

        EmployeeDoublyNode removeNode = tail;
        if(tail.getPrevious() == null){
            head = null;
        }else{
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removeNode.setPrevious(null);
        return removeNode;
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee){
        if(head == null)
            return false;

        // find the existing employee
        EmployeeDoublyNode current = head;
        while(current != null && !current.getEmployee().equals(existingEmployee)){
            current = current.getNext();
        }

        if (current == null)
            return false;

        EmployeeDoublyNode newNode = new EmployeeDoublyNode(newEmployee);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);
        if(head == current){
            head = newNode;
        }else{
            newNode.getPrevious().setNext(newNode);
        }
        size++;
        return true;
    }


    public void printList(){
        EmployeeDoublyNode current = head;
        System.out.println("HEAD -> ");
        while(current != null){
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }


}
