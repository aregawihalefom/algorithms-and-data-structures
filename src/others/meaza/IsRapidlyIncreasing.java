package others.meaza;

public class IsRapidlyIncreasing {

    public static int isRapidlyIncreasing(int[ ] a){

        if(a.length == 1) return 1;

        int sumSofar = a[0];

        for(int i = 1; i < a.length ; i++){
            if(a[i] <= 2*sumSofar) return 0;
            sumSofar += a[i];
        }

        return 1;
    }

    public static void main(String[] args) {

        int[] testCase1 = new int[]{ 1, 3, 9, 27};
        System.out.println(isRapidlyIncreasing(testCase1));

        int[] testCase2 = new int[]{ 3, 200, 500};
        System.out.println(isRapidlyIncreasing(testCase2));

        int[] testCase3 = new int[]{1};
        System.out.println(isRapidlyIncreasing(testCase3));

        int[] testCase4 = new int[]{1,  3, 9, 26};
        System.out.println(isRapidlyIncreasing(testCase4));


        int[] testCase5 = new int[]{1, 3, 7, 26};
        System.out.println(isRapidlyIncreasing(testCase5));

        int[] testCase6 = new int[]{1, 3, 8, 26};
        System.out.println(isRapidlyIncreasing(testCase6));

    }
}
