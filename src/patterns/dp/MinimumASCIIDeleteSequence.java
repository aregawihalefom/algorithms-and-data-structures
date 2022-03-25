package patterns.dp;

/***
 *  Algorithm : Edit Distance
 *
 *
 *  Given two strings s1 and s2, return the lowest ASCII sum of
 *  deleted characters to make two strings equal.
 *
 *   Example :
 *          Input: s1 = "sea", s2 = "eat"
 *          Output: 231
 *          Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 *          Deleting "t" from "eat" adds 116 to the sum.
 *          At the end, both strings are equal,
 *          and 115 + 116 = 231 is the minimum sum possible to achieve this.
 *
 */

public class MinimumASCIIDeleteSequence {


    public int minimumDeleteSum(String s1, String s2) {

        if(s1.equals(s2)) return 0;
       return  minDeleteASCIIIterative(s1, s2);
    }

    private int minDeleteASCIIIterative(String word1, String word2){

        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            dp[i][0] = dp[i-1][0] + word1.charAt(i-1);
        }

        for(int j = 1; j <= m; j++){
            dp[0][j] = dp[0][j-1] + word2.charAt(j-1);
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] ;
                else{
                    // take min of removing in both cases
                    dp[i][j] = Math.min(dp[i-1][j] + word1.charAt(i-1) , dp[i][j-1] + word2.charAt(j-1));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

        MinimumASCIIDeleteSequence minimumASCIIDeleteSequence = new MinimumASCIIDeleteSequence();
        String word1 = "sea", word2 = "eat";
        System.out.println(minimumASCIIDeleteSequence.minimumDeleteSum(word1, word2));

        // test case two
        word1 = "delete";
        word2 = "leet";
        System.out.println(minimumASCIIDeleteSequence.minimumDeleteSum(word1, word2));

    }


}
