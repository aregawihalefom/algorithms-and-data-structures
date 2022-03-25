package patterns.stringArthimeticsGradeSchoolFormula;

/***
 *
 *
 *
 *
 *
 *
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();

        if(m == 0|| n == 0 ||"0".equals(num1) || "0".equals(num2)) return "0";

        if("1".equals(num2)) return num1;
        if("1".equals(num1)) return num2;


        int[] result = new int[m + n];

        for(int i = m-1; i >=0 ; i--){
            for(int j = n-1 ; j>=0; j--){

                // Get the product
                int pro = (num1.charAt(i) -'0') * (num2.charAt(j)-'0');

                // Now consider adding it to the accumlated result
                int sum = pro + result[i + j +1];

                // put the result back and get the carry to the next position
                result[i+j+1] = sum %10;
                result[i+j]  +=sum/10;
            }
        }
        // Now remove the corner case and conver to string
        StringBuilder sb = new StringBuilder();

        for(int val : result){
            if(sb.length() !=0 || val !=0){
                sb.append(val);
            }
        }

        return sb.toString();
    }
}
