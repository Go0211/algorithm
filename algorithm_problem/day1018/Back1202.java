import java.util.*;
import java.io.*;

class Back1202 {
	static class Jewel {
		int M, V;
		public Jewel(int M, int V) {
			this.M = M;
			this.V = V;
		}
		
		public String toString() {
			return "M : " + M + " | V : " + V;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<Jewel> jewelPQ = new PriorityQueue<>((x, y) -> x.M - y.M);
		PriorityQueue<Integer> bagPQ = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
		long answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			jewelPQ.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < K; i++) {
			bagPQ.add(Integer.parseInt(br.readLine()));
		}
		
		PriorityQueue<Integer> maxJewelValuePQ = new PriorityQueue<>((x, y) -> y - x);
		while(!bagPQ.isEmpty()) {
			int limit = bagPQ.poll();
			
			while (!jewelPQ.isEmpty() && jewelPQ.peek().M <= limit) {
				maxJewelValuePQ.add(jewelPQ.poll().V);
			}
			
			if(!maxJewelValuePQ.isEmpty()) {
				answer += maxJewelValuePQ.poll();
			}
		}
		
		System.out.println(answer);
	}
}
