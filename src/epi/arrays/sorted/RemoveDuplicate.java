package epi.arrays.sorted;

import java.util.Arrays;

/***
 *
 * This problem is concerned with deleting repeated elements from a sorted array.
 * For example, for the array (2,3,5,5,7,11,11,11,13), then after deletion, the array is
 * (2,3,5,7,11,13,0,0,0). After deleting repeated elements, there are 6 valid entries.
 * There are no requirements as to the values stored beyond the last valid element.
 * Write a program which takes as input a sorted array and updates it so that all dupli¬
 * cates have been removed and the remaining elements have been shifted left to fill the
 * emptied indices. Return the number of valid elements. Many languages have library
 * functions for performing this operation—you cannot use these functions.
 *
 *
 * Hint: There is an0(n) time and 0(1) space solution.
 *
 * @Copy : Elements of Programming interviews in Java(2019) : Problem 6.5
 *
 *

 * Approaches :
 *
 *   i) Brute-Force : Using Nested for loops to check if the is a duplicate of the current element
 *                 Running Time : 0(n^2)
 *                 Space Complexity : 0(n)
 *
 *   ii) Using HashMap -> We put a single entry of each value into the hashmap and check
 *                  - Running Time : O(n)
 *                  - Space Complexity : 0(n)
 *   iii) Best Approach : Exploit the fact that , the array is sorted by comparing neighbouring arry elements for
 *                        duplicate check
 *                        - Running time : 0(n)
 *                        - Space Complexity : 0(1)
 *
 */
public class RemoveDuplicate {

    /**
     *  This is Best approach
     * @param arr
     * @return - > array with duplicates removed
     */
    public static int[] removeDuplicate(int[] arr ){

        if(arr.length <=1) return arr;
        int index = 0 ;

        for(int i = 1 ; i < arr.length ; i++){
            if(arr[index] != arr[i]){
                arr[++index] = arr[i];
            }
        }
        /// If there question asks to get the number of valid , we return index + 1
        return arr;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1,1,2};
        System.out.println(Arrays.toString(removeDuplicate(test1)));
    }
}
