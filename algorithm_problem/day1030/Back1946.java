package day1030;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1946 {
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "x : " + x  + "| y : " + y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int freq = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < freq; i++) {
			int seq = Integer.parseInt(br.readLine());
			int count = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.x - y.x);
			
			for (int j = 0; j < seq; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			int min = Integer.MAX_VALUE;
			while (!pq.isEmpty() && min != 1) {
				int num = pq.poll().y;
				if (min > num) {
					min = num;
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}
