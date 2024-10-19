package day1019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back2156 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] dp = new int[size];
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(size >= 1) {
            dp[0] = arr[0];
        }
        if(size >= 2) {
            dp[1] = dp[0] + arr[1];
        }
        if(size >= 3) {
            dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
        }

        for (int i = 3; i < size; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[size - 1]);
    }
}
