import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[][] arr = new char[6][6];
        for (int i = 0; i < 6; i++) {
            Arrays.fill(arr[i], '.');
        }

        arr[2][2] = arr[3][3] = 'W';
        arr[2][3] = arr[3][2] = 'B';

        for (int i = 0; i < len; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            char word = i % 2 == 0 ? 'B' : 'W';

            arr[y][x] = word;
            bfs(arr, y, x, word);
        }

        int White = 0;
        int Black = 0;

        for (char[] a : arr) {
            StringBuilder sb = new StringBuilder();

            for (char aa : a) {
                if (aa != 'W' && aa != 'B') {
                    sb.append(".");
                    continue;
                }

                if (aa == 'W') {
                    White++;
                } else {
                    Black++;
                }

                sb.append(aa);
            }

            System.out.println(sb);
        }

        System.out.println(White > Black ? "White" : "Black");
    }

    static void bfs(char[][] arr, int y, int x, char word) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            if (find(arr, y, x, i, word)) {
                queue.offer(new int[]{y, x, i});
            }
        }

        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int d = ints[2];
            int nextY = ints[0] + dirs[d][0];
            int nextX = ints[1] + dirs[d][1];

            if (nextY >= 0 && nextY < 6
                    && nextX >= 0 && nextX < 6
                    && arr[nextY][nextX] != word
                    && arr[nextY][nextX] != '.') {
                arr[nextY][nextX] = word;
                queue.offer(new int[]{nextY, nextX, d});
            }
        }
    }

    private static boolean find(char[][] arr, int y, int x, int i, char word) {
        int ny = y;
        int nx = x;

        while (true) {
            ny += dirs[i][0];
            nx += dirs[i][1];

            if (!(ny >= 0 && ny < 6 && nx >= 0 && nx < 6 && arr[ny][nx] != '.')) {
                return false;
            }

            if (arr[ny][nx] == word) {
                return true;
            }
        }
    }
}