package patterns.StringArthimeticsGradeSchoolFormula;

/***
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 *
 *Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * Approach : Using the Basic HighSchool addition principle
 *
 */
public class AddingStrings {

    public static String addStrings(String num1, String num2) {

        int m = num1.length()-1;
        int n = num2.length()-1;

        // Edge cases
        if("0".equals(num1)) return num2;
        if("0".equals(num2)) return num1;

        StringBuilder sb = new StringBuilder();

        // Variable to hold carry
        int carry = 0;

        while(m >=0 || n>=0){

            int d1 = 0; // digit from num1
            int d2 = 0; // digit from num2

            if(m >=0) d1 = num1.charAt(m--)-'0';
            if(n >=0) d2 = num2.charAt(n--)-'0';

            int sum = d1 + d2 + carry ;

            sb.insert(0, sum%10);
            carry = sum/10;

        }

        if(carry !=0) sb.insert(0, carry);


        return sb.toString();
    }

    public static void main(String[] args) {

        String num1 = "456", num2 = "77";
        System.out.println(addStrings(num1, num2));
    }

}
