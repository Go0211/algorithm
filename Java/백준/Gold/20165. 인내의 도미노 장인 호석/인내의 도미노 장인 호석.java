import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int result = 0;
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int seq = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        boolean[][] v = new boolean[R][C];
        Map<String, int[]> m = new HashMap<>();
        m.put("E", new int[]{0, 1});
        m.put("W", new int[]{0, -1});
        m.put("S", new int[]{1, 0});
        m.put("N", new int[]{-1, 0});

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < seq * 2; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = null;
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;

            if (i % 2 == 0) {
                dir = st.nextToken();
            }

            if (dir == null) {
                v[row][col] = false;
                continue;
            }

            result += domino(map, v, m, row, col, dir);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(v[i][j] ? "F" : "S").append(" ");
            }
            sb.append("\n");
        }

        System.out.println(result);
        System.out.println(sb);
    }

    static int domino(int[][] map, boolean[][] v, Map<String, int[]> m, int row, int col, String dir) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{map[row][col], row, col});
        v[row][col] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int seq = arr[0];
            int r = arr[1];
            int c = arr[2];

            for (int i = 0; i < seq - 1; i++) {
                int nextR = r + m.get(dir)[0];
                int nextC = c + m.get(dir)[1];

                if (nextR >= 0 && nextR < map.length
                        && nextC >= 0 && nextC < map[0].length
                        && !v[nextR][nextC]) {
                    queue.offer(new int[]{map[nextR][nextC], nextR, nextC});
                    v[nextR][nextC] = true;
                    count++;
                }
                r = nextR;
                c = nextC;
            }
        }

        return count;
    }
}