public class Parity {

    public static short parity(long x){
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }

    public static void main(String[] args) {
        // 1st XOR yields 11011010 - last 4 bits relevant
        // 2nd XOR yields 11101100 - last 2 bits relevant
        // 3rd XOR yields 10011010 - last 1 bit relevant
        // To extract it we bitwise-AND with 0000001
        System.out.println(parity(11010111));
    }

}
