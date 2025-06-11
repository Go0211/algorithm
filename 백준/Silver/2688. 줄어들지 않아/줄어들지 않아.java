import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int seq = Integer.parseInt(br.readLine());
        long[][] dp = new long[64][11];
        
        Arrays.fill(dp[0], 1);
        dp[0][10] = 10;
        
        for(int i = 1; i < 64; i++) {
            long total = dp[i - 1][10];
            dp[i][0] = dp[i - 1][10];
            
            for(int j = 1; j < 10; j++) {
                long value = dp[i][j - 1] - dp[i - 1][j - 1];
                dp[i][j] = value;
                total += value;
            }
            
            dp[i][10] = total;
        }
        
        for(int i = 0; i < seq; i++) {
            sb.append(dp[Integer.parseInt(br.readLine()) - 1][10])
                .append("\n");
        }
        
        System.out.println(sb);
    }
}
