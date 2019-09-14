package ics2105;
import java.util.*;
public class QuickFindUF {
	private int[] id;
	
	public QuickFindUF(int N) {
		id=new int[N];
		for(int i=0;i<N;i++) {
			id[i]=i;
		}
	}
	
	public boolean connected (int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p,int q) {
		int pid = id[p];
		int qid = id[q];
		for(int i=0;i<id.length;i++) {
			if(id[i] == pid) {
				id[i]=qid;
			}
		}
	}
	public static void main(String[] args) {
		Scanner StdIn = new Scanner (System.in);
		int N = StdIn.nextInt();
		QuickFindUF uf = new QuickFindUF(N);
		while(!StdIn.isEmpty()) {
			int p = StdIn.nextInt();
			int q = StdIn.nextInt();
			if(!uf.connected(p,q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
		}


	}

}
