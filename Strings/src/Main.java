import java.util.*;
public class Main {
    /*
    Use a hashmap which stores the characters in string as keys and their positions as values,
    and keep two pointers which define the max substring.
    Move the right pointer(i) to scan through the string, and meanwhile update the hashmap.
    If the character is already in the hashmap, then move the left pointer to the right of the
    same character last found. Note that the two pointers can only move forward.

    Time complexity : O(n). Index i will iterate n times.
    Space complexity (HashMap) : O(min(m, n)).
    */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int len = 0;
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        for(int i=0,j=0;i<s.length();i++){
            if(hmap.containsKey(s.charAt(i)))
                j = Math.max(j,hmap.get(s.charAt(i))+1);

            hmap.put(s.charAt(i),i);
            len = Math.max(len,i-j+1);
        }
        return len;
    }


    // Find the most repeated word in a String
    public static String mostRepeatedWord(String s){
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        //Normalize Input
        String loweredCase = s.toLowerCase().trim();
        String[] words = loweredCase.split("[ \\n\\t\\r.,;:!?()]");
        System.out.println(Arrays.toString(words));
        for (String word: words){
            if (word.length()>0){
                if (wordCountMap.containsKey(word)){
                    wordCountMap.put(word,wordCountMap.get(word) + 1);
                }else{
                    wordCountMap.put(word,1);
                }
            }
        }
        int max = 0;
        String mostRepeated = "";
        for (String key: wordCountMap.keySet()){
            int currValue = wordCountMap.get(key);
            if (currValue > max){
                mostRepeated = key;
                max = currValue;
            }
        }
        System.out.println("Most Repeated Word: "+ mostRepeated + "\nRepeated: "+max+ " times.");
        return mostRepeated;

    }

/**
 * Identify all the 'n' (n will be input) letter-long sequences that occur more than once in
 * any given input string.  Write a program that prints out all such sequences to the standard output stream,
 * sorted in alphabetical order.
 *
 * This question can be twisted and asked as: "Find repeating sequences of specified length in given dna
 * chromosome sequence."
 */
    public static void printRepeatingStrings(String inputString, int sequenceLength) {
        if (inputString.isEmpty() || sequenceLength <= 0 || sequenceLength >= inputString.length()) {
            System.out.println("Invalid input");
        } else {
            int i = 0;
            int j = i + sequenceLength;
            Set<String> tempSet = new HashSet<String>();
            Set<String> repeatingSequences = new TreeSet<String>();
            while (j <= inputString.length()) {
                if (!tempSet.add(inputString.substring(i, j))) {
                    repeatingSequences.add(inputString.substring(i, j));
                }
                i++;
                j = i + sequenceLength;
            }
            for (String str : repeatingSequences) {
                System.out.println(str);
            }
        }
    }
    static String longestRepeatedSubstring(String str) {
        int n = str.length();
        int LCSRe[][] = new int[n + 1][n + 1];
        String res = ""; // To store result
        int res_length = 0; // To store length of result
        // building table in bottom-up manner
        int i, index = 0;
        for (i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // (j-i) > LCSRe[i-1][j-1] to remove
                // overlapping
                if (str.charAt(i - 1) == str.charAt(j - 1)
                        && LCSRe[i - 1][j - 1] < (j - i)) {
                    LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;
                    // updating maximum length of the
                    // substring and updating the finishing
                    // index of the suffix
                    if (LCSRe[i][j] > res_length) {
                        res_length = LCSRe[i][j];
                        index = Math.max(i, index);
                    }
                } else {
                    LCSRe[i][j] = 0;
                }
            }
        }
        for (i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++){
                System.out.print(LCSRe[i][j] + "\t");
            }
            System.out.println();
        }
        // If we have non-empty result, then insert all
        // characters from first character to last
        // character of String
        if (res_length > 0) {
            for (i = index - res_length + 1; i <= index; i++) {
                res += str.charAt(i - 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n;
        n = lengthOfLongestSubstring("abcdeadc");
        System.out.println(n);
        String text = "After our successful two editions, Markets and Markets is proud to announce the 3rd Annual High Potent Medicines Conference to be held on 28th-29th May, 2019 in Milan, Italy.";
        String mostRepeated = "";
        mostRepeated = mostRepeatedWord(text);
        System.out.println();
        printRepeatingStrings("ABABBABBZEDZEDZE", 3);
        printRepeatingStrings("AAGATCCGTCCCCCCAAGATCCGTC", 10);
        System.out.println();
        String str = "geeksforgeeks";
        System.out.println(longestRepeatedSubstring(str));
    }
}
