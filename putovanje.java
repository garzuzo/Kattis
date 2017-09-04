import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class putovanje {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		String[] nc = lector.readLine().split(" ");
		int N = Integer.parseInt(nc[0]);
		int C = Integer.parseInt(nc[1]);

		String[] cadena = lector.readLine().split(" ");

		int resultado = 0;
		int llenando = 0;
		int resultadoActual = 0;
		for (int i = 0; i < N; i++) {

			for (int j = i; j < N; j++) {

				int actual = Integer.parseInt(cadena[j] + "");
				if (llenando + actual <= C) {
					llenando += actual;
					resultadoActual++;
				}
					}
			if (resultadoActual > resultado)
				resultado = resultadoActual;
			llenando = 0;
			resultadoActual = 0;
		}
		System.out.println(resultado);
	}

}
