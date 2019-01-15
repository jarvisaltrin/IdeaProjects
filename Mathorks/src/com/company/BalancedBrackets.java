package com.company;

import java.util.Stack;

public class BalancedBrackets {

    public static void isBalanced(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='[')
                stack.push(str.charAt(i));
            else {
                if (str.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        System.out.print("False");
                        return;
                    }
                    char popped = stack.pop();
                    if (popped != '(') {
                        System.out.print("False");
                        return;
                    }
                } else if (str.charAt(i) == '}') {
                    if (stack.isEmpty()) {
                        System.out.print("False");
                        return;
                    }
                    if (stack.pop() != '{') {
                        System.out.print("False");
                        return;
                    }
                } else if (str.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        System.out.print("False");
                        return;
                    }
                    if (stack.pop() != '[') {
                        System.out.print("False");
                        return;
                    }
                }
            }
            // Ignore all other characters
        }
        if (stack.isEmpty()){
            System.out.print("True");
            return;
        }
    }

    public static void main(String[] args){
        String str1 = "[()]{}{[()()]()}"; // true
        String str2 = "[(])"; // false
        isBalanced(str1);
        System.out.println();
        isBalanced(str2);
    }
}
