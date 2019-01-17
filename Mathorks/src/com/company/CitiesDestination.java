package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Check if a path exist from one city (source) to another city (destination)
 */
public class CitiesDestination {

    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>();
        // Test Case 1:
        // Source - 1 4 3 6
        // Destination - 3 6 2 5
        // n = 6 ; g = 0
        source.add(1);
        source.add(4);
        source.add(5);
        source.add(3);
        List<Integer> destination = new ArrayList<>();
        destination.add(3);
        destination.add(3);
        destination.add(5);
        destination.add(2);
        int n = 6; // number of cities
        int g = 1; // threshold value for gcd
        List<Integer> returnCity = connectedCities(n, g, source, destination);

        for (Integer i : returnCity){
            System.out.println(i);
        }
    }

    static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities){

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++){
            List<Integer> connectedC = new ArrayList<>();
            for (int j = 1; j <= n; j++){
                if (j==i)
                    continue;
                else {
                    if (gcdThing(i, j) > g) {
                        connectedC.add(j);
                    }
                }
            }
            map.put(i, connectedC);
        }

        List<Integer> returnList = new ArrayList<>();

        for (int i = 0; i < originCities.size(); i++){
            List<Integer> visitedC = new ArrayList<>();
            List<Integer> visitedI = new ArrayList<>();
            List<Integer> connectedC = getAllConnectedCities(originCities.get(i), map, visitedC);
            if(connectedC.isEmpty()) {
                returnList.add(0);
                continue;
            }else{
                List<Integer> connectedI = getAllConnectedCities(destinationCities.get(i), map, visitedI);
                connectedC.addAll(connectedI);
                if (connectedC.contains(destinationCities.get(i))){
                    returnList.add(1);
                }else{
                    returnList.add(0);
                }
            }
        }

        return returnList;
    }

    static List<Integer> getAllConnectedCities(int originCity, Map<Integer, List<Integer>> cityMap, List<Integer> visitedCity){
        visitedCity.add(originCity);
        List<Integer> imdCntdCity = cityMap.get(originCity);
        List<Integer> indirectCntdCity = new ArrayList<>();
        for (Integer conCity : imdCntdCity){
            if (!visitedCity.contains(conCity)){
                indirectCntdCity.addAll(getAllConnectedCities(conCity, cityMap, visitedCity));
            }
        }
        imdCntdCity.addAll(indirectCntdCity);

        return imdCntdCity;
    }

    static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}
