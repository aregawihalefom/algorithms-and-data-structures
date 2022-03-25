package patterns.binarysearch;

/***
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 */
public class SearchInsertionPosition {

    public int searchInsert(int[] nums, int target) {

        int lower = 0;
        int higher = nums.length-1;
        while(lower < higher){
            int mid = (lower + higher)/2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid]){
                higher = mid-1;
            }else{
                lower = mid+1;
            }
        }
        return lower;
    }

    public static void main(String[] args) {
        SearchInsertionPosition searchInsertionPosition = new SearchInsertionPosition();

        int target1 = 5;
        int[] testCase1 = new int[]{1,3,5,6};
        int indexOfFive =  searchInsertionPosition.searchInsert(testCase1, target1);
        int indexOfTwo =  searchInsertionPosition.searchInsert(testCase1, 2);

        System.out.println(indexOfFive);
        System.out.println(indexOfTwo);
    }
}
