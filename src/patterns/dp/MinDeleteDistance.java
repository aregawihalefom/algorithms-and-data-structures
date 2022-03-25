package patterns.dp;


/**
 *
 * Given two strings word1 and word2
 * return the minimum number of steps required to make word1 and word2 the same.
 * In one step, you can delete exactly one character in either string.
 *
 *  Example :
 *          Input: word1 = "sea", word2 = "eat"
 *          Output: 2
 *          Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */


public class MinDeleteDistance {

    public int minDistance(String word1, String word2) {

        if(word1.equals(word2)) return 0;
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();

        return minDistanceIterative(word1, word2);
    }

    private int minDistanceIterative(String word1 , String word2){

        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m; j++){

                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else{

                    if(word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else{
                        // take min of removing in both cases
                        dp[i][j] = 1 + Math.min(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {

        MinDeleteDistance minDeleteDistance = new MinDeleteDistance();
        String word1 = "sea", word2 = "eat";
        System.out.println(minDeleteDistance.minDistance(word1, word2));

        // test case two
        word1 = "leetcode";
        word2 = "etco";
        System.out.println(minDeleteDistance.minDistance(word1, word2));

    }


}
