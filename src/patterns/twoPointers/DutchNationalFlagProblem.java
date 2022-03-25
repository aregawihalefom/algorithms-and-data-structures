package patterns.twoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 *
 * Description  : Given an array  of there characters R, G, B in a random order ,
 *                 The task is to randomly arrange balls of white, red, and blue
 *                 such that balls of the same color are placed together.
 *                 For this problem assume all R comes first , the all RED and finally all BLUE
 *
 *                 Example A = ['R', 'B', 'B', 'R', 'G', 'B'] ,
 *                              the algorithm should result in ['R', 'R', 'G', 'B', 'B','B']
 *
 *  Different approaches :
 *
 *     i)  Naive Approach 1: Using Quick sort or any possible comparison based sorting.
 *                          - Running Time : 0(nlogn)
 *                          - Space complexity : 0(n)
 *
 *     ii) Naive Approach 2: We use three Lists for the three different element and put them in the list using
 *                           the middle element as a pivot and finally combine the lists together
 *                           -
 *                           Running Time : 0(n)
 *                           Space complexity : 0(n)
 *
 *     iii) .  Best Approach 1 :  - Use two counters for RED(#R) and GREEN(#G).
 *                                              - Populate the output array using the counters
 *                                              - fill #R- R , #G - G and the remaining B
 *                                              - Running Time = O(n)
 *                                                Space complexity : O(1)
 *                                               - Code  : See the method usingCounters
 *
 *      iv) Best Approach 2 :  - Use two loops : 1 - Move all red to the beginning
 *                                              2- Move all blue to the end
 *                                              - Running Time  = O(n)
 *                                              - Space complexity = O(1)
 *                                              - Code : See Method usingTwoSeparateForLoops
 *
 *     v) Final :  - Single Loop  : 1 - Use Two pointers from the end and from the beginning
 *                                    - Code see segregate method
 *
 *   Variants :  1. Order Binary array so that similar elements of the array appear sequentially
 *               2. Order An array of three element so that ''''''''
 *
 *
 *
 *
 */
public class DutchNationalFlagProblem {

    private final static char RED = 'R';
    private final static char GREEN = 'G';
    private final static char BLUE = 'B';

    public static char[] usingCounters(char[] colors) {

        int countRed = 0, countGreen = 0;

        for (char ch : colors) {
            if (ch == RED) countRed++;
            else if (ch == GREEN) countGreen++;
        }

        for (int i = 0; i < colors.length; i++) {
            if (i < countRed)
                colors[i] = RED;
            else if (i >= countRed && i < countRed + countGreen)
                colors[i] = GREEN;
            else
                colors[i] = BLUE;
        }

        return colors;
    }

    public static char[] usingTwoSeparateForLoops(char[] colors) {

        int redIndex = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == RED) {
                swap(colors, redIndex++, i);
            }
        }

        return colors;
    }

    public static char[] swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
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



    //*** Solution from elements of programing in Java
    public static void dutchFlagPartition(int pivotlndex, List<Color> A) {
        Color pivot = A.get(pivotlndex);
        /*
         * Keep the following invariants during partitioning:
         * bottom group: A .subList (SI , smaller) .
         * middle group: A .subList (smaller , equal).
         * unclassified group: A .subList (equal , larger).
         * top group: A .subList (larger , A . size ()) .
         */
        int smaller = 0, equal = 0, larger = A.size();
        // Keep iterating as long as there is an unclassified element.
        while (equal < larger) {

           // A .get (equal) is the incoming unclassified element.
            if (A.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(A, smaller++, equal++);
            } else if (A.get(equal).ordinal() == pivot.ordinal()) {
                ++equal;
            } else { // A . get (equal) > pivot.
                Collections.swap(A, equal, --larger);
            }
        }
    }

    public static void main(String[] args) {

//        char[] rgbArray1 = new char[]{'G', 'B' , 'R'};
//        System.out.println(patterns.toString(usingTwoSeparateForLoops(rgbArray1)));

        // Test 2
        char[] rgbArray2 = new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        System.out.println(Arrays.toString(usingCounters(rgbArray2)));

//        // Test 3:
//        char[] rgbArray3 = new char[]{'R' ,'G', 'G'};
//        System.out.println(patterns.toString(segregate(rgbArray3)));
//
//        // Test 4:
//        char[] rgbArray4 = new char[]{'R' ,'R', 'R'};
//        System.out.println(patterns.toString(segregate(rgbArray4)));
//
//
//        // Test 5:
//        char[] rgbArray5 = new char[] {'B', 'B', 'B', 'B'};
//        System.out.println(patterns.toString(segregate(rgbArray5)));
//
//        // Test 6:
//        char[] rgbArray6 = new char[]{'G', 'G', 'G'};
//        System.out.println(patterns.toString(segregate(rgbArray6)));
//
//
//        // Test 7
//        char[] rgbArray7 = new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'};
//        System.out.println(patterns.toString(segregate(rgbArray7)));
//
//        // Test 8
//        char[] rgbArray8 = new char[]{'R', 'R', 'B' , 'G', 'R', 'B', 'B', 'G'};
//        System.out.println(patterns.toString(segregate(rgbArray8)));
        // }


    }

    public enum Color {RED, WHITE, BLUE}


}


