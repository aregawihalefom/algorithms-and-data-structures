package patterns.cyclicSort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * <p>
 * Tips : Range  - which leads to  cyclic sort
 */

public class FindAllMissing {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i]-1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, correctIndex, i);
            }else{
                i++;
            }
        }
        // go through all the array and add the elements
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) result.add(j+1);
        }

        return result;
    }

    private void swap(int[] nums, int correctPos, int i) {
        int temp = nums[correctPos];
        nums[correctPos] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        FindAllMissing findAllMissing  = new FindAllMissing();
        int[] testCase1 = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findAllMissing.findDisappearedNumbers(testCase1));;
    }
}
