package epi.arrays;

import java.util.Arrays;
import java.util.List;

public class AddOneToArray {

    public static List<Integer> plusOne(List<Integer> list){


        // Principle
        // Add the element to the last element
        int size = list.size()-1;
        list.set(size , list.get(size) +1);

        for(int i = size ; i >0; i--){
            if(list.get(i) == 10){
                list.set(i, 0);
                list.set(i-1, list.get(i-1)+1);
            }
        }

        // if the last element is still 10
        // add more
        if(list.get(0) == 10){
            list.set(0, 0);
            list.add(0, 1);
        }

        return list;
    }

    public  static int[] plusOne(int[] digits) {

        /**
         *
         * Idea : Basic Mathematical Addition
         *     Add one to the last digit , if the current any 9 is not encountered , return directly
         *
         *     OtherWise : keep setting to zero if you still keep getting 9
         *
         *
         */

        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[len + 1];
        digits[0] = 1;
        return digits;

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 9 , 9);

       // System.out.println(plusOne(list));

        int[] testCase2 = new int[]{1, 2, 4};
        int[] testCase3 = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOne(testCase3)));
        System.out.println(Arrays.toString(plusOne(testCase2)));

        int[] testCase4 = new int[]{};
        System.out.println(Arrays.toString(plusOne(testCase4)));
    }
}
