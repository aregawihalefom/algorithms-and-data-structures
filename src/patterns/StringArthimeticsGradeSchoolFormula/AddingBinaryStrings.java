package patterns.StringArthimeticsGradeSchoolFormula;

/***
 *
 * Description : Given two binary strings a and b, return their sum as a binary string.
 *
 * Example : Input: a = "11", b = "1"
 *          Output: "100"
 *
 *  Approach 1 : Using Basic school addition procedure
 *              - Running Time : 0(n)
 *              - Space : 0(1)
 */

public class AddingBinaryStrings {

    public String addBinary(String a, String b) {

        // Base Cases
        if(a.isEmpty()) return b;
        if(b.isEmpty()) return a;

        // Result accumulator
        StringBuilder sb = new StringBuilder();

        int carry = 0 ;
        int lenA = a.length()-1;
        int lenB = b.length()-1;


        while(lenA >=0 || lenB >=0) {

            int valA = 0;
            int valB = 0;

            // Changing to integers
            if(lenA >=0)  valA =  a.charAt(lenA--) == '1' ? 1 : 0;
            if(lenB >=0)  valB =  b.charAt(lenB--) == '1' ? 1 : 0;


            if ((valA & valB) == 1) { // Both 1
                sb = (carry == 1) ? sb.append(1) : sb.append(0); // possibility  : 11 ( with carry) or 10( without carry)
                carry = 1;
            } else if ((valA | valB) == 0) { // both zeros
                sb = carry == 1 ? sb.append(1) : sb.append(0); // 1 ( when there is carry)
                carry = 0;
            } else { // are different
                sb = carry == 1 ? sb.append(0) : sb.append(1);
            }

        }
        // check if there is carry still
        if(carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
