public class SwapBits {

    // Time Complexity - O(1)
    public static long swapBits(long x, int i, int j){
        // Extract the i-th and j-th element to see if they are different
        if(((x >>> i) & 1) != ((x >>> j) & 1)){
            // They differ, hence need to be swapped
            // Select the bits to swap with bitMask. Since x^1 = 0 when x=1 and 1 when x=0
            // we can perform the flip XOR
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }
    public static void main(String[] args) {
        // 73 - 01001001 changes to 11 - 00001011 in binary
        System.out.println(swapBits(73, 1, 6));
    }

}
