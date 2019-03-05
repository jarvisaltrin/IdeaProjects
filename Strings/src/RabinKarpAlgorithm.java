public class RabinKarpAlgorithm {


    // For a good hash function, the time complexity is O(m+n), independent of the
    // inputs s and t, where m is length of s and n is length of t
    public static int rabinKarp(String t, String s){
        if(s.length() > t.length())
            return -1;

        final int BASE = 26;
        int tHash = 0, sHash = 0; // hashcode for substring of t and s
        int powerS = 1; // BASE^|s|
        for(int i=0; i<s.length(); i++){
            powerS = i>0 ? powerS*BASE : 1;
            tHash = tHash * BASE + t.charAt(i);
            sHash = sHash * BASE + s.charAt(i);
        }

        for(int i=s.length(); i<t.length(); i++){
            // check if two substrings are equal or not, to protect against hash collision
            if(tHash == sHash && t.substring(i-s.length(),i).equals(s)){
                return i-s.length(); // found a match
            }

            // uses rolling hash to compute the new hash code
            tHash -= t.charAt(i-s.length()) * powerS;
            tHash = tHash * BASE + t.charAt(i);

            // Tries to match s and t.substring(t.length() - s.length())
            if(tHash == sHash && t.substring(t.length() - s.length()).equals(s))
                return t.length()-s.length();
        }
        return -1; // no match found
    }

    public static void main(String[] args){

        System.out.println(rabinKarp("GACGCCA","CGC"));
    }
}
