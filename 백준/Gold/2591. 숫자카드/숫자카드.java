import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        
        for(int i = 1; i < len + 1; i++) {
            char c = str.charAt(i - 1);
            if(c != '0') {
                dp[i] += dp[i - 1];
            }
            
            if(i >= 2) {
                int num = 
                    Integer.parseInt(str.substring(i - 2, i));
                
                if(10 <= num && num <= 34) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        
        System.out.println(dp[len]);
    }
}