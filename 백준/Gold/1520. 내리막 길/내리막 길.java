import java.util.*;
import java.io.*;

public class Main {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[R][C];

        for(int[] a : dp) {
            Arrays.fill(a, -1);
        }

        System.out.println(dfs(arr, 0, 0, R, C, dp));
    }

    static int dfs(int[][] arr, int y, int x, int R, int C, int[][] dp) {
        if(y == R - 1 && x == C - 1) {
            return 1;
        }
        if(dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for(int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if(ny >= 0 && ny < R && nx >= 0 && nx < C
                    && arr[y][x] > arr[ny][nx]) {
                dp[y][x] += dfs(arr, ny, nx, R, C, dp);
            }
        }

        return dp[y][x];
    }
}