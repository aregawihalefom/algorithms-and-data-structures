package patterns.slidingwindow;

import java.util.HashMap;

public class DuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0 ; i < nums.length ;i++){

            if(hm.containsKey(nums[i]) && Math.abs(hm.get(nums[i]) - i) <=k){
                return true;
            }
            hm.put(nums[i], i);
        }
        return false;
    }

    public static  boolean containsNearbyDuplicateTwo(int[] nums, int k) {

        if(nums.length <=0 || k == 0 ) return false;

        int j = 1 ;
        for(int i = 0 ; i < nums.length; i++){
            while(Math.abs(i-j) <= k && j < nums.length){
                if(nums[i] == nums[j]) return true;
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

       int[] testCase1 = new int[] {0,1,2,3,2,5};
       int k1 = 3;

        System.out.println(containsNearbyDuplicateTwo(testCase1, k1));
    }
}
