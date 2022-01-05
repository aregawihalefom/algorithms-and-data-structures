package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtopianTree {
    public static int utopianTree(int n) {

        int h = 1 ;

        for(int i = 1 ; i <= n ; i++){
            if(i%2 != 0) h*=2;
            else h++;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(utopianTree(3));
        List<List<Integer>> integer = new ArrayList<>();
        integer.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        integer.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        System.out.println(integer);
    }
}
