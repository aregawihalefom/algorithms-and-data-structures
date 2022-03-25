package patterns.bitmanipulation;


/***
 *
 * Time complexity: O(Set Bit count) / O(1) in simple terms
 *
 * The time taken is proportional to set bits in binary representation.
 *
 * So, time taken is O(SetBit Count).
 *
 * The run time depends on the number of set bits in n. In the worst case, all bits in n are 1-bits. In the case of a 32-bit integer, the run time is O(32)O(32) or O(1)O(1).
 *
 * Space complexity: O(1) extra space
 *
 * The space complexity is O(1)O(1). No additional space is allocated.
 *
 */
public class BrainKernighan {


    private static int helper(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 125;
        System.out.println("SetBit Count is : " + helper(number));
    }
}
