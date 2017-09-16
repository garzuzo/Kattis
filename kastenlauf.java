import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class kastenlauf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		

		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

		// max 20

		int tcases = Integer.parseInt(lector.readLine());
		while (tcases > 0) {

			int n = Integer.parseInt(lector.readLine());
			grafo graph = new grafo(n + 2);

			String[] source = lector.readLine().split(" ");
			coordenada coordInicio = new coordenada(Integer.parseInt(source[0]), Integer.parseInt(source[1]), -1);

			vertice inicio=new vertice(0, coordInicio);
			graph.agregar(inicio);

			for (int i = 1; i <= n; i++) {
				String[] cord = lector.readLine().split(" ");
				coordenada coordActual = new coordenada(Integer.parseInt(cord[0]), Integer.parseInt(cord[1]));

				vertice act = new vertice(i, coordActual);
				graph.agregar(act);
			}

			String[] fin = lector.readLine().split(" ");
			coordenada coordFin = new coordenada(Integer.parseInt(fin[0]), Integer.parseInt(fin[1]), 1);
			vertice act = new vertice(n + 1, coordFin);
			graph.agregar(act);

			graph.conectar();
			
			boolean llega = graph.bfs(inicio);

			if (llega)
				esc.write("happy\n");
			else
				esc.write("sad\n");	
			tcases--;
		}
		esc.flush();
	}

}

class grafo {

	HashMap<vertice, arista[]> g = new HashMap<vertice, arista[]>();

	vertice[] agregados;

	int size;

	public grafo(int n) {

		agregados = new vertice[n];
		size = 0;
	}

	public void agregar(vertice v) {
		arista[] na = new arista[agregados.length];
		
		g.put(v, na);
agregados[size]=v;
size++;
	}

	boolean bfs(vertice source) {

		ArrayList<Integer> array = new ArrayList<Integer>(size);

		Queue<vertice> cola = new ArrayDeque<vertice>();
		cola.offer(source);

		boolean termina = false;
		while (!cola.isEmpty() && !termina) {

			vertice poleado = cola.poll();

			if (!poleado.color.equals(vertice.BLACK)) {
				poleado.color = vertice.BLACK;

				array.add(poleado.valor);

				arista[] arrayActual = g.get(poleado);

				for (int i = 0; i < arrayActual.length && !termina; i++) {
					if(i!=poleado.valor){
					arista aristaAct = arrayActual[i];
					vertice vActual = aristaAct.v2;

					if (!vActual.color.equals(vertice.BLACK)) {
						if (aristaAct.costo <= 1000) {
							if (vActual.coord.pos == 1 || aristaAct.v1.coord.pos==1) {
								termina=true;
							} else {
								cola.offer(vActual);
								vActual.color = vertice.GRIS;
							}
						}
					}
				}
				}
			}

		}
		if(!termina){
			
		}
		
		return termina;
	}

	public void conectar() {

		for (int i = 0; i < agregados.length; i++) {

			for (int j = 0; j < agregados.length; j++) {

				if (i != j) {
					vertice v1 = agregados[i];
					vertice v2 = agregados[j];
					int diferencia = Math.abs(v1.coord.x - v2.coord.x) + Math.abs(v1.coord.y - v2.coord.y);
					arista act = new arista(v1, v2, diferencia);
					arista act1 = new arista(v2, v1, diferencia);
					if (g.get(v1)[j] == null)
						g.get(v1)[j] = act;
					if(g.get(v2)[i]==null)
						g.get(v2)[i]=act1;

				}

			}
		}

	}
}

class arista {

	vertice v1;
	vertice v2;

	int costo;

	public arista(vertice v1, vertice v2, int costo) {
		this.v1 = v1;
		this.v2 = v2;
		this.costo = costo;

	}

}

class vertice implements Comparator<vertice> {

	int valor;
	coordenada coord;

	String color;
	static final String BLACK = "b";
	static final String BLANCO = "bl";
	static final String GRIS = "g";

	public vertice(int valor, coordenada coord) {
		this.valor = valor;
		this.coord = coord;
		color = BLANCO;

	}


	@Override
	public int compare(vertice v1, vertice v2) {
		// TODO Auto-generated method stub
		return v1.valor-v2.valor;
	}

}

class coordenada {

	int x;
	int y;
	int pos;

	public coordenada(int x, int y) {

		this.x = x;
		this.y = y;
		pos = 0;

	}

	public coordenada(int x, int y, int pos) {

		this.x = x;
		this.y = y;
		this.pos = pos;

	}

}