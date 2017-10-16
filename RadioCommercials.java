import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RadioCommercials {

	static int[] mem;
	static boolean[] calc;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] caso = lect.readLine().split(" ");

		int n = Integer.parseInt(caso[0]);
		int p = Integer.parseInt(caso[1]);

		mem = new int[n];
		calc = new boolean[n];
		arr = new int[n];
		String[] arrAct = lect.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(arrAct[i]);
		}
		for (int i = 0; i < n; i++) {
			mem[i] = Integer.MIN_VALUE;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arrAct.length; i++) {
			int retAct = dp(i, p);
			if (retAct > max)
				max = retAct;
		}
		esc.write(max+"\n");
		esc.flush();
	}

	static int dp(int i, int substract) {

		if (i == 0)
			return arr[0] - substract;

		if (calc[i])
			return mem[i];

		int max = Math.max(arr[i] - substract, arr[i] + dp(i - 1, substract) - substract);

		calc[i] = true;
		mem[i] = max;
		return max;
	}

}
