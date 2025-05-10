import java.util.*;
import java.io.*;

public class Main {
    static int answer = -1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = 
            new StringTokenizer(br.readLine());
        int seq = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int[] arr = new int[seq];
        boolean[][] dp = new boolean[seq + 1][limit + 1];
        dp[0][start] = true;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < seq; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < seq; i++) {
            for(int j = 0; j < limit + 1; j++) {
                if(dp[i][j]) {
                    if(j + arr[i] <= limit) {
                        dp[i + 1][j + arr[i]] = true;
                    }
                    if(j - arr[i] >= 0) {
                        dp[i + 1][j - arr[i]] = true;
                    }
                }
            }
        }
        
        int answer = -1;
        for(int j = limit; j >= 0; j--) {
            if(dp[seq][j]) {
                answer = j;
                break;
            }
        }
        
        System.out.println(answer);
    }
}