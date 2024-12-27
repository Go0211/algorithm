package problem.day1114;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11660 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int seq = Integer.parseInt(st.nextToken());
		
		int[][] maps = new int[N][N];
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(i == 0 && j == 0) {
					dp[i][j] = a;
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][N - 1] + a;
				} else {
					dp[i][j] = dp[i][j - 1] + a;
				}
				maps[i][j] = a;
			}
		}
		
		for (int z = 0; z < seq; z++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int startY = Integer.parseInt(st.nextToken()) - 1;
			int startX = Integer.parseInt(st.nextToken()) - 1;
			int endY = Integer.parseInt(st.nextToken()) - 1;
			int endX = Integer.parseInt(st.nextToken()) - 1;
			
			for (int i = startY; i < endY + 1; i++) {
				answer += dp[i][endX] - dp[i][startX] + maps[i][startX];
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}
