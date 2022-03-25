package patterns.dp;

/***
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 */

public class LongestPalindromicSubSequence {



    private String s1;
    private String s2;

    private int[][] dp;

    public String longestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        s1 = s;
        s2 = sb.reverse().toString();

        return helper(s1, s2);

    }

    public String helper(String s1 , String s2){

        int n = s1.length();
        dp = new int[n+1][n+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= n ; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Now we know the largest subString starting index
        int lastIndex = dp[n][n];
        StringBuilder sb = new StringBuilder();

        // Back Tracking the results stored in the dp

        int i = n ,j = n;

        while(i >0 && j > 0){

            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));

                i--;j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])

                i--; // find the next along the i
            else
                j--; // find the next along the j
        }
        return sb.toString();
    }


}
