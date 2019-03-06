package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

    // Time Complexity - O(n)
    public static int eval(String RPNExpression) {
        Deque<Integer> intermediateResults = new LinkedList<Integer>();
        String delimiter = ",";
        String[] symbols = RPNExpression.split(delimiter);
        for (String token : symbols){
            if (token.length() == 1 && "+-*/".contains(token)){
                final int y = intermediateResults.removeFirst();
                final int x = intermediateResults.removeFirst();
                switch (token.charAt(0)){
                    case '+':
                        intermediateResults.addFirst(x + y);
                        break ;
                    case '-':
                        intermediateResults.addFirst(x - y);
                        break ;
                    case '*':
                        intermediateResults.addFirst(x * y);
                        break ;
                    case '/':
                        intermediateResults.addFirst(x / y);
                        break ;
                    default:
                        throw new IllegalArgumentException("Malformed RPN at :" + token);
                    }
            } else { // token is a number.
                intermediateResults.addFirst(Integer.parseInt(token));
            }
        }
        return intermediateResults.removeFirst();
    }

    public static void main(String[] args){
        String exp = "3,4,+,2,*,1,+"; // (3 + 4) * 2 + 1
        System.out.println(eval(exp));
    }
}
