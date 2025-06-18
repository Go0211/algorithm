import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        long[][] dp = new long[seq - 1][seq];
        int[] lineDepths = new int[seq - 1];
        int[] oilCosts = new int[seq];
        
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        for(int i = 0; i < seq - 1; i++) {
            lineDepths[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < seq; i++) {
            oilCosts[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.fill(dp[0], oilCosts[0] * lineDepths[0]);
        
        for(int i = 1; i < seq - 1; i++) {
            long mins = Long.MAX_VALUE;
            for(int j = 0; j < seq; j++) {
                if(i < j) {
                    dp[i][j] = mins;
                } else {
                    long value = dp[i - 1][j] + oilCosts[j] * lineDepths[i];
                    
                    dp[i][j] = value;
                    mins = Math.min(value, mins);
                }
            }
        }
        
        System.out.println(dp[seq - 2][seq - 1]);
    }
}