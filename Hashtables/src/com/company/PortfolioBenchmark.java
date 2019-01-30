package com.company;


import java.util.*;

public class PortfolioBenchmark {
    static class Data{
        private String name;
        private String assetType;
        private int shares;
        private int price;
        private double interest;

        public Data(String name, String assetType, int shares, int price, double interest) {
            this.name = name;
            this.assetType = assetType;
            this.shares = shares;
            this.price = price;
            this.interest = interest;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    ", assetType='" + assetType + '\'' +
                    ", shares=" + shares +
                    ", price=" + price +
                    ", interest=" + interest +
                    '}';
        }
    }

    public static void main(String[] args){
        String line = "Google,STOCK,10,50,0|Microsoft,STOCK,15,50,0|IBM,BOND,15,100,0.05:IBM,BOND,20,100,0.05|Google,STOCK,15,50,0|Microsoft,STOCK,10,50,0.05";


        String[] division = line.split(":");
        String str = division[0];
        String[] port = str.split("\\|");
        str = division[1];
        String[] bench = str.split("\\|");

        Data[] portfolio = new Data[port.length];
        Data[] benchmark = new Data[bench.length];

        for(int i=0;i<port.length;i++){
            String[] each = port[i].split(",");
            portfolio[i] = new Data(each[0], each[1], Integer.valueOf(each[2]), Integer.valueOf(each[3]), Double.valueOf(each[4]));
        }

        for(int i=0;i<bench.length;i++){
            String[] each = bench[i].split(",");
            benchmark[i] = new Data(each[0], each[1], Integer.valueOf(each[2]), Integer.valueOf(each[3]), Double.valueOf(each[4]));
        }

        for(int i=0;i<benchmark.length;i++){
            System.out.println("B: "+ benchmark[i].toString());
            System.out.println("P: "+ portfolio[i].toString());
        }

        TreeMap<String, String> output = new TreeMap<>();

        for(int i=0;i<benchmark.length;i++){
            for(int j=0;j<portfolio.length;j++){
                if(benchmark[i].name.equals(portfolio[j].name)){
                    if(portfolio[j].shares < benchmark[i].shares){
                        output.put(portfolio[j].name,"BUY,"+portfolio[j].name+","+(benchmark[i].shares-portfolio[j].shares));
                    }else if (portfolio[j].shares > benchmark[i].shares) {
                        output.put(portfolio[j].name,"SELL,"+portfolio[j].name+","+(portfolio[j].shares-benchmark[i].shares));
                    }
                }
            }
        }

        for(Map.Entry<String, String> entry : output.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
