import java.io.*;
import java.util.*;

public class PopularVote {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner lect = new Scanner(System.in);

		int n = lect.nextInt();

		for (int i = 0; i < n; i++) {

			int nAct = lect.nextInt();
			vote[] arrVotes = new vote[nAct];
			long totalVotes = 0;
			for (int j = 0; j < nAct; j++) {

				int numVotes = lect.nextInt();
				vote vAct = new vote(j + 1, numVotes);
				arrVotes[j] = vAct;
				totalVotes += numVotes;
			}
			Arrays.sort(arrVotes);

		if(arrVotes[nAct-1].numVotes==arrVotes[nAct-2].numVotes)
			System.out.println("no winner");
		else if((double)arrVotes[nAct-1].numVotes/totalVotes>0.5) 
			System.out.println("majority winner "+arrVotes[nAct-1].pos);			
		else
			System.out.println("minority winner "+arrVotes[nAct-1].pos);
		}
	}

}

class vote implements Comparable<vote> {

	int pos;
	int numVotes;

	vote(int pos, int numVotes) {
		this.pos = pos;
		this.numVotes = numVotes;
	}

	@Override
	public int compareTo(vote v) {
		// TODO Auto-generated method stub
		return this.numVotes - v.numVotes;
	}

}
