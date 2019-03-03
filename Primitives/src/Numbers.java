public class Numbers {

    // Reverse a number (Time Complexity - O(n), n is the number of digits in x)
    public static long reverse(int x){
        long res = 0;
        long copy = Math.abs(x);
        while (copy != 0){
            res = res*10 + copy%10;
            copy/=10;
        }
        return x < 0 ? -res : res;
    }

    // Check if a number is Palindrome (Time - O(n), Space - O(1))
    public static boolean isPalindrome(int x){
        if(x<0)
            return false;
        // The LSD is x mod 10
        // The MSD is x/10^(n-1), n is the number of digits
        final int numDigits = (int)(Math.floor(Math.log10(x))) + 1;
        int msdMask = (int)Math.pow(10, numDigits-1);
        for(int i=0; i<(numDigits/2); ++i){
            if(x/msdMask != x%10)
                return false;
            x %= msdMask; // Remove the MSD of x
            x /= 10; // Remove the LSD of x
            msdMask /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        // 73 - 01001001 changes to 11 - 00001011 in binary
        System.out.println(reverse(73568));
        System.out.println(isPalindrome(73537));
    }

}
