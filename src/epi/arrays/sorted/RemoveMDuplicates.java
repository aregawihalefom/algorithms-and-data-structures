package epi.arrays.sorted;

import java.util.Arrays;

/**
 * Description : Write a program which takes as input a sorted array A of integers and a
 * positive integer m ,and updates A so that if x appears m times in A it appears exactly
 * min(2,m) times in A. The update to A should be performed in one pass, and no
 * additional storage may be allocated.
 * <p>
 * No
 */
public class RemoveMDuplicates {

    public static int[] updateDuplicate(int[] nums, int m) {

        if (nums.length == 0) return nums;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i + m -1] == nums[i]) {
                if(m < 2) {
                    nums[++index] = nums[i];
                }else{
                    nums[++index] = nums[i];
                    nums[++index] = nums[i];
                }
            }else {
                nums[++index] = nums[i];
            }
        }

        return nums;
}

    public static void fillValues(int[] arr, int start, int m, int val) {

        for (int i = start; i <= m; i++) {
            arr[++i] = val;
        }
    }

    public static void main(String[] args) {
            int[] test1 = new int[]{1, 2, 2, 3, 4, 4, 4};
            System.out.println(Arrays.toString(updateDuplicate(test1, 2)));
    }
}
