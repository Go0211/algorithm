package day1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back14534 {
	static StringBuffer sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int seq = Integer.parseInt(br.readLine());
		sb = new StringBuffer();
		
		for (int i = 0; i < seq; i++) {
			String[] arr = br.readLine().split("");
			
			sb.append("Case # "+(i+1)+":").append("\n");
			perm(arr, new String[arr.length], 0, arr.length, new boolean[arr.length]);
		}
		
		System.out.println(sb);
	}
	
	public static void perm(String[] arr, String[] saveArr, int depth, int limit, boolean[] v) {
		if(depth == limit) {
			String str = "";
			for (String s : saveArr) {
				str += s;
			}
			
			sb.append(str).append("\n");
			return;
		}
		
		for (int i = 0; i < limit; i++) {
			if (!v[i]) {
				saveArr[depth] = arr[i];
				v[i] = true;
				perm(arr, saveArr, depth + 1, limit, v);
				v[i] = false;
			}
		}
	}
}
