package patterns.cyclicSort;


import java.util.Arrays;

/***
 *
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Options : Hashmap  - takes o(n) space
 *           Math - Using summation formula
 *           BitManipulation
 *           Cyclic sort
 *
 * Cyclic sort : After sorting each number should be at their given index. That is each number should be placed at
 *              the index of an array given by the actual number itself. except the last element ( n - not included because
 *              of array is only from 0 - n -1
 *
 *             TC : 0(n)
 *             SC : 0(1)
 *
 */

public class MissingNumber {

    public int findMissingNumber(int[] nums){

        // Sort the elements using cyclic sort
        int i = 0;
        while(i < nums.length){
            int correctPos = nums[i];
            if(correctPos != i && correctPos!=nums.length){
                // Swap required
                swap(nums, correctPos , i);
            } else i++;
        }

        System.out.println(Arrays.toString(nums));
        for(int j = 0 ; j < nums.length ; j++)
            if( j != nums[j]) return j;

        return nums.length; // that means the only element left is the last element
    }

    private void swap(int[] nums, int correctPos, int i) {
        int temp = nums[correctPos];
        nums[correctPos] = nums[i];
        nums[i] = temp;
    }


    public int mathsMethod(int[] nums){

        // sum of elements from 0-n;
        int n = nums.length;
        int sum = 0;
        int sumUpToN = n*(n+1)/2;

        for(int i = 0 ; i<n;i++){
            sum +=nums[i];
        }

        return sumUpToN- sum;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber  = new MissingNumber();
        int[] testCase1 = new int[]{4, 0, 2, 1};
        System.out.println(missingNumber.findMissingNumber(testCase1));;
    }
}
