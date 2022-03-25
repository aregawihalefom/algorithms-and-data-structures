package patterns.bitmanipulation.xor;


/**
 *
 * In this question, every element appears an even number of times except for one element,
 * which appears an odd number of times. The element that appears an odd number of times is our answer.
 *
 *
 * a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b;
 *
 * Input: {4, 3, 3, 4, 4, 4, 5, 3, 5}
 *
 * Output: 3
 *
 */

public class OddOccurring {

    public static int findOddOccurring(int[] arr){

        int res = 0;

        for(int val : arr){
            res ^= val;
        }

        return res;
    }

    public static void main(String[] args) {
        int result = findOddOccurring(new int[]{4, 3, 3, 4, 4, 4, 5, 3, 5});
        System.out.println("Odd occurring element is " + result);
    }
}
