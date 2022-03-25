package patterns.cyclicSort;

import java.util.Arrays;

/**
 *  Given an array of numbers in the range of 1 to n , where n is a positive integer
 *
 *  The cycle sort algorithm is an in-place sorting algorithm.
 *  This means that no external data structure (such as a list or heap) is required to perform the cycle sort operation.
 * The underlying assumption for the cycle sort algorithm is that an unsorted list is similar to a graph, where nodes are connected with edges.
 * We can assume that a relationship between nodes A and B exists if-- in order to sort the array--
 * the element present at node A should be at the index of node B when rotated.
 *
 * This is the big idea: Given an element a, we can find the index at which it will occur in the sorted list by simply counting the number of elements in the entire list that are smaller than a.
 *
 */

public class CyclicSort {

    public int[] sort(int[] nums){

        int i = 0 ;

        while(i < nums.length){

            int correctPos = nums[i] - 1;

            if(correctPos == i) i++;
            else{
                swap(nums, i);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i) {
        int temp = nums[nums[i]-1];
        nums[nums[i]-1] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {

        CyclicSort cyclicSort = new CyclicSort();
        int[] testCase1  = new int[]{3, 5, 2, 1, 4};
        System.out.println(Arrays.toString(cyclicSort.sort(testCase1)));

    }

}
