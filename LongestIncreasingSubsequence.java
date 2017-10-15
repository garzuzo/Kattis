import java.util.*;
import java.io.*;

public class LongestIncreasingSubsequence {
	static int[] mem;
	static boolean[] comp;
	static int[] arr;
	static HashMap<Integer, ArrayList<Integer>> hm;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

		String caso;
		while ((caso = lect.readLine()) != null) {
			int n = Integer.parseInt(caso);

//			mem = new int[n];
//			for (int i = 0; i < n; i++) {
//				mem[i] = Integer.MIN_VALUE;
//			}
//			comp = new boolean[n];
			arr = new int[n];
			String[] a = lect.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(a[i]);
			}
			 hm=new HashMap<Integer,ArrayList<Integer>>();
			int[] ret=lis(arr, n);
			esc.write(ret[0]+"\n");
			ArrayList<Integer> arr=hm.get(ret[1]);
			Collections.sort(arr);
			for (int j = 0; j < arr.size(); j++) {
				 if(j+1<arr.size())
				 esc.write(arr.get(j)+" ");
				else
				 esc.write(arr.get(j)+"\n");
			}
		
			// int max=Integer.MIN_VALUE;
			// int posMax=0;
			// for (int i = 0; i < a.length; i++) {
			//
			// ArrayList<Integer> act=new ArrayList<Integer>();
			// act.add(i);
			// hm.put(i,act);
			// int actual=maxSum(i);
			// if(max<=actual){
			// max=actual;
			// posMax=i;
			// }
			// }
			// ArrayList<Integer> answer=hm.get(posMax);
			// Collections.sort(answer);
			// esc.write(answer.size()+"\n");
			// for (int j = 0; j < answer.size(); j++) {
			// if(j+1<answer.size())
			// esc.write(answer.get(j)+" \n");
			// else
			// esc.write(answer.get(j)+"\n");
			// }

		}
		esc.flush();

	}

	static int maxSum(int i) {

		if (i == 0)
			return arr[i];

		if (comp[i])
			return mem[i];
		int anterior = 0;
		int posAnterior = i;

		for (int j = i; j > 0; j--) {
			int act = maxSum(j - 1);
			if (act > anterior && arr[j - 1] < arr[i] && hm.get(j - 1).size() >= hm.get(posAnterior).size()) {
				anterior = act;
				posAnterior = j - 1;

			}
		}
		ArrayList<Integer> retorno = hm.get(posAnterior);
		if (retorno != hm.get(i)) {
			for (int j = 0; j < retorno.size(); j++) {
				hm.get(i).add(retorno.get(j));
			}
		}
		int max = arr[i] + anterior;

		comp[i] = true;
		mem[i] = max;

		return max;
	}

	static int[] lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0,posMax=0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++){
			lis[i] = 1;
		}
		/* Compute optimized LIS values in bottom up manner */
		ArrayList<Integer> act1 = new ArrayList<Integer>();
		act1.add(0);
		hm.put(0, act1);
		for (i = 1; i < n; i++) {
			ArrayList<Integer> act = new ArrayList<Integer>();
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
				ArrayList<Integer> list=hm.get(ultimaPos);
				for (int k = 0; k < list.size(); k++) {
					
					hm.get(i).add(list.get(k));
				}
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
