import java.util.ArrayList;
import java.util.List;

public class PhoneMnemonics {

    public static final String[] MAPPING = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

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
