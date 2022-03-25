package patterns.dp;

public class EditDistance {

    int[][] D;

    public int minDistance(String word1, String word2) {

        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();

        D = new int[word1.length() +1][word2.length()+1];
        fillD();
        return minDistanceIterative(word1 , word2);
    }
    private int minDistanceRecursive(String word1, String word2){

        int i = word1.length()-1;
        int j = word2.length()-1;

        // base case
        if( i == 0){
            D[i][j] = j;
            return j;
        }
        if(j == 0){
            D[i][j] = i;
            return i;
        }
        if(D[i][j] !=-1) return D[i][j];

        // if they are equal
        if(word1.charAt(i-1) == word2.charAt(j-1))
            D[i][j] = minDistanceRecursive(word1.substring(0, word1.length()-1) , word2.substring(0, word2.length()-1));
        else{

            String word2WithoutLast = word1.substring(0, word1.length()-1);
            String word1WithoutLast = word2.substring(0, word2.length()-1);

            // insertion
            int deltedFirst = minDistanceRecursive(word1WithoutLast, word2);
            int deleteSecond = minDistanceRecursive(word1, word2WithoutLast);
            int substitute =   minDistanceRecursive(word1WithoutLast, word2WithoutLast);

            int min = Math.min(deleteSecond, deltedFirst);
            min = Math.min(min, substitute);
            D[i][j] = 1 + min;
        }

        return D[i][j];
    }

    private int minDistanceIterative(String word1, String word2){

        int n = word1.length();
        int m = word2.length();
        D = new int[n+1][m+1];

        for(int i = 1 ; i <=n ; i++){
            for (int j = 1 ; j <=m ; j++){
                if(i ==0)
                    D[i][j] = j;
                else if( j == 0)
                    D[i][j] = i;
                else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        D[i][j] = D[i-1][j-1];
                    }else
                    {
                        int min = Math.min(D[i-1][j], D[i][j-1]);
                        D[i][j]  = 1 + Math.min(min,D[i-1][j-1]);
                    }
                }
            }
        }
        return D[n][m];
    }

    private void fillD(){

        for(int i = 0 ; i < D.length ; i++){
            for(int j = 0 ; j < D[1].length ; j++){
                D[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {

        EditDistance ed = new EditDistance();
        String word1 = "horse", word2 = "ros";
       System.out.println(ed.minDistance(word1, word2));

        // test case two
        word1 = "intention";
        word2 = "execution";
        System.out.println(ed.minDistance(word1, word2));

        // test case 3
        word1 = "";
        word2 = "execution";
        System.out.println(ed.minDistance(word1, word2));

    }

}
