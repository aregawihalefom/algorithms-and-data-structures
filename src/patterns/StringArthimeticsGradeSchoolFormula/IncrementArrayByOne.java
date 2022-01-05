package patterns.StringArthimeticsGradeSchoolFormula;

import java.util.ArrayList;
import java.util.List;

/***
 *
 *  Description : Write a program which takes as input an array of digits encoding a decimal number
 *                D and updates the array to represent the number D + 1. For example, if the input
 *                is (1,2,9) then you should update the array to (1,3,0). Your algorithm should work
 *                even if it is implemented in a language that has finite-precision arithmetic.
 *
 *  Example : 1. Input : {1, 2, 9} => Output : {1, 3, 0}
 *            2. Input : {9, 9, 9} => Output : {1, 0, 0, 0}
 *
 *
 *  Application : Addition of large numbers that cannot be performed in the range of integers. Particularly , this
 *                is a problem with languages the imposes limit over range of types.
 *                We can avoid overflow issues by operating directly on the array of digits.
 *
 *
 *  Naive  : move the array into an integer and then perform addition and then copy back the digits to the array
 *          Problems : Overflow is likely
 *          Running Time : 0(n) -> n is equal to the number of digits in the number or size of the input array
 *          Space : 0(1)
 *
 *
 * Best Approach : Use grade school addition using a carry variables
 *                 Code : gradeSchoolAddition method
 *
 *
 *  Variants : 1. Adding two Binary Strings Bt and Bs : Important point is following the addition
 *             2. Adding two arrays
 *             3. Adding Two linked lists
 *             4. Multiply String
 *             5. Adding Strings
 */

public class IncrementArrayByOne {

    public static List<Integer> addOneToArray(List<Integer> list){

        int n = list.size()-1;

        // We only add 1 to the last element
        list.set(n,  list.get(n) + 1);

        for(int i = n ; i > 0 && list.get(i) >=10; i--){
                list.set(i, 0);
                list.set(i-1, list.get(i-1)+1); // move this to the next as a carry
        }

        if(list.get(0) == 10){
            list.set(0, 0);
            list.add(0, 1);
        }
        return list;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<Integer>() {{add(1);add(2);add(9);}};
        System.out.println(addOneToArray(list1));

        ArrayList<Integer> list2 = new ArrayList<Integer>() {{add(9);add(9);add(9);}};
        System.out.println(addOneToArray(list2));
    }


}
