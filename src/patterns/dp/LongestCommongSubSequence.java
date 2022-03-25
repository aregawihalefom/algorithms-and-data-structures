package patterns.dp;

public class LongestCommongSubSequence {


    public int longestCommonSubsequence(String text1, String text2) {

        if(text1.equals(text2)) return text1.length();
        if(text1.isEmpty() || text2.isEmpty()) return 0;

        return LCS(text1, text2);
    }

    public int LCS(String s1 , String s2){

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <=m ; j++){
                // if the two elements are characters are equal
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else{
                    int val = Math.max(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = val;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LongestCommongSubSequence lcs = new LongestCommongSubSequence();
        System.out.println(lcs.longestCommonSubsequence("regular", "ruler"));
    }

}
