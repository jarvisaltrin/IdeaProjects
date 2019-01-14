package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainHashMap {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 123);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Wilson", mikeWilson);
        hashMap.put("Smith", marySmith);
        hashMap.put("End", billEnd);

        Iterator<Employee> iterator = hashMap.values().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //hashMap.forEach((k,v) -> System.out.println("Key = " + k + ", Employee = " + v));


        System.out.println(hashMap.containsKey("Dow"));
        System.out.println(hashMap.containsValue(janeJones));


        //
        // hashMap.putIfAbsent("Doe",mikeWilson);

        System.out.println(hashMap.getOrDefault("Someone",mikeWilson));
        hashMap.remove("Jones");

        hashMap.forEach((k,v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }
}
