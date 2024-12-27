package problem.day1028;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.*;

public class Back6148 {
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int seq = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[seq];
		for (int i = 0; i < seq; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		comb(arr, 0, 0, limit, new boolean[seq]);
		
		System.out.println(answer);
	}

	private static void comb(int[] arr, int depth, int value, int limit, boolean[] v) {
		if (limit <= value) {
			answer = Math.min(value - limit, answer);
			return;
		}
		
		for (int i = depth; i < arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				comb(arr, i + 1, value + arr[i], limit, v);
				v[i] = false;
			}
		}
	}
}
