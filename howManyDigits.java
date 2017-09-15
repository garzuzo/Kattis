import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class howManyDigits {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arreglo = new int[1000001];
		arreglo[0] = 1;
		double resp = 0;
		for (int i = 1; i <= 1000000; i++) {
			resp += Math.log10(i);
			int resultado = (int) (resp) + 1;

			arreglo[i] = resultado;
		}

		while (lector.hasNext()) {

			int n = lector.nextInt();

			esc.write(arreglo[n] + "\n");
		}
		esc.flush();
	}

}
