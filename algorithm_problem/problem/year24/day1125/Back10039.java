package problem.year24.day1125;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back10039 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(br.readLine());
			total += num >= 40 ? num : 40;
		}
		
		System.out.println(total/5);
	}
}
