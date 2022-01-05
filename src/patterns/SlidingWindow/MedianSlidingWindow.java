package patterns.SlidingWindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/***
 *
 *  Description : Given an array of integer arr[] and an integer k,
 *                the task is to find the median of each window of size k starting from the left
 *                and moving towards the right by one position each time.
 *
 *   Example 1: Input: arr[] = {-1, 5, 13, 8, 2, 3, 3, 1}, k = 3
 *             Output: 5 8 8 3 3 3
 *
 *
 *  Example 2: [1,3,-1,-3,5,3,6,7], k= 3.
 *             Window position                Median
 *             ---------------               -----
 *             [1  3  -1] -3  5  3  6  7       1
 *             1 [3  -1  -3] 5  3  6  7       -1
 *             1  3 [-1  -3  5] 3  6  7       -1
 *             1  3  -1 [-3  5  3] 6  7       3
 *             1  3  -1  -3 [5  3  6] 7       5
 *             1  3  -1  -3  5 [3  6  7]      6
 *
 *
 *  Approaches :
 *
 *              i). Brute-force : Consider a window of size k at a time and calculating the median in each window
 *
 *              ii). Using Two - Queues to Get median using queue balancing approach.
 *                   Running time : 0(nlogk)
 *                   Space complexity : 0(k)
 *
 *
 */

public class MedianSlidingWindow {


    public static int[] medianSlidingWindowBruteForce(int[] nums, int k){

        int n = nums.length;
        int[] res = new int[n - k +1];  // Size of the array derived from above

        // We will keep sorting the array window sorted and pick the middle element
        int[] sortedWindow = new int[k];
        for(int i = 0 ; i < k ; i++)
            sortedWindow[i] = nums[i];

        Arrays.sort(sortedWindow);
        System.out.println(Arrays.toString(sortedWindow));
        for(int i = k ; i <= n ; i++){

            // calculate the current median in the given window
            System.out.println("to be implemented");

        }

        return nums;
    }

    /***
     *
     *
     * However instead of using two priority queue's we use two Tree Sets as we want O(logk) for remove(element).
     * Priority Queue would have been O(k) for remove(element) giving us an overall time complexity of O(nk) instead of O(nlogk).
     * However there is an issue when it comes to duplicate values so to get around this we store the index into nums in our Tree Set. To break ties in our Tree Set comparator we compare the index.
     *
     *  Source : https://leetcode.com/problems/sliding-window-median/discuss/96346/Java-using-two-Tree-Sets-O(n-logk)
     *
     * Algorithm Steps :
     *                  1. Create Two priority queues => TreeSet implementation used for the very reason stated above
     *                  2. Create MinHeap and MaxHeap with their respective comparators
     *
     *                  3. Add an element to minHeap and move the first element of minHeap to maxHeap
     *                  4. If there is imbalance between the ( maxHeap have one more element) , copy back the top of maxHeap
     *                  5. for every window pick the mean as
     *                          i).  k is even - take first element of queue
     *                          ii). k is odd - take average 1st of minheap and 1st of maxheap
     *
     *
     *
     */
    private  TreeSet<Integer> minHeap , maxHeap;

    public  double[] medianSlidingWindow(int[] nums, int k){

        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a-b;
        minHeap = new TreeSet<>(comparator);
        maxHeap = new TreeSet<>(comparator.reversed());

        // result variable
        int ans = 0;
        double[] result = new double[nums.length - k + 1];

        for(int i = 0 ; i < nums.length ; i++){

            if(i >= k){
                minHeap.remove(i-k);
                maxHeap.remove(i-k);
            }

            minHeap.add(i);
            maxHeap.add(minHeap.pollFirst());

            // Balance Heaps
            balanceHeap();

            // Get Median
            if(i >= k-1) result[ans++] = getMedian(nums, k);

        }
        return result;
    }

    private double getMedian(int[] nums, int k) {

        if(k % 2 == 0 ) return ((double) nums[minHeap.first()] + nums[maxHeap.first()])/2;
        return (double) nums[minHeap.first()];
    }

    private void balanceHeap() {
        if(maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.pollFirst());
    }

    public static void main(String[] args) {

        MedianSlidingWindow obj = new MedianSlidingWindow();
        int[] testCase1 = new int[]{1,3,-1,-3,5,3,6,7};
        int[] testCase2 = new int[]{1,2,3,4,2,3,1,4,2};
        int k = 3;
        System.out.println(Arrays.toString(obj.medianSlidingWindow(testCase1, k)));
        System.out.println(Arrays.toString(obj.medianSlidingWindow(testCase2, k)));


    }

}
