package patterns.SlidingWindow.String;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *   Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Approaches :
 *              i). Brute-force : Using Two-for loop and going as long substring as possible
 *                  Running time : 0(n^2)
 *                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         Space complexity : 0(1)
 *
 *
 */
public class LongestSubStringWithOutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s.length() <= 1) return s.length();

        HashMap<Character, Integer> hm = new HashMap<>();

        int i = 0 ; // left bound of the window
        int j = 0 ; // right bound of the window
        int maxLength = Integer.MIN_VALUE;

        while(j < s.length()){

            // right char
            char ch = s.charAt(j);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);

            // Move as far as there is no duplicate
            while(hm.get(ch) > 1){
                char left = s.charAt(i++);
                hm.put(left, hm.get(left) -1); // remove 1 character
            }
            j++;
            maxLength = Math.max(j-i ,  maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStringWithOutRepeatingCharacters obj = new LongestSubStringWithOutRepeatingCharacters();

        System.out.println(obj.lengthOfLongestSubstring("abcabcabcbb"));
       System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
       System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring("nfpdmpi"));
        System.out.println(obj.lengthOfLongestSubstring("qrsvbspk"));
    }
}
