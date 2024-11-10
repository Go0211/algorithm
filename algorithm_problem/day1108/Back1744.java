package day1108;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1744 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((x, y) -> y - x);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		int seq = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < seq; i++) {
			int inputData = Integer.parseInt(br.readLine());
			if(inputData > 0) {
				pq1.add(inputData);
			} else {
				pq2.add(inputData);
			}
		}
		
		while(!pq1.isEmpty()) {
			int value = pq1.poll();

			if(!pq1.isEmpty()) {
				int a = pq1.peek();
				if(a > 1) {
					answer += pq1.poll() * value;
				} else {
					answer += value;
				}
			} else {
				answer += value;
			}
		}
	
		while(!pq2.isEmpty()) {
			int value = pq2.poll();
	
			if(!pq2.isEmpty()) {
				answer += pq2.poll() * value;
			} else {
				answer += value;
			}
		}
		
		System.out.println(answer);
	}
}
