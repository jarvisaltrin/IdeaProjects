import java.util.ArrayList;
import java.util.List;

/*
Each digit, apart from 0 and 1, in a phone keypad corresponds to one of three or four
letters of the alphabet.

Write a program which takes as input a phone number, specified as a string of digits,
and returns all possible character sequences that correspond to the phone number.
The cell phone keypad is specified by a mapping that takes a digit and returns the
corresponding set of characters. The character sequences do not have to be legal
words or phrases.
 */

public class PhoneMnemonics {

    public static final String[] MAPPING = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

    // Time Complexity - O((4^n)*n)
    public static List<String> phoneMnemonics(String phoneNum){
        char[] partialMnemonics = new char[phoneNum.length()];
        List<String> mnemonics = new ArrayList<String>();
        phoneMnemonicsHelper(phoneNum, 0, partialMnemonics, mnemonics);
        return mnemonics;
    }

    public static void phoneMnemonicsHelper(String phoneNum, int digit, char[] partialMnemonics, List<String> mnemonics){
        if(digit == phoneNum.length()){
            // All digits are process, hence add partialMnemonics to mnemonics
            mnemonics.add(new String(partialMnemonics));
        }else{
            // Try all possible characters for this digit
            for(int i=0; i<MAPPING[phoneNum.charAt(digit) - '0'].length(); i++){
                char c = MAPPING[phoneNum.charAt(digit) - '0'].charAt(i);
                partialMnemonics[digit] = c;
                phoneMnemonicsHelper(phoneNum, digit+1, partialMnemonics, mnemonics);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(phoneMnemonics("2276696").toString());
        System.out.println(phoneMnemonics("222").toString());
    }

}
