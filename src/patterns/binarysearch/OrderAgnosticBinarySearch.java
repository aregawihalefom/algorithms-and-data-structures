package patterns.binarysearch;

/**
 *
 * '''
 * Problem Statement
 *          Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
 *          Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 *          You should assume that the array can have duplicates.
 *          Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 * Example 1:
 *      Input: [4, 6, 10], key = 10
 *      Output: 2
 * Example 2:
 *      Input: [1, 2, 3, 4, 5, 6, 7], key = 5
 *      Output: 4
 * Example 3:
 *      Input: [10, 6, 4], key = 10
 *      Output: 0
 * Example 4:
 *     Input: [10, 6, 4], key = 4
 *     Output: 2
 *
 */
public class OrderAgnosticBinarySearch {

    public int searchKey(int[] nums , int key){

        int start = 0 ;
        int end =nums.length-1;

        if(nums[start] < nums[end])
            return ascending(nums, start, end,  key);
        else
            return descending(nums, start , end , key);
    }

    private int ascending(int[] nums , int start, int end, int key){

        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == key)
                return mid;
            else if(nums[mid] < key)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
    private int descending(int[] nums,  int start, int end, int key){

        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == key)
                return mid;
            else if(nums[mid] < key)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }


    /*** Official solution
     *
     * @param nums - sorted array of number
     * @param key - a number to be looked in the array
     * @return - index of the key in the array
     *
     * Running Time : O(logn)
     * Space Complexity : O(1)
     */

    public int  binarySearchOptimized(int[] nums, int key){
        int start = 0 ;
        int end =nums.length-1;

        boolean isAscending = nums[start] < nums[end];


        while(start <= end){

            int mid = (start + end)/2;
            if(nums[mid] == key)
                return mid;

            if(isAscending){

                if(nums[mid] < key)  start = mid+1;
                else  end = mid-1;

            }
            else{
                if(nums[mid] < key) end = mid-1;
                else  start = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        // Sample test cases
        OrderAgnosticBinarySearch obj = new OrderAgnosticBinarySearch();
        int[] test1 = new int[]{4, 6, 10};
        int key1 = 10;
        System.out.println(obj.searchKey(test1, key1));
        System.out.println(obj.binarySearchOptimized(test1, key1));
    }
}
