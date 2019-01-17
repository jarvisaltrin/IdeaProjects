package com.company;

public class BaseConversion {

    public int BinaryToDecimal(int binaryNumber){

        int decimal = 0;
        int p = 0;
        while(true){
            if(binaryNumber == 0){
                break;
            } else {
                int temp = binaryNumber%10;
                decimal += temp * Math.pow(2, p);
                binaryNumber /= 10;
                p++;
            }
        }
        return decimal;
    }

    public void DecimalToBinary(int num){
        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    }

    public static void main(String args[]){
        BaseConversion obj = new BaseConversion();
        System.out.println("110 --> "+obj.BinaryToDecimal(110));
        System.out.println("1101 --> "+obj.BinaryToDecimal(1101));
        System.out.println("100 --> "+obj.BinaryToDecimal(100));
        System.out.println("110111 --> "+obj.BinaryToDecimal(110111));

        System.out.println("Binary representation of 124: ");
        obj.DecimalToBinary(124);
        System.out.println("\nBinary representation of 45: ");
        obj.DecimalToBinary(45);
        System.out.println("\nBinary representation of 999: ");
        obj.DecimalToBinary(999);
    }
}