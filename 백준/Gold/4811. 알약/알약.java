import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[31];
        
        while(true) {
            int num = Integer.parseInt(br.readLine());
            
            if(num == 0) break;
            
            sb.append(catalan(num, dp)).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static long catalan(int n, long[] dp) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != 0) return dp[n];

        for (int i = 0; i < n; i++) {
            dp[n] += catalan(i, dp) * catalan(n - 1 - i, dp);
        }
        return dp[n];
    }
}