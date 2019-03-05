import java.util.ArrayList;
import java.util.List;

public class ValidIP {

    public static List<String> getValidIPAddress(String s){
        List<String> res = new ArrayList<String>();
        for(int i=1;i<4&&i<s.length();i++){
            final String first = s.substring(0,i);
            if(isValid(first)){
                for(int j=1; i+j<s.length() && j<4; j++){
                    final String second = s.substring(i,i+j);
                    if(isValid(second)) {
                        for (int k = 1; i + j + k < s.length() && k < 4; k++) {
                            final String third = s.substring(i + j, i + j + k);
                            final String fourth = s.substring(i + j + k);
                            if(isValid(third) && isValid(fourth))
                                res.add(first + "." + second + "." + third + "." + fourth);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static boolean isValid(String s){
        if(s.length() > 3)
            return false;
        // Only "0" is valid, not "00", "001", etc
        if(s.startsWith("0") && s.length()>1)
            return false;
        int val = Integer.parseInt(s);
        return val<=255 && val>=0;
    }

    public static void main(String[] args){
        System.out.println(getValidIPAddress("19216811").toString());
    }
}
