package patterns.binarysearch;

/**
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 *
 * @since Nov 21 , 2021
 *
 */
public class SingleNonRepeating {

    public int singleNonDuplicate(int[] nums) {

        int lower = 0;
        int higher = nums.length-1;

        while(lower < higher){

            int mid = (higher + lower)/2;

            if(nums[mid-1]!= nums[mid] && nums[mid]!= nums[mid+1]){
                return nums[mid];
            }else{
                if(nums[mid-1] == nums[mid]){
                     int leftLen = mid - lower -1;
                     if(leftLen %2 !=0){
                         higher = mid-2;
                     }else{
                         lower = mid +1;
                     }
                }
                else{

                    // duplicate is to the right
                    int rightLen =  higher - mid - 1;
                    if(rightLen % 2 !=0)
                        lower = mid + 2;
                    else
                        higher = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        SingleNonRepeating snr = new SingleNonRepeating();

        int[] testCase1 = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(snr.singleNonDuplicate(testCase1));
//        int[] testCase2 = new int[]{}
//        int[] testCase3 = new int[]{}
//        int[] testCase14 = new int[]{}

    }
}
