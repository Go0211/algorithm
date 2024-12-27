package problem.day1027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back16236 {
    static int N;
    static int[][] maps, dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    static class Shark {
        int y, x, eat, rank, moveCount;
        Shark(int y, int x, int eat, int rank, int moveCount) {
            this.y = y;
            this.x = x;
            this.eat = eat;
            this.rank = rank;
            this.moveCount = moveCount;
        }

        boolean findSmallShark() {
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{y, x, 0});
            boolean[][] v = new boolean[N][N];
            v[y][x] = true;
            int max = Integer.MAX_VALUE;
            PriorityQueue<int[]> pq = new PriorityQueue<>(this::sorting);

            while(!q.isEmpty()) {
                int[] arr = q.poll();
                int by = arr[0];
                int bx = arr[1];
                int count = arr[2];

                if(maps[by][bx] != 0 && maps[by][bx] < rank) {
                    pq.add(new int[]{by, bx, count});
                    continue;
                }

                for (int[] dir : dirs) {
                    int ny = dir[0] + by;
                    int nx = dir[1] + bx;

                    if(ny >= 0 && ny < N && nx >= 0 && nx < N && !v[ny][nx] && maps[ny][nx] <= rank) {
                        q.offer(new int[]{ny, nx, count + 1});
                        v[ny][nx] = true;
                    }
                }
            }

            if (!pq.isEmpty()) {
                int[] idx = pq.poll();
                eatSharkAndRankUp(idx[0], idx[1], idx[2]);
                return true;
            } else {
                return false;
            }
        }

        void eatSharkAndRankUp(int by, int bx, int count) {
            maps[y][x] = 0;
            maps[by][bx] = 9;
            y = by;
            x = bx;
            moveCount += count;

            if (eat + 1 == rank) {
                eat = 0;
                rank += rank > 6 ? 0 : 1;
            } else {
                eat++;
            }
        }

        public int sorting(int[] x, int[] y) {
            return x[2] - y[2] != 0 ? x[2] - y[2]
                    : x[0] - y[0] != 0 ? x[0] - y[0] : x[1] - y[1] ;
//            return Integer.compare(x[2], y[2]) != 0 ? Integer.compare(x[2], y[2])
//                   : Integer.compare(x[0], y[0]) != 0 ? Integer.compare(x[0], y[0])
//                    : Integer.compare(x[1], y[1]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        Shark shark = null;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                maps[i][j] = value;
                if (value == 9) {
                    shark = new Shark(i, j, 0, 2, 0);
                }
            }
        }

        while (true) {
            if (!shark.findSmallShark()) {
                break;
            }
        }

        System.out.println(shark.moveCount);
    }
}
