package patterns.twoPointers;

import java.util.Arrays;

/***
 *
 * Problem Statement
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 *  Assume that there are two element that add up to the given number
 *
 *  Goal : find a solution that takes 0(n) time and constant space.
 *
 *  Example 1:
 *     Input: [1, 2, 4, 3, 6], target=6
 *     Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 *   Example 2:
 *      Input: [2, 5, 9, 11], target=11
 *      Output: [0, 2]
 *     Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 *
 *
 * Approach 1 : Using two loops and check if there are two pairs that sum up to target
 *              Running Time : 0(n)
 *              Space : 0(1)
 * Approach 2 : Using Hashmap to keep track of visited elements of the array and
 *              and for each element try to find if there is a number in the hashmap that adds up with
 *              the current number and results the target
 *              Running time : 0(n)
 *              Space : 0(n)
 * Approach 3 : Two pointers , and exploit the fact that the array is sorted
 *
 *
 */

public class TwoSumOrderedArray {

    public static int[] findPair(int[] nums , int targetSum){

        int left = 0 ;
        int right = nums.length-1;

        while(left< right){

            int currentSum = nums[left] + nums[right] ;
            if(currentSum == targetSum) return new int[]{nums[left] , nums[right]};
            else if( currentSum < targetSum) left++;
            else right--;
        }
        return  new int[0];

    }

    public static void main(String[] args) {

        // Input: [1, 2, 3, 4, 6], target=6
        int[] testCase1 = new int[]{1, 2, 3, 4, 6};
        int targetSum = 6;
        System.out.println(Arrays.toString(findPair(testCase1, targetSum)));

        int[] testCase2 = new int[]{2, 5, 9, 11};
        int targetSum2 = 11;
        System.out.println(Arrays.toString(findPair(testCase2, targetSum2)));
    }
}
