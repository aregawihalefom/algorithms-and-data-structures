package patterns.cyclicSort;


import java.util.Arrays;

/***
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 * Approaches : 1. Nested loop - iterate through numbers [1 , N] and check if each anyone of them is missing
 *              2. Use Hashmap - to improve the accessing process to linear.
 *              3. Sort the elements and check
 *              4. Cyclic sort - 0(1) space and 0(n) Time
 *
 */


public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int i = 0 ;
        while(i < nums.length){
            int correctPos = nums[i] - 1;

            // skip greater elements and negative elements
            if( (correctPos >= 0 && correctPos < nums.length) && nums[correctPos] != nums[i]){
                swap(nums, correctPos , i);
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        // Now check the sorted array starting from the positive onwards
        int nextPositive = 1;
        for (int index = 0; index < nums.length; index++) {

            if(nextPositive!= nums[index]) return nextPositive;
            else nextPositive++;
        }
        return nextPositive;
    }

    private void swap(int[] nums, int correctPos, int i) {
         int temp = nums[correctPos];
         nums[correctPos] = nums[i];
         nums[i] = temp;
    }

    public static void main(String[] args) {

        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] testCase1  = new int[]{1,2,0};
        System.out.println(firstMissingPositive.firstMissingPositive(testCase1));

        int[] testCase2  = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive.firstMissingPositive(testCase2));

        int[] testCase3  = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive.firstMissingPositive(testCase3));
    }
}
