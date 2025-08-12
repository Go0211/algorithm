import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] arr = new char[row][col];
        int[][] v = new int[row][col];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int idx = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (v[i][j] == 0) {
                    bfs(arr, v, set, i, j, row, col, idx);
                } else {
                    answer += set.contains(v[i][j]) ? 1 : 0;
                }
                idx++;
            }
        }

        System.out.println(answer);
    }

    static void bfs(char[][] arr, int[][] v, Set<Integer> set, int i, int j, int row, int col, int idx) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int y = ints[0];
            int x = ints[1];
            char c = arr[y][x];
            v[y][x] = idx;

            switch (c) {
                case 'U':
                    if (y - 1 < 0 || set.contains(v[y - 1][x])) {
                        answer++;
                        set.add(idx);
                        return;
                    }
                    if (v[y - 1][x] != 0) {
                        return;
                    }
                    queue.offer(new int[]{y - 1, x});
                    break;
                case 'D':
                    if (y + 1 >= row || set.contains(v[y + 1][x])) {
                        answer++;
                        set.add(idx);
                        return;
                    }
                    if (v[y + 1][x] != 0) {
                        return;
                    }
                    queue.offer(new int[]{y + 1, x});
                    break;
                case 'L':
                    if (x - 1 < 0 || set.contains(v[y][x - 1])) {
                        answer++;
                        set.add(idx);
                        return;
                    }
                    if (v[y][x - 1] != 0) {
                        return;
                    }
                    queue.offer(new int[]{y, x - 1});
                    break;
                case 'R':
                    if (x + 1 >= col || set.contains(v[y][x + 1])) {
                        answer++;
                        set.add(idx);
                        return;
                    }
                    if (v[y][x + 1] != 0) {
                        return;
                    }
                    queue.offer(new int[]{y, x + 1});
                    break;
            }
        }
    }
}