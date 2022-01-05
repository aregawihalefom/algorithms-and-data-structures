package patterns.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];

        int l = 0, r = 0; // left and right array
        int ans = 0;
        while (r < nums.length) {

            // if there are elements less than the current value to be inserted into the queue
            // remove them , becasue they are not to going to be max anyways
            while (!queue.isEmpty() && nums[r] > nums[queue.peekLast()]) queue.pollLast();

            // Now add the element ( i.e index of the array in this case)
            queue.offer(r);

            // If an element in the left most of the window(Queue) doesn't belong to the window
            // remove it from the queue should be always same as the window
            if (!queue.isEmpty() && (queue.peekFirst() < l)) queue.pollFirst();


            // Now get the last element in the deque as a max if there window size has grown enough
            if (r + 1 >= k) {
                result[ans++] = nums[queue.peekFirst()];
                l++;
            }
            r++;
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSlidingWindow obj = new MaximumSlidingWindow();
        int[] testCase1 = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(obj.maxSlidingWindow(testCase1, k)));
    }

}
