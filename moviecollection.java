import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class moviecollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);
		int numTests = lector.nextInt();
		lector.nextLine();
		while (numTests > 0) {

			DoubleLinkedList list = new DoubleLinkedList();

			int numMovies = lector.nextInt();
			int numRequests = lector.nextInt();
			lector.nextLine();
			for (int i = 1; i <= numMovies; i++) {
				list.add(i + "");
			}
			String answerAct = "";
			for (int i = 0; i < numRequests; i++) {
				int reqAct = lector.nextInt();

				if (i + 1 < numRequests)
					answerAct += list.remove(reqAct + "") + " ";
				else
					answerAct += list.remove(reqAct + "");

				list.addFirst(reqAct + "");

			}

			System.out.println(answerAct);
			lector.nextLine();

			numTests--;
		}

	}

}

class DoubleLinkedList {

	int tam;

	Node first;
	Node last;

	public DoubleLinkedList() {
		tam = 0;

		first = null;
		last = null;
	}

	public void add(String n) {
		Node actual = new Node(n);
		if (first == null) {

			first = actual;
			tam++;
		} else {
			Node act = first;
			while (act.getNext() != null) {
				act = act.getNext();
			}
			last = actual;
			act.setNext(actual);
			actual.setPrev(act);
			tam++;
		}

	}

	public void addFirst(String n) {

		
		if(!first.getValue().equals(n)){
			Node actual = new Node(n,null,first);
		first.setPrev(actual);
		first = actual;
		tam++;
		}
		
	}

	public boolean verificarUltimo(String n){
	
		if(last!=null && n.equals(last.getValue())){
		return true;	
		}
		return false;
	}
	public int remove(String n) {
		if(verificarUltimo(n)){
			last = last.getPrev();
					last.setNext(null);
					tam--;
			return tam;
		}
		int pos = 0;
		int pos1=tam-1;
		boolean f=false;
		boolean l=false;
		Node actual = first;
		Node actual1=last;
		while (true) {

			if (!actual.getValue().equals(n)) {
				pos++;
				actual = actual.getNext();
			}else{
			f=true;	
				
			}
			if(!f && !actual1.getValue().equals(n)){
				tam--;
				actual1=actual1.getPrev();
			}else{
				l=true;
			}
			if(f){
				 if (actual == last) {
					last = actual.getPrev();
					actual.getPrev().setNext(null);
					tam--;
				} else if(actual!=first){
					actual.getPrev().setNext(actual.getNext());
					actual.getNext().setPrev(actual.getPrev());
					tam--;
				}

				
				break;
			}else if(l){
				 if (actual1 == last) {
					last = actual.getPrev();
					actual.getPrev().setNext(null);
					tam--;
				} else if(actual1!=first){
					actual1.getPrev().setNext(actual1.getNext());
					actual1.getNext().setPrev(actual1.getPrev());
					tam--;
				}

				
				break;
			}
			 
			}
		if(f){
		return pos;
		}else{
		return pos1;	
		}

		}

		
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	class Node {

		String value;

		Node next;
		Node prev;

		public Node(String value) {
			this.value = value;
			next = null;
			prev = null;
		}
		public Node(String value, Node n1, Node n2) {
			this.value = value;
			
			prev = n1;
			next = n2;
		}
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

	}

}
