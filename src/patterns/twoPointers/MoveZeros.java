package patterns.twoPointers;

import java.util.Arrays;

/***
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {

        int nextNonZeroIndex = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                nums[nextNonZeroIndex] = nums[i];
                nums[i] =  i!= nextNonZeroIndex++ ? 0 : nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));;
    }

    public static void main(String[] args) {
           MoveZeros moveZeros = new MoveZeros();

        int[] testCase1  = new int[]{0,1,0,3,12};
        moveZeros.moveZeroes(testCase1);

        int[] testCase2  = new int[]{1,0, 3, 0, 3};
        moveZeros.moveZeroes(testCase2);
    }
}
