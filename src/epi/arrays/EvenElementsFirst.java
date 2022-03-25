package epi.arrays;


import java.util.Arrays;

/***
 *
 * Given an array of elements  re-order the array of elements so that
 * the even elements' comes first
 *
 * IDEA : TWO-POINTERS
 *
 *          -> Everytime you get even skip that otherwise , swap it with the end
 *
 * Running Time : 0(n)
 * Space complexity : 0(1)
 *
 */
public class EvenElementsFirst {

    public  static int[] evenElementsFirst(int[] arr){

        int start = 0;
        int end = arr.length-1;
        int current = 0;

        while(start < end){

            if(arr[start] %2 == 0)
                start++;
            else{
                // swap him with the last element
                swap(arr, start, end--);
            }
        }

        return arr;

    }
    public static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] testCase1 = new int[]{1, 3, 2, 4, 5, 2, 7, 8};
        System.out.println(Arrays.toString(evenElementsFirst(testCase1)));
    }

}
