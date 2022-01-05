package patterns.twoPointers;

import java.util.Arrays;

public class ReversingAnArray {

    public static  int[] reverseArray(int [] nums){

        int n = nums.length;
        for(int i = 0 ; i < n/2; i++){
            int last = nums.length-i-1;
            int temp = nums[i];
            nums[i] = nums[last] * nums[last];
            nums[last] = temp * temp;
        }
        return nums;
    }

    public static void main(String[] args){

        int[] testCase1 = new int[]{-5, -3, -2, -1};
        System.out.println(Arrays.toString(reverseArray(testCase1)));
    }
}
