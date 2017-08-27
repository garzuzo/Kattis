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
					if(!name.equals("unknown"))
					hm.put(name, val);
				}

			} else if (casoAct.equals("calc")) {

				String cadena = "";
				String resultado = "";
				int res = 0;
				String act = "";
				String act1 = "";
				String pasante = "";
				String operador = "";
				while (!pasante.equals("=")) {

					if (act.equals("")) {
						act = lector.next();

						cadena += act + " ";
						if (resultado.equals("") && hm.containsKey(act)) {

							res += hm.get(act);

						} else {
							resultado = "unknown";
							res = 0;
						}
					} else {
						act = act1;
					}
					operador = lector.next();
					if (pasante.equals(""))
						act1 = lector.next();
					else if (pasante.equals("+") || pasante.equals("-")) {
						String temp = operador;
						operador = pasante;
						act1 = temp;
					} else {
						act1 = pasante;
					}
					cadena += operador+" ";
					cadena += act1 + " ";
					if (resultado.equals("") && hm.containsKey(act1)) {
						if (operador.equals("+"))
							res += hm.get(act1);
						else
							res -= hm.get(act1);
					} else {
						resultado = "unknown";
						res = 0;
					}

					pasante = lector.next();
				}
				if (res == 0)
					cadena += "= " + resultado;
				else {

					Iterator<String> it = hm.keySet().iterator();
					if (!hm.containsValue(res)) {
						cadena += "= unknown";
					} else {
						while (it.hasNext()) {
							String actual = it.next();
							if (hm.get(actual) == res) {
								cadena += "= " + actual;
								break;
							}

						}

					}
				}
				System.out.println(cadena);
			} else if (casoAct.equals("clear")) {
				hm.clear();
			}

		}

	}

}
