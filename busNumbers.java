import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class busNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);

		int total = lector.nextInt();

		int[] arreglo = new int[total];
		for (int i = 0; i < total; i++) {
			arreglo[i] = lector.nextInt();
		}
		Arrays.sort(arreglo);
		int i = 0;
		while (true) {

			boolean entro = false;
			if (i == arreglo.length)
				break;

			int inicio1 = arreglo[i];
			int fin = arreglo[i];
			int numEntradas = 0;
			while (arreglo.length>i+1  && arreglo[i] + 1 == arreglo[i + 1]) {

				i++;
				fin = arreglo[i];
				entro = true;
				numEntradas++;
			}
			if (numEntradas >= 2){
				System.out.print(inicio1 + "-" + fin + " ");
			i++;
			}else if(numEntradas==1){
				i--;
				System.out.print(arreglo[i] + " ");
				i++;
			}else{
			
				System.out.print(arreglo[i] + " ");
				i++;
			}
		}
	}

}
