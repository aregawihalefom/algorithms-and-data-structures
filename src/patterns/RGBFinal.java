package patterns;

import java.util.Arrays;

public class RGBFinal {

    private static final char RED = 'R';
    private static final char BLUE = 'B';

    /**
     *  Swaps the two values of array at the two indices
     */
    public static char[] swap(char[] arr, int i , int j){

        char temp = arr[i] ;
        arr[i] =  arr[j];
        arr[j] = temp;

        return arr;
    }

    public static char[] segregate(char[] arr){

        // Two variables to track the sorted blue and red respectively
        int trackBlue = arr.length-1;
        int trackRed = 0 ;

        // iterates until the sorted 'Blues(B)' at the end
        for(int i = 0 ; i <=trackBlue ; i++){

            //This if is very important
            // see what is happening
            if(arr[i] == BLUE){

                // If you encounter blue , swap it to the end side and
                // don't increment i ,  so that
                //  swapped elements at i is checked as it may be blue
                arr = swap(arr, i--, trackBlue--);
                continue;
            }

            if(arr[i] == RED){

                // If it is read put it at the end of
                // red's so far
                arr =  swap(arr, i , trackRed++);
            }

        }
        return  arr;
    }

    public static void main(String[] args) {

        // Create Object
        RGBFinal rgbObj = new RGBFinal();

        // Test 1
        char[] rgbArray1 = new char[]{'G', 'B' , 'R'};
        System.out.println(Arrays.toString(rgbObj.segregate(rgbArray1)));

        // Test 2
        char[] rgbArray2 = new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        System.out.println(Arrays.toString(rgbObj.segregate(rgbArray2)));

        // Test 3:
        char[] rgbArray3 = new char[]{'R' ,'G', 'G'};
        System.out.println(Arrays.toString(segregate(rgbArray3)));

        // Test 4:
        char[] rgbArray4 = new char[]{'R' ,'R', 'R'};
        System.out.println(Arrays.toString(segregate(rgbArray4)));


        // Test 5:
        char[] rgbArray5 = new char[] {'B', 'B', 'B', 'B'};
        System.out.println(Arrays.toString(segregate(rgbArray5)));

        // Test 6:
        char[] rgbArray6 = new char[]{'G', 'G', 'G'};
        System.out.println(Arrays.toString(segregate(rgbArray6)));


        // Test 7
        char[] rgbArray7 = new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        System.out.println(Arrays.toString(segregate(rgbArray7)));

        // Test 8
        char[] rgbArray8 = new char[]{'R', 'R', 'B' , 'G', 'R', 'B', 'B', 'G'};
        System.out.println(Arrays.toString(segregate(rgbArray8)));
    }

}