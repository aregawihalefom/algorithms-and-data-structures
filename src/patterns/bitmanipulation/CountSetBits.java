package patterns.bitmanipulation;


/**
 *  Write a program to count set bits of an integer.
 *   Set bits are - the 1's in a binary representation of the given number
 *
 *   Example : 0101 , There are two setbit ( Two 1's)
 *
 *
 */
public class CountSetBits {

    public static int countBits(int n){

        int count = 0;
        while(n > 0){

             count += (n&1);
             n >>=1;
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(countBits(125));

    }


}
