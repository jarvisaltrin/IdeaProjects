package com.company;

import java.util.ArrayList;
import java.util.List;

public class BuySellStock {
    /*
    Write a program that takes an array denoting the daily stock price, and returns the
    maximum profit that could be made by buying and then selling one share of that
    stock.
     */
    public static double computeMaxProfit(List<Double> prices){
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for(Double price: prices){
            maxProfit = Math.max(maxProfit, price-minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }

    // Time & Space Complexity - O(n)
    public static double buySellStockTwice(List<Double> prices){
        double maxTotalProfit = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<Double>();
        double minPriceSoFar = Double.MAX_VALUE;

        // Forward phase. For each day we record max profit if we sell on that day
        for(int i=0;i< prices.size(); i++){
            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, prices.get(i)-minPriceSoFar);
            firstBuySellProfits.add(maxTotalProfit);
        }

        // Backward phase. For each day, find the max profit if we make the 2nd buy on that day
        double maxPriceSoFar = Double.MIN_VALUE;
        for(int i=prices.size()-1; i>0; i--){
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar-prices.get(i)+firstBuySellProfits.get(i-1));
        }
        return maxTotalProfit;
    }

    public static void main(String[] args) {
        List<Double> prices = new ArrayList<Double>();
        prices.add(12.0);
        prices.add(11.0);
        prices.add(13.0);
        prices.add(9.0);
        prices.add(12.0);
        prices.add(8.0);
        prices.add(14.0);
        prices.add(13.0);
        prices.add(15.0);

        System.out.println(computeMaxProfit(prices));
        System.out.println(buySellStockTwice(prices));
    }
}
