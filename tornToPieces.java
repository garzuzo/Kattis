import java.util.*;
import java.io.*;

public class tornToPieces {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(lector.readLine());
		graph g = new graph(n);
		for (int i = 0; i < n; i++) {

			String[] arr = lector.readLine().split(" ");
			String source = arr[0];
			g.add(source);

			for (int j = 1; j < arr.length; j++) {
				String vAct = arr[j];
				g.add(vAct);
				g.addEdge(source, vAct);
			}
		}

		String[] ret = lector.readLine().split(" ");
		String s = ret[0];
		String d = ret[1];
		if (g.nameToPos.containsKey(s) && g.nameToPos.containsKey(d)) {
			ArrayList<String> list = g.bfs(s, d);

			if (list != null) {
				Set<String> retorno = new HashSet<String>();
				ArrayList<String> salida = new ArrayList<String>();
				String act = d;
				salida.add(act);
				while (!act.equals(s)) {
					act = g.backtrack.get(act);
					salida.add(act);

				}
				for (int i = salida.size()-1; i >=0; i--) {
					System.out.print(salida.get(i)+" ");
				}
				System.out.println();
				

			} else
				System.out.println("no route found");

		} else
			System.out.println("no route found");

	}
}

class graph {

	HashMap<String, vertex> nameToPos;
	HashMap<String, String> backtrack;

	public graph(int n) {

		nameToPos = new HashMap<String, vertex>();
		backtrack = new HashMap<String, String>();
	}

	public ArrayList<String> dfs(String source, String dest) {

		vertex s = nameToPos.get(source);
		boolean findDest = false;
		Stack<vertex> stack = new Stack<vertex>();
		ArrayList<String> ret = new ArrayList<String>();

		stack.push(s);

		while (!stack.isEmpty()) {

			vertex act = stack.pop();

			if (!act.color.equals(vertex.black)) {

				act.setColor(vertex.black);

				ret.add(act.val);
				if (act.val.equals(dest)) {
					findDest = true;
					break;
				}
				// Iterator<vertex> it=act.adjVert.iterator();

				Stack<vertex> stackTemp = new Stack<vertex>();

				for (vertex v : act.adjVert) {

					if (!v.color.equals(vertex.black)) {

						stackTemp.push(v);
						v.setColor(vertex.gray);
					}
				}
				while (!stackTemp.isEmpty())
					stack.push(stackTemp.pop());
			}

		}
		if (findDest)
			return ret;
		else
			return null;
	}

	public ArrayList<String> bfs(String source, String dest) {

		vertex s = nameToPos.get(source);
		boolean findDest = false;
		Queue<vertex> queue = new ArrayDeque<vertex>();
		ArrayList<String> ret = new ArrayList<String>();

		queue.offer(s);
		backtrack.put(source, source);
		while (!queue.isEmpty()) {

			vertex act = queue.poll();

			if (!act.color.equals(vertex.black)) {
				ret.add(act.val);
				act.setColor(vertex.black);

				if (act.val.equals(dest)) {
					findDest = true;
					if (!backtrack.containsKey(act.val))
						backtrack.put(act.val, act.val);
					break;
				}

				for (vertex v : act.adjVert) {

					if (!v.color.equals(vertex.black)) {

						if (!backtrack.containsKey(v.val))
							backtrack.put(v.val, act.val);
						queue.offer(v);

						v.setColor(vertex.gray);
					}
				}

			}

		}
		// System.out.println("-----fin");
		if (findDest)
			return ret;
		else
			return null;
	}

	public void add(String v) {

		if (!nameToPos.containsKey(v)) {
			vertex act = new vertex(v);
			nameToPos.put(v, act);
		}
	}

	public void addEdge(String v1, String v2) {

		vertex pos1 = nameToPos.get(v1);
		vertex pos2 = nameToPos.get(v2);

		pos1.adjVert.add(pos2);
		pos2.adjVert.add(pos1);

	}

}

class vertex {

	HashSet<vertex> adjVert;

	String val;
	String color;

	public void setColor(String color) {
		this.color = color;
	}

	static final String black = "b";
	static final String gray = "g";

	public vertex(String val) {

		this.val = val;
		adjVert = new HashSet<vertex>();
		color = "";
	}

}
