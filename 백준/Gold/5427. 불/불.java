import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        next:
        for(int z = 0; z < N; z++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int answer = Integer.MAX_VALUE;

            char[][] arr = new char[R][C];
            for(int i = 0; i < R; i++) {
                String str = br.readLine();
                for(int j = 0; j < C; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            int[][] v = new int[R][C];
            for (int[] vv : v) {
                Arrays.fill(vv, Integer.MAX_VALUE);
            }

            for(int i = 0; i < R; i++) {
                if (arr[i][0] == '.') {
                    answer = Math.min(bfs(arr, v, i, 0, R, C), answer);
//                    System.out.println(i + " " + 0 + " " + answer);
                }
                if (arr[i][C - 1] == '.') {
                    answer = Math.min(bfs(arr, v, i, C-1, R, C), answer);
//                    System.out.println(i + " " + (C - 1) + " " + answer);
                }
                if (arr[i][0] == '@' || arr[i][C - 1] == '@') {
                    sb.append(1).append("\n");
                    continue next;
                }
            }
            for(int i = 0; i < C; i++) {
                if (arr[0][i] == '.') {
                    answer = Math.min(bfs(arr, v, 0, i, R, C), answer);
//                    System.out.println(0 + " " + i + " " + answer);
                }
                if (arr[R - 1][i] == '.') {
                    answer = Math.min(bfs(arr, v, R - 1, i, R, C), answer);
//                    System.out.println((R - 1) + " " + i + " " + answer);
                }
                if (arr[0][i] == '@' || arr[R - 1][i] == '@') {
                    sb.append(1).append("\n");
                    continue next;
                }
            }

            sb.append(answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer)
                    .append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(char[][] arr, int[][] v, int y, int x, int R, int C) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x, 1});
        boolean[][] vv = new boolean[R][C];
        int breakCount = Integer.MAX_VALUE;
        int firstFind = '-';

        while(!queue.isEmpty()) {
            int[] ints = queue.poll();

            int preY = ints[0];
            int preX = ints[1];
            int count = ints[2];

            if(breakCount == count) {
                return firstFind == '@' ? breakCount : Integer.MAX_VALUE;
            }

            for(int[] dir : dirs) {
                int ny = dir[0] + preY;
                int nx = dir[1] + preX;

                if(ny >= 0 && ny < R && nx >= 0 && nx < C
                        && !vv[ny][nx] && arr[ny][nx] != '#') {
                    queue.offer(new int[]{ny, nx, count + 1});

                    if(arr[ny][nx] == '.') {
                        vv[ny][nx] = true;
                    } else if(arr[ny][nx] == '*') {
                        breakCount = count + 1;
                        firstFind = '*';
                    } else if(arr[ny][nx] == '@' && firstFind != '*'){
                        breakCount = count + 1;
                        firstFind = '@';
                    }
                }
            }
        }

        return firstFind != '@' ? Integer.MAX_VALUE : breakCount;
    }
}