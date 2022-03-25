package patterns.bitmanipulation;


/***
 * Checks if the given input integer is a power of 2
 *
 *
 * Solution : The algorithm used to solve this problem is Brain Kernighan's Set-bit
 *
 * All power of two elements numbers 1 set-bit
 *
 *
 * Complexity analysis
 *
 * Time complexity: O(1)
 *
 * The run time depends on the number of 1-bits in n. In the worst case, all bits in n are 1-bits. In the case of a 32-bit integer, the run time is O(1)O(1).
 *
 * Space complexity: O(1)
 *
 * The space complexity is O(1)O(1). No additional space is allocated.
 */
public class IsPower2 {

    public static  boolean isPowerOf2(int n){
        return (n & (n-1)) == 0;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOf2(6));
        System.out.println(isPowerOf2(8));
    }

}
