package patterns.twoPointers;

import java.util.Arrays;

/**
 *  Given an integer array nums sorted in non-decreasing order,
 *  return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 *  Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 *
 * Source : https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Approach :  i). Brut-force : Squaring the array elements and sorting them
 *                         Running Time : 0(nlogn)
 *                         Space Complexity : 0(1)
 *             ii). Two-pointers :
 *
 */

public class SquaresOfSortedArray {

    public  static int[] sortedSquares(int[] nums) {

        int j = nums.length -1 ;
        int i = 0;

        int index = nums.length -1;
        int[] res = new int[nums.length];

        while( i <= j){

            int leftSquare = nums[i] * nums[i];
            int rightSquare = nums[j] * nums[j];

            if(Math.abs(nums[i]) <= Math.abs(nums[j]))
                j--;
            else
                i++;
            res[index--] = Math.max(leftSquare, rightSquare);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] testCase1 = new int[]{-5, -3, -2, -1, 10 , 20};
        System.out.println(Arrays.toString(sortedSquares(testCase1)));

        int[] testCase2 = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(testCase2)));

        int[] testCase3 = new int[]{-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(testCase3)));

        int[] testCase4 = new int[]{-4,-3,-2,-1};
        System.out.println(Arrays.toString(sortedSquares(testCase4)));

        int[] testCase45 = new int[]{-10000,-9999,-7,-5,0,0,10000};
        System.out.println(Arrays.toString(sortedSquares(testCase45)));

        int[] testCase5   = new int[]{-3,-3,-2,1};
        System.out.println(Arrays.toString(sortedSquares(testCase5)));

    }
}
