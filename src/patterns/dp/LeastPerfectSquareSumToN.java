package patterns.dp;

/***
 *
 *          Given  a  positive  integer  n, find  the  least  number  of perfect  square  numbers which  sum  to  n. ( Perfect  square numbers  are  1,  4,  9,  16, 25,  36, 49,  … For example,  given n =  12,  return  3 Given  n  =  13, return  2 Given  n  =  67  ret ; (13  =  4  +  9) ;
 *          (12  =  4  +  4  +  4) urn  3;  (67  =  49  +  9  +  9)
 *
 */
public class LeastPerfectSquareSumToN {


    public int minPerfectSquareSumRecusrive(int n){

        if(n <= 3)
            return n ;
        int res = n;
        for(int i = 1; i *i <= n; i++){
            res = Math.min(res, 1 + minPerfectSquareSumRecusrive(n - i*i));
        }
        return res;
    }

    public int minPerfectSquareSumIterativeMemoization(int n)
    {

        if(n <= 3) return n;

        int[] mem = new int[n+1];
        for(int i = 0 ; i <= 3 ; i++) ;

        // now do the process
        for(int i= 4 ; i <=n ; i++){
            mem[i] = i;
            for(int j = 1; j*j <=n ; j++){

                // the next perfect square
                int temp = j*j;

                if(temp > i) break;

                mem[i] = Math.min(mem[i], 1 +mem[i-temp]);
        }

        }
    return mem[n];
    }
    public static void main(String[] args) {

        LeastPerfectSquareSumToN lps = new LeastPerfectSquareSumToN();
        System.out.println(lps.minPerfectSquareSumRecusrive(13));
        System.out.println(lps.minPerfectSquareSumIterativeMemoization(13));
    }
}
