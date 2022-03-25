package patterns.cyclicSort;

/***
 *
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 * Possible Approaches :  1. Nested for loop
 *                        2. Hashmap
 *                        3. Maths
 *                        4. Bit- Manipulation
 *                        6. Cyclic sort
 *                        7, Radix sort
 *
 * Best way  : Cyclic sort
 *
 *              - Sort the array and look for duplicated afterwards
 */


public class FindDuplicateNumber {


    public int findDuplicate(int[] nums) {

        // 1. Sort them
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i]-1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, correctIndex, i);
            }else{
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if(index +1 != nums[index]) return nums[index];
        }
        return -1;
    }


    private void swap(int[] nums, int correctPos, int i) {
        int temp = nums[correctPos];
        nums[correctPos] = nums[i];
        nums[i] = temp;
    }

    public int radixSort(int[] nums) {

        int[] res = new int[nums.length];

        for(int a : nums){
            res[a]++;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(res[i]>1) return i;
        }

        return -1;
    }
}
