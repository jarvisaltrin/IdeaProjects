import java.util.HashSet;
import java.util.Set;

public class DistinctSubstring {

    public static int distinctSubstring(String str)
    {
        // Put all distinct substring in a HashSet
        Set<String> result = new HashSet<String>();

        // List All Substrings
        for (int i = 0; i <= str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {

                // Add each substring in Set
                result.add(str.substring(i, j));
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
        // Return size of the HashSet
        return result.size();
    }

    public static void main(String[] args)
    {
        String str = "abcd";
        System.out.println("Distinct substring count: " + distinctSubstring(str));
    }
}
