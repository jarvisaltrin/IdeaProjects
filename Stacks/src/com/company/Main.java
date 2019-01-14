package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args){
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String str){

        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder strNoPunctuation = new StringBuilder(str.length());
        String lowerCase = str.toLowerCase();

        for(int i=0;i<lowerCase.length();i++){
            char c=lowerCase.charAt(i);
            if(c>='a' && c<='z'){
                strNoPunctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reveresedStr = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            reveresedStr.append(stack.pop());
        }

        return (reveresedStr.toString().equals(strNoPunctuation.toString()));

    }
}
