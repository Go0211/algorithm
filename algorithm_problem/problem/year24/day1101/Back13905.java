package problem.year24.day1101;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back13905 {
	static int[] parent;
	static class Node{
		int start, end, value;
		
		Node(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		
		public String toString() {
			return "start : " + start + " | end : " + end + " | value : " + value;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<List<Node>> list = new ArrayList<>();
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int nodeCount = Integer.parseInt(st.nextToken());
		int seq = Integer.parseInt(st.nextToken());
		for (int i = 0; i < nodeCount + 1; i++) {
			list.add(new ArrayList<>());
		}

		parent = new int[nodeCount + 1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int startIdx = Integer.parseInt(st.nextToken());
		int endIdx = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.value - x.value);
		for (int i = 0; i < seq; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sIdx = Integer.parseInt(st.nextToken());
			int eIdx = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			pq.add(new Node(sIdx, eIdx, value));
		}

		while(!pq.isEmpty()) {
			Node node = pq.poll();
//			System.out.println(node);
			if(find(node.start) != find(node.end)) {
				union(node.start, node.end);
				answer = node.value;
			}
			
			if(find(startIdx) == find(endIdx)) {
				break;
			}
//			System.out.println(Arrays.toString(parent));
		}
		
		System.out.println(find(startIdx) == find(endIdx) ? answer : 0);
	}

	private static void union(int start, int end) {
		int aP = find(start);
		int bP = find(end);
		
		if (aP != bP) {
			parent[aP] = parent[bP];
		}
	}

	private static int find(int start) {
		if(start == parent[start]) {
			return start;
		}
		
		return parent[start] = find(parent[start]);
	}
}
