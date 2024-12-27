package problem.day1025;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.*;

public class Back1715 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int seq = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long answer = 0;
		
		for (int i = 0; i < seq; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		while (pq.size() != 1) {
			long num = pq.poll() + pq.poll();
			answer += num;
			pq.add(num);
		}
		
		System.out.println(answer == 0 ? 0 : answer);
	}
}
