package patterns.Greedy;

public class JumpII {

    public static int jump(int[] arr){

        int jumps  = 0 ;
        int currEnd = 0 ;
        int currFarthest = 0 ;
        for(int i = 0 ; i< arr.length-1; i++){

            // Get the farthest we can go in the given range
            currFarthest = Math.max(currFarthest, i + arr[i]);

            // if the current block is done count start
            if(i == currEnd){
                jumps++;
                currEnd = currFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {

        // Test Case 2
        int[] test1 = new int[]{3, 2, 1, 1, 4};
        System.out.println(jump(test1));

    }
}
