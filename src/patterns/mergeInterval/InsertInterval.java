package patterns.mergeInterval;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 *
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 *
 *
 */


public class InsertInterval {


    public int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> result = new LinkedList<>();
        int[] add = newInterval;

        for(int []  interval : intervals){

            // 1. No overlap and newInterval before current interval simply add
            if(interval[0] > add[1]){
                result.add(newInterval);
                add = interval;
            }

            //2. There is overlap and adjust , no need to add that yet
            else if(interval[1] >= add[0])
                add = new int[]{Math.min(interval[0] , add[0]), Math.max(interval[1] , add[1])};

            // 3. No overlap , new interval appears after the current interval
            // add the current interval now
            else
                result.add(interval);
        }

        // add the last, works for edge case too
        result.add(add);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {


        int[][] testCase1 = new int[][]{{1, 5}};
        int[] newInterval = new int[]{2,7};

        InsertInterval insertInterval = new InsertInterval();
        System.out.println(Arrays.deepToString(insertInterval.insert(testCase1, newInterval)));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[][] testCase2 = new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval2 = new int[]{4,8};
        System.out.println(Arrays.deepToString(insertInterval.insert(testCase2, newInterval2)));
    }

}
