package problem.year24.day1127;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back15439 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		
		System.out.println(a * a - a);
	}
}
