package com.company;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Vector;

public class CartesianProduct {

    private LinkedHashMap<String, Vector<String>> vector;

    public CartesianProduct(LinkedHashMap<String, Vector<String>> vector){
        this.vector = vector;
    }

    public String[][] allUniqueCombination(){
        int n=vector.keySet().size();
        int no_of_solutions = 1;

        for(Vector<String> vec : vector.values()){
            no_of_solutions *= vec.size();
        }

        String[][] allCombinations = new String[no_of_solutions+1][];
        allCombinations[0] = vector.keySet().toArray(new String[n]);

        for(int i=0; i<no_of_solutions; i++){
            Vector<String> combination = new Vector<>(n);
            int j = 1;
            for(Vector<String> vec : vector.values()){
                combination.add(vec.get((i/j)%vec.size()));
                j *= vec.size();
            }
            allCombinations[i + 1] = combination.toArray(new String[n]);
        }
        return allCombinations;
    }

    public static void main(String[] args){
        LinkedHashMap<String, Vector<String>> data = new LinkedHashMap<>();
        data.put("foo", new Vector<String>(Arrays.asList("1", "2", "3")));
        data.put("bar", new Vector<String>(Arrays.asList("3", "2")));
        data.put("baz", new Vector<String>(Arrays.asList("5", "6", "7")));

        CartesianProduct obj = new CartesianProduct(data);

        for(String[] combination : obj.allUniqueCombination()){
            System.out.println(Arrays.toString(combination));
        }
    }

}
