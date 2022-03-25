package patterns.cyclicSort;

import java.util.Arrays;

/**
 *
 *
 * You have a set of integers s, which originally contains all the numbers from 1 to n.
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 * You are given an integer array nums representing the data status of this set after the error.

 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 *
 * https://leetcode.com/problems/set-mismatch/
 *
 * Approaches :  - 1. nested for loop
 *               - 2. Hashmap
 *               - 3. radix sort
 *               - 4. Bit-manipulation
 *               - 5. Cyclic sort - Best
 *
 *
 * Cyclic sort steps :
 *                      1. sort the array
 *                      2. go through the sorted array and find the missing and duplicate
 *
 *
 */

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {

        int i = 0;
        while(i < nums.length){
            
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]) swap(nums, correct, i);
            else i++;
        }

        // now look for the missing and repeated elements
        for (int ind = 0; ind < nums.length; ind++) {
            if(nums[ind] != ind+1) return new int[]{nums[ind], ind +1 };
        }
        return  new int[]{};
    }

    private void swap(int[] nums, int correctPos, int i) {
        int temp = nums[correctPos];
        nums[correctPos] = nums[i];
        nums[i] = temp;
    }


    public int[] radixSort(int[] nums) {

        int[] count = new int[nums.length+1];

        for(int a : nums){
            count[a]++;
        }

        int[] ans = new int[2];
        for(int i = 0 ; i < count.length ; i++){
            if(count[i] == 2) ans[0] = i;
            else if(count[i] == 0) ans[1]=i;
        }

        return  ans;
    }

    public static void main(String[] args) {

        SetMismatch mismatch  = new SetMismatch();
        System.out.println(Arrays.toString(mismatch.findErrorNums(new int[]{1, 2, 2, 4})));;
        System.out.println(Arrays.toString(mismatch.findErrorNums(new int[]{1,1})));;
    }
}
