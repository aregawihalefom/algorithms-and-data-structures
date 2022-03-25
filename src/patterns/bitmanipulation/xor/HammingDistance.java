package patterns.bitmanipulation.xor;

/***
 * Given integers x, y finds the positions where the corresponding bits are different.
 *
 * Input: x = 1, y = 8
 * : 2
 * Explanation:
 * 1   (0 0 0 1)
 * 8   (1 0 0 0)
 *      ↑     ↑
 *
 *
 */
public class HammingDistance {

    /***
     *
     *  Using individual shifting operator to count the number of
     *  SET bits in the XOR result
     */
    public static int hammingDistance(int a, int b) {
        int xor = a ^ b;
        int distance = 0;

        while (xor != 0) {
            if (xor % 2 == 1) {
                distance += 1;
            }
            xor >>= 1;
        }

        return distance;
    }

    /**
     *
     * Using Brain Kernighan
     *  to count the set bits in their XOR
     *
     */

    public int hammingDistanceBrain(int a, int b){

        int distance = 0;

        int xor = a^b;

        while(xor !=0){
            distance +=1;
            xor &=(xor-1);
        }
        return distance;
    }
}
