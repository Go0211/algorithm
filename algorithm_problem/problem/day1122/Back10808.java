package problem.day1122;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back10808 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);
	}
}
