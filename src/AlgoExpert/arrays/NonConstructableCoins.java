package AlgoExpert.arrays;

import java.util.Arrays;

/**
 *  Algoexpert
 */
public class NonConstructableCoins {

    public int nonConstructibleChange(int[] coins) {

        Arrays.sort(coins);

        if(coins.length == 0 || coins[0]!=1) return 1;

        int currentChange = 1;

        for(int i = 1; i < coins.length; i++){
            if(currentChange + 1  < coins[i])
                return currentChange+1;
            currentChange += coins[i];
        }
        return currentChange+1;
    }
    public static void main(String[] args) {
        NonConstructableCoins constructableCoins = new NonConstructableCoins();
        int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22};
        System.out.println(constructableCoins.nonConstructibleChange(coins));
    }

}
