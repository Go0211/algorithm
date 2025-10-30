import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] sample = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                sample[i][j] = (str.charAt(j) == '0');
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, K, 1, 0});
        boolean[][][][] v = new boolean[R][C][2][K + 1];
        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int py = node[0];
            int px = node[1];
            int pk = node[2];
            int pd = node[3];
            int count = node[4];

            if(py == R - 1 && px == C - 1) {
                answer = count;
                break;
            }

            for(int[] dir : dirs) {
                int ny = dir[0] + py;
                int nx = dir[1] + px;

                if(ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    // 낮 + 벽X or 밤 + 벽X
                    if(sample[ny][nx] && !v[ny][nx][(pd + 1) % 2][pk]) {
                        queue.offer(new int[]{ny, nx, pk, (pd + 1) % 2, count + 1});
                        v[ny][nx][(pd + 1) % 2][pk] = true;
                    }
                    // 낮 + 벽0
                    else if(!sample[ny][nx] && pk > 0 && pd == 1 && !v[ny][nx][0][pk - 1]) {
                        queue.offer(new int[]{ny, nx, pk - 1, 0, count + 1});
                        v[ny][nx][0][pk - 1] = true;
                    }
                    // 밤 + 벽0
                    else if(!sample[ny][nx] && pk > 0 && pd == 0) {
                        queue.offer(new int[]{py, px, pk, 1, count + 1});
                        v[py][px][pd][pk] = true;
                    }
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer + 1);
    }
}