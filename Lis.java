import java.util.*;
import java.io.*;

public class lis {
	static int[] arr;
	static HashMap<Integer, TreeSet<Integer>> hm;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));
		String caso;
		while ((caso = lect.readLine()) != null) {
			int n = Integer.parseInt(caso);
			arr = new int[n];
			String[] a = lect.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(a[i]);
			}
			 hm=new HashMap<Integer,TreeSet<Integer>>();
			int[] ret=lis(arr, n);
			esc.write(ret[0]+"\n");
			TreeSet<Integer> arr=hm.get(ret[1]);
		
			Iterator<Integer> it=arr.iterator();
			while (it.hasNext()) {
				
				int pos=it.next();
				if(it.hasNext())
				 esc.write(pos+" ");
				else
					 esc.write(pos+"\n");
			}
			
			
		}
		esc.flush();

	}
	static int[] lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0,posMax=0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++){
			lis[i] = 1;
		}
		/* Compute optimized LIS values in bottom up manner */
		TreeSet<Integer> act1 = new TreeSet<Integer>();
		act1.add(0);
		hm.put(0, act1);
		for (i = 1; i < n; i++) {
			TreeSet<Integer> act = new TreeSet<Integer>();
			act.add(i);
			hm.put(i, act);
			int ultimaPos=-1;
			int jj=-1;
			for (j = 0; j < i; j++) {
				jj=j;
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
					ultimaPos=j;

				}
			}
			if(ultimaPos!=-1){
				TreeSet<Integer> list=hm.get(ultimaPos);
				for(int val: list)
					hm.get(i).add(val);
				
				}
			
		}
		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++){
			if (max <= lis[i]){
				max = lis[i];
			posMax=i;
			}
		}
		int[] ret=new int[2];
		ret[0]=max;
		ret[1]=posMax;
		return ret;
	}
}
