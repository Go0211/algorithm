package problem.year24.day1121;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back2747 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[46];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i < 46; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		
		System.out.println(dp[Integer.parseInt(br.readLine())]);
	}
}

