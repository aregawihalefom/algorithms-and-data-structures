package patterns.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 */

public class MergingInterval {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (arr1 , arr2) -> Integer.compare(arr1[0] , arr2[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for(int[] interval : intervals){

            if(result.isEmpty() || result.getLast()[0] < interval[0]) {
                result.add(interval);
            }else {
                // set the end to the max of the largest
                result.getLast()[1] = Math.max(result.getLast()[1] , interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("~~~~~ Testing areas ~~~~~~");
        int[][] testCase1 = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        MergingInterval mergingInterval = new MergingInterval();
        System.out.println(Arrays.deepToString(mergingInterval.merge(testCase1)));

;    }

}
