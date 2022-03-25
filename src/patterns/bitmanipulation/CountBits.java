package patterns.bitmanipulation;

/**
 *
 * Given an integer, return the number of bits present in an integer input.
 *
 * Example :
 *          Input:  n = 125
 *          Output: 7 (1, 1, 1, 1, 1, 0, 1)
 */
public class CountBits {

    private static int countBitsUsingBitShifting(int n){

        int count = 0;
        while(n > 0){
            count++;
            n >>=1;
        }
        return count;
    }

    public int countBitsUsingStack(){

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countBitsUsingBitShifting(125));
    }
}
