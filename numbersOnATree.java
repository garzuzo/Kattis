import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numbersOnATree {

	public static void main(String[] args) throws IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = lector.readLine().split(" ");
		int altura = Integer.parseInt(arr[0]);
		int numNodos = 0;
		for (int i = 0; i <= altura; i++) {
			numNodos += Math.pow(2, i);
		}
		if (arr.length == 2) {
			String req = arr[1];
			long respuesta = 0;
			int pos = 0;
			for (int i = 0; i < req.length(); i++) {

				char actual = req.charAt(i);

				if (actual == 'L') {
					pos = 2 * pos + 1;
					respuesta = numNodos - pos;
				} else {
					pos = 2 * pos + 2;
					respuesta = numNodos - pos;
				}
			}
			System.out.println(respuesta);
		} else {
			System.out.println(numNodos);
		}
	}
}
