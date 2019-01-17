package com.company;

public class ReverseAddPalindrome {

    long reverseNumber(long num){
        long rev = 0;
        while(num > 0){
            rev = rev*10 + num%10;
            num /= 10;
        }
        return rev;
    }

    boolean isPalindrome(long num){
        return (reverseNumber(num) == num);
    }

    void reverseAddCheck(long num){
        long rev = 0;
        int count = 0;
        while(num <= 4294967295l){
            rev = reverseNumber(num);
            num += rev; //add to original number
            count++;
            if(isPalindrome(num)){
                System.out.println("Number of times the process ran: " + count);
                System.out.println("The number is: " + num);
                return;
            }
            else if(num > 4294967295l){
                System.out.print("No palindrome found!");
            }
        }
    }

    public static void main(String[] args){

        ReverseAddPalindrome obj = new ReverseAddPalindrome();
        obj.reverseAddCheck(195l);
        obj.reverseAddCheck(2651);
        obj.reverseAddCheck(5000);
    }

}
