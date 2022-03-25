package patterns.slidingwindow;

/**
 *
 *  Find the max sum subarray of a fixed size K
 *
 *  Important clues : - find max sum (i.e optimization)
 *                    - subarray - asks for subset
 *                    - fixed size window - No need to keep track of two pointers
 *
 * Approach : Brute force - For each element , take their (k-1) next neighbours
 *                          and keep track of the running sum
 *                          and finally optimize the max sum
 *           Running Time : 0(n.K)
 *           Space complexity : 0(1)
 *
 *
 */
public class MaxSumSubArray {

    public static int findMaxSumSubArrayBruteForce(int[] arr, int k){

        int global_max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length - (k - 1) ; i++){
            int current_sum = 0 ;
             for(int j = i ; j <  i + k; j++){
                 current_sum += arr[j];
            }
             global_max = Math.max(current_sum, global_max);
        }

        return global_max;
    }

    public static int findMaxSumSubArray(int[] arr, int k){

        int max_sum = Integer.MIN_VALUE;
        int current_sum = 0 ;

        for(int i = 0 ; i < arr.length ; i++){

            // Now until K -> We have to grow our window
            current_sum += arr[i];

            // after we reach k element , we need to start to track our max value
            if(i >= k-1){

                max_sum = Math.max(max_sum, current_sum);

                // for the next round we need to remove the left most element
                // so that the next element after the end of the window is added
                // [4, 2, 2, 7, 8, 1, 2, 8, 1, 0]
                current_sum -= arr[i-(k-1)]; // remove the left most element

            }
        }

        return  max_sum;
    }

    public static void main(String[] args) {
        int[] testCase1 = new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        System.out.println(findMaxSumSubArray(testCase1, 3));
        System.out.println(findMaxSumSubArrayBruteForce(testCase1, 3));
    }

}
