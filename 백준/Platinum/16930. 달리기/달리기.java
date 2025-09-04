import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] gym = new char[N][];
        for(int i = 0; i < N; i++) {
            gym[i] = br.readLine().toCharArray();
        }
        st = new StringTokenizer(br.readLine(), " ");
        System.out.println(
                bfs(gym,
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1,
                        N, M, K
                )
        );
    }

    static int bfs(char[][] gym,
                   int startY, int startX,
                   int endY, int endX,
                   int N, int M, int K) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] v = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(v[i], -1);
        }
        queue.offer(new int[]{startY, startX});
        v[startY][startX] = 0;

        while(!queue.isEmpty()) {
            int[] ints = queue.poll();
            int preY = ints[0];
            int preX = ints[1];
            int count = v[preY][preX];

            if(preY == endY && preX == endX) {
                return count;
            }

            for(int[] dir : dirs) {
                for(int i = 1; i <= K; i++) {
                    int nextY = preY + dir[0] * i;
                    int nextX = preX + dir[1] * i;

                    if(nextY >= 0 && nextY < N
                            && nextX >= 0 && nextX < M) {
                        if (gym[nextY][nextX] == '#') {
                            break;
                        }

                        if (v[nextY][nextX] != -1 && v[nextY][nextX] < count + 1) {
                            break;
                        }
                        if (v[nextY][nextX] != -1 && v[nextY][nextX] == count + 1) {
                            continue;
                        }

                        queue.offer(new int[]{nextY, nextX});
                        v[nextY][nextX] = count + 1;
                    }
                }
            }
        }

        return -1;
    }
}