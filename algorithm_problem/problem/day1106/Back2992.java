package problem.day1106;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Back2992 {
	static Set<Integer> sets;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		sets = new HashSet<>();
		int num = Integer.parseInt(str);
		int min = Integer.MAX_VALUE;
		
		perm(str, new boolean[str.length()], "");
		
		for (int i : sets) {
			if(i > num) {
				min = Math.min(min, i);
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}

	private static void perm(String str, boolean[] v, String s) {
		if(s.length() == str.length()) {
			sets.add(Integer.parseInt(s));
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if(!v[i]) {
				v[i] = true;
				perm(str, v, s + str.charAt(i));
				v[i] = false;
			}
		}
	}
}
