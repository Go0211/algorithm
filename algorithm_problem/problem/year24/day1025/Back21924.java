package problem.year24.day1025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back21924 {
	static int[] parant;
	
	static class Edge {
		int x, y, e;
		Edge(int x, int y, int e) {
			this.x = x;
			this.y = y;
			this.e = e;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());
		long answer = 0;
		Set<Integer> sets = new HashSet<>();
		parant  = new int[nodeCount];
		for (int i = 1; i < nodeCount; i++) {
			parant[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((edge1, edge2) -> edge1.e -edge2.e);
		for (int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1; 
			int e = Integer.parseInt(st.nextToken());
			pq.add(new Edge(x, y, e));
			answer += e;
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(find(parant[edge.x]) != find(parant[edge.y])) {
				union(edge.x, edge.y);
				answer -= edge.e;
			}
		}
		
		for (int i = 0; i < nodeCount; i++) {
			int a = find(i);
			sets.add(a);
		}
//		System.out.println(Arrays.toString(parant));
		if(sets.size() == 1) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}
	static void union(int x, int y) {
		int px = find(parant[x]);
		int py = find(parant[y]);
		
		if(px != py) {
			parant[px] = py;
		}
	}
	
	static int find(int idx) {
		if(idx == parant[idx]) {
			return idx;
		}
		return parant[idx] = find(parant[idx]);
	}
}

