package AlgoExpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Algo expert :
 */

public class TripletSum {

    public  List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        Arrays.sort(array);

        List<Integer[]> triplets = new ArrayList<>();

        for(int i = 0 ; i < array.length; i++){

            int newTarget = targetSum - array[i];
           List<Integer[]> singleTriplet = twoSum(array, newTarget , i);
            if(singleTriplet.size() != 0) triplets.addAll(singleTriplet);

        }
        return new ArrayList<Integer[]>();
    }

    /***
     *
     * Given sorted array , find two numbers that sums up to a given target
     * @param nums
     * @param target
     * @return
     */
    private List<Integer[]> twoSum(int[] nums , int target , int currentIndex){

        int start = 0 ;
        int end = nums.length-1;

        List<Integer[]> triplet = new ArrayList<>();

        while(start < end ){
            if(start == currentIndex) start++;
            if(end == currentIndex) end--;

            // get the sum
            int sum = nums[start] + nums[end];
            if(sum == target ) {
                if(start >currentIndex && currentIndex < end)
                triplet.add(new Integer[]{nums[currentIndex], nums[start] , nums[end]});
            }
            if(sum > target) end--;
            else start++;
        }

        return triplet;
    }

    public static void main(String[] args) {

        TripletSum tripletSum = new TripletSum();
        int[] array = new int[]{12, 3, 1, 2, -6, 5, -8, 6}; int target1 = 0;

        tripletSum.threeNumberSum(array, target1);
    }
}
