package an.algoritimos;

import java.util.Random;

public class ArrayAlgos {

    public static Integer[] fisherYates(int[] g, int max){
        Integer[] rg = new Integer[max];
        int n = g.length;
        int c = 0;

        Random r = new Random();
        do{
            n--;
            int k = r.nextInt(n + 1);
            int v = g[k];
            g[k] = g[n];
            g[n] = v;

            rg[c] = v;
            c++;
        }while (n > 1 && c < max);

        return rg;
    }

}
