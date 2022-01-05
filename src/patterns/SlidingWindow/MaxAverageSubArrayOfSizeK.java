package patterns.SlidingWindow;

/***
 *
 *  Question Description : Given an array consisting of n integers, find the contiguous subarray of given length k
 *                         that has the maximum average value.
 *                         And you need to output the maximum average value.
 *
 * Clues in the question : - Asking for sub array ( potential for sliding window technique)
 *                         - Maximum average constraint  ( Needs to keep track of global max average)
 *                         - Sub array of size K
 *
 * Approach :
 *             i) .Brute force : Every K elements calculate the max average and divide it by k
 *                           - Keep track of the running average and update the global maximum average
 *                            Running Time : 0(nk) , where k is the size of the window and n is the number of elements in the input array
 *                            Space Complexity : 0(1) - Only constant extra space is required to maintain the intermediate results.
 *
 *             ii).  Sliding window : consider a window of size K at a time and preserve the maximum average.
 *                                     Running Time : 0(n)
 *                                     Space complexity : 0(1)
 *
 */
public class MaxAverageSubArrayOfSizeK {


    /***
     *
     *
     * @param arr
     * @param k
     * @return
     *
     * Running time :0(n)
     * Space Complexity : 0(1)
     */

    public static double findMaxAverageSubArray(int[] arr , int k){
        // [ 1, 2, 3, 4, 5 ,6] , k = 3

        int maxSum = Integer.MIN_VALUE;
        int current_sum = 0;

        for(int i = 0 ; i < arr.length ; i++){
            current_sum += arr[i];
            if(i >= k -1){

                maxSum = Math.max(maxSum, current_sum);

                // for the next step we need to play with the window
                current_sum -= arr[i - (k-1)];
            }
        }
        return maxSum/ ( 1.0 * k);
    }

    public static void main(String[] args) {
        int[] testCase1 = new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int k = 3;
        System.out.printf("Max Average = %.6f", findMaxAverageSubArray(testCase1, k));
    }
}
