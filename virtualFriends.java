
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
import java.util.Vector;

public class virtualFriends {

	public static void main(String[] args) {

		Scanner lector = new Scanner(System.in);

		int nTests = lector.nextInt();

		for (int i = 0; i < nTests; i++) {
			int F = lector.nextInt();

		UnionFind uf=new UnionFind(F*2);
			HashMap<String,Integer> hm=new HashMap<String,Integer>();
			int contAgregados=0;
			for (int j = 0; j < F; j++) {
				String f1 = lector.next();
				String f2 = lector.next();

				if(!hm.containsKey(f1)){
					hm.put(f1,contAgregados);
					       contAgregados++;
				}
				if(!hm.containsKey(f2)){
						hm.put(f2,contAgregados);
					       contAgregados++;
				}
				
				uf.unionSet(hm.get(f1),hm.get(f2));
				uf.unionSet(hm.get(f2),hm.get(f1));
				System.out.println(uf.sizeOfSet(hm.get(f1)));

			}
		}

	}

}

// Union-Find Disjoint Sets Library written in OOP manner, using both path
// compression and union by rank heuristics
class UnionFind { // OOP style
	private Vector<Integer> p, rank, setSize;
	private int numSets;

	public UnionFind(int N) {
		p = new Vector<Integer>(N);
		rank = new Vector<Integer>(N);
		setSize = new Vector<Integer>(N);
		numSets = N;
		for (int i = 0; i < N; i++) {
			p.add(i);
			rank.add(0);
			setSize.add(1);
		}
	}

	public int findSet(int i) {
		if (p.get(i) == i)
			return i;
		else {
			int ret = findSet(p.get(i));
			p.set(i, ret);
			return ret;
		}
	}

	public Boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}

	public void unionSet(int i, int j) {
		if (!isSameSet(i, j)) {
			numSets--;
			int x = findSet(i), y = findSet(j);
			// rank is used to keep the tree short
			if (rank.get(x) > rank.get(y)) {
				p.set(y, x);
				setSize.set(x, setSize.get(x) + setSize.get(y));
			} else {
				p.set(x, y);
				setSize.set(y, setSize.get(y) + setSize.get(x));
				if (rank.get(x) == rank.get(y))
					rank.set(y, rank.get(y) + 1);
			}
		}
	}

	public int numDisjointSets() {
		return numSets;
	}

	public int sizeOfSet(int i) {
		return setSize.get(findSet(i));
	}
}
