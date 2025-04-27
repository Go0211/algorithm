import java.util.*;
import java.io.*;

public class Main {
    static int[][] dirs = 
        {
            {1, 0},{1, 1},{0, 1},
            {-1, 1},{-1, 0},{-1, -1},
            {0, -1},{1, -1}
        };
    
    static String answer;
    public static void main(String[] args) throws Exception {
        answer = "Impossible";
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[][] map = new int[len][len];
        List<int[]> stones = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < len; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 2) {
                    stones.add(new int[]{i, j});
                }
            }
        }
        
        for(int[] ints : stones) {
            if(stones.size() == 1) {
                answer = "Possible";
                break;
            }
            if(answer.equals("Possible")) {
                break;
            }
            
            dfs(map, ints[0], ints[1], len, stones.size() - 1);
        }
        
        System.out.println(answer);
    }
    
    static void dfs(int[][] map, int y, int x, int len, int move) {
        if(move == 0) {
            answer = "Possible";
            return;
        }
        
        for(int[] dir : dirs) {
            if(answer.equals("Possible")) {
                return;
            }
            
            int ny = y + dir[0];
            int nx = x + dir[1];
            int nny = ny + dir[0];
            int nnx = nx + dir[1];
            
            if(map[ny][nx] == 2 && map[nny][nnx] == 0) {
                map[ny][nx] = 0;
                dfs(map, nny, nnx, len, move - 1);
                map[ny][nx] = 2;
            }  
        }
    }
}