package day1112;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Back9742 {
	static char[] ca;
	static int count, idx;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		
		while ((str = br.readLine()) != null && !str.isEmpty()) {
			StringTokenizer st = new StringTokenizer(str, " ");
			String baseStr = st.nextToken();
			String[] arr = baseStr.split("");
			ca = new char[arr.length]; count = 0;
			idx = Integer.parseInt(st.nextToken());
			
//			System.out.println(list);
			if (checkIdx(baseStr.length())) {
				sb.append(String.format("%s %d = %s", baseStr, idx, "No permutation")).append("\n");
			} else {
				String answer = "";
				perm(arr, 0, new boolean[str.length()]);
				for(char c : ca) {answer += c;}
				sb.append(String.format("%s %d = %s", baseStr, idx, answer)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	private static boolean checkIdx(int length) {
		int max = 1;
		for (int i = length; i > 1; i--) {
			max *= i;
		}
		
		return max < idx;
	}

	private static void perm(String[] arr, int index, boolean[] v) {
		if(index == arr.length) {
			count++;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!v[i] && count < idx) {
				v[i] = true;
				ca[index] = arr[i].charAt(0);
				perm(arr, index + 1, v);
				v[i] = false;
			}
		}
	}
}
