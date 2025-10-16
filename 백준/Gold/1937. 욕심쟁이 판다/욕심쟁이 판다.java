import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp, dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                answer = Math.max(dfs(arr, i, j, N), answer);
            }
        }

        System.out.println(answer);
    }

    static int dfs(int[][] arr, int y, int x, int N) {
        if(dp[y][x] != 0) {
            return dp[y][x];
        }

        int count = 0;

        for(int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if(ny >= 0 && ny < N && nx >= 0 && nx < N
                    && arr[y][x] < arr[ny][nx]) {
                dp[y][x] = Math.max(dfs(arr, ny, nx, N) + 1, dp[y][x]);
                count++;
            }
        }

        if (count == 0) {
            return 1;
        }

        return dp[y][x];
    }
}