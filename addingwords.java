import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class addingwords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		Scanner lector = new Scanner(System.in);

		while (lector.hasNext()) {
			String casoAct = lector.next();

			if (casoAct.equals("def")) {

				String name = lector.next();
				int val = lector.nextInt();
				if (hm.containsKey(name)) {

					hm.replace(name, val);
				} else {
					if (!name.equals("unknown"))
						hm.put(name, val);
				}

			} else if (casoAct.equals("calc")) {

				String cadena = "";

				boolean desconocido = false;
				int res = 0;
				String casoActual = lector.nextLine();
				casoActual = casoActual.trim();
				String[] arreglo = casoActual.split(" ");

				if (arreglo.length >= 4) {
					String op1 = arreglo[0];
					String operador = arreglo[1];
					String op2 = arreglo[2];

					if (operador.equals("+")) {
						if (hm.containsKey(op1) && hm.containsKey(op2)) {
							res = hm.get(op1) + hm.get(op2);

						} else
							desconocido = true;

					} else {
						if (hm.containsKey(op1) && hm.containsKey(op2)) {
							res = hm.get(op1) - hm.get(op2);
						} else
							desconocido = true;
					}

					for (int i = 3; i < arreglo.length - 2 && !desconocido; i++) {

						operador = arreglo[i];
						op2 = arreglo[i + 1];
						if (operador.equals("+")) {
							if (hm.containsKey(op2)) {
								res += hm.get(op2);
							} else {
								desconocido = true;
								break;
							}
						} else {
							if (hm.containsKey(op2)) {
								res -= hm.get(op2);
							} else {
								desconocido = true;
								break;
							}
						}
					}
				
				if (desconocido)
					cadena += casoActual + " unknown";
				else {

					Iterator<String> it = hm.keySet().iterator();
					if (!hm.containsValue(res)) {
						cadena += casoActual + " unknown";
					} else {
						while (it.hasNext()) {
							String actual = it.next();
							if (hm.get(actual) == res) {
								cadena += casoActual + " " + actual;
								break;
							}

						}

					}
				}
				System.out.println(cadena);
				}else{
					if(hm.containsKey(arreglo[0]))
					System.out.println(casoActual+" "+arreglo[0]);
					else
						System.out.println(casoActual+" unknown");
				}
			} else if (casoAct.equals("clear")) {
				hm.clear();
			}

		}

	}

}
