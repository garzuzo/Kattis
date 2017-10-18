import java.util.*;
import java.io.*;

public class RestaurantOrders {

    static HashMap<Integer, pair> hm;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(lect.readLine());
        String[] ar = lect.readLine().split(" ");
        int[] arr = new int[n];
        HashMap<Integer,Integer> platPos=new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
            int val=Integer.parseInt(ar[i]);
            arr[i] = val;
            platPos.put(val, i+1);
        }
        int q = Integer.parseInt(lect.readLine());
        String[] queries = lect.readLine().split(" ");
        for (int i = 0; i < q; i++) {
            int act = Integer.parseInt(queries[i]);
            hm = new HashMap<Integer, pair>();
            long r = (countWays(arr, n, act));
            if (r == 0)
            esc.write("Impossible\n");
            else if (r > 1)
                esc.write("Ambiguous\n");
            else {
                StringBuilder sb=new StringBuilder();
                ArrayList<Integer> retorno=new ArrayList<Integer>();
                while(!platPos.containsKey(act)){
                    retorno.add(platPos.get((int)hm.get(act).b));
                    act=(int)hm.get(act).a;
                    
                    
                }
                retorno.add(platPos.get((int)hm.get(act).b));
                Collections.sort(retorno);
                for (int j = 0; j < retorno.size(); j++) {
                    if(j+1<retorno.size())
                    sb.append(retorno.get(j)+" ");
                    else
                        sb.append(retorno.get(j));
                }
                esc.write(sb+"\n");

            }
        }
        esc.flush();
    }

    static long countWays(int S[], int m, int n) {
        // Time complexity of this function: O(mn)
        // Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n + 1];

        // Initialize all table values as 0
        //Arrays.fill(table, 0); // O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin

        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++) {
                
                
                 if (table[j - S[i]] != 0 && !hm.containsKey(j)) {
                    
                    
                    hm.put(j, new pair((j - S[i]),  j-(j - S[i])));
                }
                table[j] += table[j - S[i]];

                if(table[n]>2)
                    return 2;
            }

        return table[n];
    }
}

class pair {

    long a;
    long b;

    public pair(long a, long b) {

        this.a = a;
        this.b = b;

    }

}
