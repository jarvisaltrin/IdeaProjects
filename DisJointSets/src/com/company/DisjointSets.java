package com.company;

import java.util.*;

public class DisjointSets {

    private List<Map<String, Set<String>>> disjointSet;

    public DisjointSets(){
        disjointSet = new ArrayList<Map<String, Set<String>>>();
    }

    public void create_set(String name){
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Set<String> set = new HashSet<String>();
        set.add(name);
        map.put(name, set);
        disjointSet.add(map);
    }

    // Join two subsets into a single subset.
    public void union(String first_name, String second_name){
        String first_rep = find_set(first_name);
        String second_rep = find_set(second_name);

        Set<String> first_set = null;
        Set<String> second_set = null;

        for(int i=0; i<disjointSet.size(); i++){
            Map<String, Set<String>> map = disjointSet.get(i);
            if(map.containsKey(first_rep)){
                first_set = map.get(first_rep);
            }else if(map.containsKey(second_rep)){
                second_set = map.get(second_rep);
            }
        }

        if(first_set != null && second_set != null)
            first_set.addAll(second_set);

        for(int i=0; i<disjointSet.size(); i++) {
            Map<String, Set<String>> map = disjointSet.get(i);
            if(map.containsKey(first_rep)){
                map.put(first_rep,first_set);
            }else if(map.containsKey(second_rep)){
                map.remove(second_rep);
                disjointSet.remove(i);
            }
        }
        return;
    }

    // Determine which subset a particular element is in.
    // This can be used for determining if two elements are in the same subset.
    public String find_set(String name){
        for(int i=0; i<disjointSet.size(); i++){
            Map<String, Set<String>> map = disjointSet.get(i);
            Set<String> keySet = map.keySet();
            for(String key: keySet){
                Set<String> set = map.get(key);
                if(set.contains(name)){
                    return key;
                }
            }
        }
        return null;
    }


    public int set_total(int index, HashMap<String, Integer> points){
        Map<String, Set<String>> map = disjointSet.get(index);
        int sum = 0;
        for(Map.Entry<String, Set<String>> entry: map.entrySet()){
            String key = entry.getKey();
            for(String value: entry.getValue()){
                Integer point = points.get(value);
                sum += (int) point;
            }
        }
        return sum;
    }

    public List<Integer> pointsPerSet(HashMap<String, Integer> points, String[][] pairs){
        List<Integer> list = new ArrayList<Integer>();

        // create as many disjoint set as number of data present
        for(String entry : points.keySet()){
            String name = entry.toString();
            create_set(name);
        }


        for (int i=0; i<pairs.length; i++){
            String first_name = pairs[i][0];
            String second_name = pairs[i][1];
            union(first_name, second_name);
        }

        for (int i=0; i<disjointSet.size(); i++){
            list.add(set_total(i, points));
        }

        return list;
    }

    public static void main(String[] args) {

        DisjointSets disjointSets = new DisjointSets();

        HashMap<String, Integer> points = new HashMap<String, Integer>();
        points.put("Timothy", 2);
        points.put("David", 5);
        points.put("Jonathan", 3);
        points.put("Peter", 7);
        points.put("Elisabeth", 1);
        points.put("James", 4);
        points.put("Sally", 5);

        for(String entry : points.keySet()){
            String name = entry.toString();
            Integer point = points.get(entry);
            System.out.println("Name: " + name + ", Points: " + point);
        }

        String[][] pairs = {{"Timothy", "Jonathan"},
                {"David", "Elisabeth"},
                {"Elisabeth","Jonathan"},
                {"James","Sally"}};

        List<Integer> result = disjointSets.pointsPerSet(points, pairs);
        Collections.sort(result);
        Collections.reverse(result);

        Iterator<Integer> it = result.listIterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

    }
}
