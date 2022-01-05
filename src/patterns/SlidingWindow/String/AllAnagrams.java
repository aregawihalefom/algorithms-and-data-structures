package patterns.SlidingWindow.String;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * Find all substrings of a string that contains all characters of another string.
 * In other words, find all substrings of the first string that are anagrams of the second string.
 *
 * ~~~~~~~~~~~~~ In other words ~~~~~~~~~~~~
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Approach one : Brute force : - Generating every substring of S1 of size equal to s2.
 *                              - Check if their any of the substring are permutation of s2
 *                              Running Time :
 * Approach Two : Sliding window : Take a window of size S2.SIZE() from second window and compare if the two are anagrams
 */

public class AllAnagrams {

    private final int RANGE = 256;
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length() ;
        int m = s2.length();

        if(n < m) return false;

        int left , right ; // pointers for the window

        List<Character> window = new ArrayList<>();
        return false;
    }

    public boolean isAnagram(String s1 , String s2){

        if(s1.length() != s2.length()) return false;

        int[] frequency = new int[256];
        for(int i =0 ; i < s1.length() ;i++){
            frequency[i]++;
            frequency[i]--;
        }
        for(int j = 0 ; j < RANGE ; j++){
            if(frequency[j]!=0) return false;
        }
        return true;
    }
}
