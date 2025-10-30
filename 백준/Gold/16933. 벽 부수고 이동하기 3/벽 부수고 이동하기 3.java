import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    static class Node {
        int y, x, k, d, count;

        Node(int y, int x, int k, int d, int count) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.d = d;
            this.count = count;
        }

        public String toString() {
            return "y:"+y+" x:"+x+" k:"+k+" d:"+d +" count:" + count;
        }
    }

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

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, K, 1, 0));
        boolean[][][][] v = new boolean[R][C][2][K + 1];
        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int py = node.y;
            int px = node.x;
            int pk = node.k;
            int pd = node.d;
            int count = node.count;

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
                        queue.offer(new Node(ny, nx, pk, (pd + 1) % 2, count + 1));
                        v[ny][nx][(pd + 1) % 2][pk] = true;
                    }
                    // 낮 + 벽0
                    else if(!sample[ny][nx] && pk > 0 && pd == 1 && !v[ny][nx][0][pk - 1]) {
                        queue.offer(new Node(ny, nx, pk - 1, 0, count + 1));
                        v[ny][nx][0][pk - 1] = true;
                    }
                    // 밤 + 벽0
                    else if(!sample[ny][nx] && pk > 0 && pd == 0) {
                        queue.offer(new Node(py, px, pk, 1, count + 1));
                        v[py][px][pd][pk] = true;
                    }
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer + 1);
    }
}