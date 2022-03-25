package epi.arrays;


import java.util.Arrays;

/***
 *
 * Given an array A[] consisting 0s, 1s and 2s( or array created from three possible values).
 * The task is to write a function that sorts the given array.
 * The functions should put all 0s first, then all 1s and all 2s in last
 *
 * Variants: it can be three colors , white , red , green or any three possible values
 * Constraints: Linear Time - O(n) , Constant Space O(1)
 *
 */
public class DutchNationalFlag {

    public int[] reArrange(int[] arr){

        // 1. Method 1 - Using sorting
        // Running Time - O(nlogn)
        // Space complexity - O(1)
       // QuickSorting(arr);

        // 2. Method 2 - Using Two for loop each time pushing towards the extreme parts of the ara
        pushTheTwoExtremeValuesToRespectivePosition(arr);


        return arr;
    }

    private void pushTheTwoExtremeValuesToRespectivePosition(int[] arr) {

       int current = 0;
       int end = arr.length-1;

       // Bring all zeros towards the beginning
       for(int i = 0 ; i < arr.length ; i++){
           if(arr[current] == 0)
               current++;
           else
               swap(current, end--, arr);
       }

       end = arr.length-1;
       for(int i = end ; i >=current ; i--){
            if(arr[end] == 2)
                end--;
            else
                swap(i, end, arr);
        }
    }

    public void QuickSorting(int[] arr){

    }

    public void swap(int i , int j, int[] arr){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {

        DutchNationalFlag dutchNationalFlag  = new DutchNationalFlag();

        // Test Cases
        int[] testCase1 = new int[]{1, 1, 0, 0, 0 , 2, 2};
        System.out.println(Arrays.toString(dutchNationalFlag.reArrange(testCase1)));

    }
}
