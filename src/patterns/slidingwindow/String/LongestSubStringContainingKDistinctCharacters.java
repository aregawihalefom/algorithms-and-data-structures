package patterns.slidingwindow.String;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/****
 *  Given a string and a positive number k, find the longest substring of the string containing k distinct characters.
 *  If k is more than the total number of distinct characters in the string, return the whole string.
 *
 * Example : abcbdbdbbdcdabd
 *
 *        For k = 2, o/p is ‘bdbdbbd’
 *        For k = 3, o/p is ‘bcbdbdbbdcd’
 *        For k = 5, o/p is ‘abcbdbdbbdcdabd’
 *
 */

public class LongestSubStringContainingKDistinctCharacters {


    /***
     *  Algorithm : 1. Keep two pointers and a Hashmap to keep the counts of characters
     *              2. Every time a new character is found , add it to the HashTable if its new or increment its count
     *              3. Keep count of characters in the current running window
     *              4. if the count exceeds the given K distinct characters , move the left pointer to the right
     *                 until no more count of the left side character is found
     *              5. update the max length with the current max length
     *s
     *
     * @param str  : input string
     * @param k    : K distinct characters allowed in the substring
     * @return
     */

    public static String findLongestSubstring(String str, int k) {

        if(str.length() == 0 || k > str.length()) return null;

        HashMap<Character, Integer> hm  = new HashMap<>();
        int left = 0 ;
        int right = 0;

        int maxLength = Integer.MIN_VALUE;

        Set<Character> window = new HashSet<>();
        int begin=0 , end=0 ; // used to keep results

        int[] frq = new int[128];

        int low = 0 ; // to iterate
        for(int high = 0 ; high < str.length() ; high++){
            window.add(str.charAt(high));
            frq[str.charAt(high)]++;

            // Now go for the condition checks
            // A. If there are more elements , shrink the window
            while(window.size() > k) {
                if (--frq[str.charAt(low)] == 0)
                    window.remove(str.charAt(low));

                // keep reducing the window
                low++;
            }

            // update longest substring
            if(end - begin < high - low){
                end = high;
                begin = low;
            }
        }
        return str.substring(begin, end+1);
    }

    public static void main(String[] args) {

        String testCase1 = "abcbdbdbbdcdabd";
        int k = 2;
        System.out.println(findLongestSubstring(testCase1, k));
    }
}
