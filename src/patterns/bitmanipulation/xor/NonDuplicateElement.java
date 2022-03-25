package patterns.bitmanipulation.xor;

/***
 *
 * every element appears twice except one element. Try to come up with a process to solve this.
 * Pick the single element in the array
 *
 * a ^ 0 = a
 * a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b;
 *
 */

public class NonDuplicateElement {

    private static int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 9, 1, 4, 2};
        System.out.println("Element appearing one time is " + singleNumber(nums));
    }
}
/***
 *
 * Complexity analysis#
 * Time complexity: O(n)
 *
 * n is the number of elements in the array, since we need to iterate over all the elements to find a single number.
 * So, the best and the worst-case time is O(n)O(n).
 *
 * Space complexity: O(1)
 *
 * The space complexity is O(1)O(1). No extra space is allocated
 *
 *
 */