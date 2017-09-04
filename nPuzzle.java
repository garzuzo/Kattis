import java.util.HashMap;
import java.util.Scanner;

public class nPuzzle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HashMap<Character, String> hm = new HashMap<Character, String>();

        int letters = 65;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                hm.put((char) letters, "" + i + j + "");
                letters++;

            }
        }

        Scanner lector = new Scanner(System.in);

        char[][] matrizActual = new char[4][4];

        int resultado = 0;
        for (int i = 0; i < matrizActual.length; i++) {

            String cadenaActual = lector.next();
            for (int j = 0; j < matrizActual.length; j++) {

                char act = cadenaActual.charAt(j);

                if (act != '.') {

                    String deberia = hm.get(act);
                    int filas =Integer.parseInt(deberia.charAt(0)+"") - i;
                    int columnas = j - Integer.parseInt(deberia.charAt(1)+"");
                    resultado += Math.abs(filas) + Math.abs(columnas);
                }

            }
        }
        System.out.println(resultado);

    }

}
