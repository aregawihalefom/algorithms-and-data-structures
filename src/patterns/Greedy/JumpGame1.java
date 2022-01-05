package patterns.Greedy;

/**
 *  Given an array of non-negative integers,
 *  you are initially positioned at the first index of the array.
 *  Each element in the array represents your maximum jump length at that position.
 *
 * Approach 1 : Working from the back and checking
 *              Running Time : 0(n)
 *              Space Complexity:
 *
 *
 */
public class JumpGame1 {

    public static boolean canJump(int[] arr){

        int lastGoodIndex = arr.length-1;

        for(int i = arr.length -2 ; i >= 0; i--){
            if(i + arr[i] >= lastGoodIndex ){
                lastGoodIndex--;
            }
        }
        return lastGoodIndex == 0;
    }

    public static void main(String[] args) {

        // Test Case 2
        int[] test1 = new int[]{3, 2, 1, 1, 4};
        System.out.println(canJump(test1));


        int[] test2 = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(test2));

    }


}
