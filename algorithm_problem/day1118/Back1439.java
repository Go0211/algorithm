package day1118;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back1439 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int one = 0;
		int zero = 0;
		
		char beforeC = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (beforeC != c) {
				if (beforeC == '0') {
					one++;
				} else {
					zero++;
				}
				beforeC = c;
			}
		}
		
		System.out.println(Math.max(one, zero));
	}
}
