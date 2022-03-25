package patterns.bitmanipulation.xor;

/***
 *
 *
 *
 */
public class MissingNumber {

    public static int missingNumber(int[] nums){
        // Write - Your - Code- Here
        int n = nums.length +1;
        int res = 0;

        for(int i = 0 ; i < n ; i ++){
            res ^=i;
        }

        for(int val : nums)
            res ^=val;


        return res; // change this, return missing element; if none, return -1
    }

    private static int helper(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

/***
 *
 *
 * Complexity analysis
 * Time complexity: O(n)
 *
 * We are using two independent for loops, so Time = O(n) + O(n) => O(n)
 *
 * n is the number of elements in the array, since we need to iterate over all the elements to find a missing number. So, the best and the worst-case time is O(n)O(n).
 *
 * Space complexity: O(1)
 *
 * The space complexity is O(1)O(1). No extra space is allocated.
 */