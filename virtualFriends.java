
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class virtualFriends {

	public static void main(String[] args) {

		Scanner lector = new Scanner(System.in);

		int nTests = lector.nextInt();

		for (int i = 0; i < nTests; i++) {
			int F = lector.nextInt();

			GrafoLista<String> grafo = new GrafoLista<String>();
			for (int j = 0; j < F; j++) {
				String f1 = lector.next();
				String f2 = lector.next();

				grafo.agregar(f1);

				grafo.agregar(f2);

				grafo.conectar(f1, f2);

				int totalAmigos = grafo.recorridoBFS(f2);
				System.out.println(totalAmigos);

			}
		}

	}

}

class GrafoLista<V extends Comparable<V>> {

	private int size;

	private HashMap<V, Vertice> agregados;

	private static int MAX = Integer.MAX_VALUE;

	private TreeMap<Vertice<V>, TreeSet<Arista<V>>> treeMap;

	public GrafoLista() {
		size = 0;

		treeMap = new TreeMap<Vertice<V>, TreeSet<Arista<V>>>();
		agregados = new HashMap<V, Vertice>();
	}

	public boolean agregar(V v) {
		if (!agregados.containsKey(v)) {

			Vertice<V> nuevo = new Vertice(v);
			agregados.put(v, nuevo);
			return agregar(nuevo);
		} else
			return true;
	}

	private boolean agregar(Vertice<V> v) {
		if (!treeMap.containsKey(v)) {
			v.setPos(size);
			treeMap.put(v, new TreeSet<Arista<V>>());
			size++;
			return true;
		} else
			return false;
	}

	public boolean conectar(V v1, V v2) {

		Vertice<V> inicio = agregados.get(v1);
		Vertice<V> fin = agregados.get(v2);
		return conectar(inicio, fin);
	}

	public Vertice<V> buscar(V valor) {

		if (agregados.containsKey(valor)) {

			return agregados.get(valor);
		}
		return null;
	}

	private boolean conectar(Vertice<V> inicio, Vertice<V> fin) {

		if (treeMap.containsKey(inicio) && treeMap.containsKey(fin)) {
			Arista<V> aristTemp = new Arista<V>(inicio, fin);
			treeMap.get(inicio).add(aristTemp);
			Arista<V> aristTemp2 = new Arista<V>(fin, inicio);
			treeMap.get(fin).add(aristTemp2);
			return true;
		} else {
			return false;
		}

	}

	public int recorridoBFS(V source) {
		return recorridoBFS(agregados.get(source));
	}

	private int recorridoBFS(Vertice<V> source) {

		Queue<Vertice<V>> queue = new ArrayDeque<>();
		queue.add(source);
		HashSet<Vertice<V>> hs = new HashSet<Vertice<V>>();
		int cont = 0;
		while (!queue.isEmpty()) {
			Vertice<V> que = queue.poll();
			if (!hs.contains(que)) {

				hs.add(que);
				// contador
				cont++;
				Iterator<Arista<V>> it = treeMap.get(que).iterator();

				while (it.hasNext()) {
					Vertice<V> vertice = it.next().getVertex2();
					if (!hs.contains(vertice)) {
						queue.add(vertice);
					}
				}
			}
		}

		return cont;
	}

	public TreeMap<Vertice<V>, TreeSet<Arista<V>>> getTreeMap() {
		return treeMap;
	}

	public int size() {
		return size;
	}
}

class Vertice<T extends Comparable<T>> implements Comparable<Vertice<T>> {

	private T value;

	private int pos;

	public Vertice(T val) {
		value = val;

	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public int compareTo(Vertice<T> o) {
		return value.compareTo(o.getValue());
	}
}

class Arista<T extends Comparable<T>> implements Comparable<Arista<T>> {

	private Vertice<T> vertex1;

	private Vertice<T> vertex2;

	private double cost;

	public Arista(Vertice<T> vertex1, Vertice<T> vertex2, double cost) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.cost = cost;
	}

	public Arista(Vertice<T> vertex1, Vertice<T> vertex2) {
		cost = 0;
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	@Override
	public int compareTo(Arista<T> o) {

		if (vertex1.getValue().compareTo(vertex2.getValue()) > 0) {
			return 1;
		} else if (vertex1.getValue().compareTo(vertex2.getValue()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	public Vertice<T> getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertice<T> vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertice<T> getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertice<T> vertex2) {
		this.vertex2 = vertex2;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
