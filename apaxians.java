import java.util.Scanner;

public class apaxians {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);

		String caso = lector.nextLine();

		int i = 0;
		String respuesta = "";
		boolean entro = false;
		char charActual = caso.charAt(i);
		i += 1;
		respuesta += charActual + "";
		char anteriorAgregado = charActual;
		while (i < caso.length()) {
			charActual = caso.charAt(i);
			if (charActual == anteriorAgregado) {
				i++;
			} else {
				respuesta += charActual + "";
				anteriorAgregado = charActual;
				i++;
			}

		}
System.out.println(respuesta);
	}

}
