import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.TreeSet;

public class lisDP {
	static int[] arr;
	static TreeSet<Integer> ts;

	public static void main(String[] args) throws IOException {
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
			esc.write(LongestIncreasingSubsequenceLength(arr, n) + "\n");

			Iterator<Integer> it = ts.iterator();
			while (it.hasNext()) {
				int pos = it.next();
				if (it.hasNext()) {
					esc.write(pos + " ");
				} else
					esc.write(pos + "\n");

			}
		}
		esc.flush();

	}

	// Binary search (note boundaries in the caller)
	// A[] is ceilIndex in the caller
	static int CeilIndex(int A[], int l, int r, int key) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (A[m] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}

	static int LongestIncreasingSubsequenceLength(int A[], int size) {
		// Add boundary case, when array size is one

		int[] tailTable = new int[size];
		int len; // always points empty slot
		ts = new TreeSet<Integer>();
		tailTable[0] = A[0];
		len = 1;
		int pos = 0;
		ts.add(0);
		boolean entro = true;
		for (int i = 1; i < size; i++) {
			if (A[i] < tailTable[0]) {
				// new smallest value
				tailTable[0] = A[i];

			} else if (A[i] > tailTable[len - 1]) {
				// A[i] wants to extend largest subsequence
				if (entro)
					ts.add(pos);
				tailTable[len++] = A[i];
				pos = i;

				entro = false;
			} else {
				// A[i] wants to be current end candidate of an existing
				// subsequence. It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
				entro = true;
				pos = i;
			}
		}

		return len;
	}
}
