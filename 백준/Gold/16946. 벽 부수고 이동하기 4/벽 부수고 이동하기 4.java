import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        int[][] v = new int[R][C];

        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < R; i++) {
            String str = br.readLine();

            for(int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j) - '0';

                if(arr[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        int minus = -1;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == 0 && v[i][j] == 0) {
                    map.put(minus, bfs(arr, v, R, C, i, j, minus));
                    minus -= 1;
                }
            }
        }

        for(int[] yx : list) {
            int total = 0;

            Set<Integer> set = new HashSet<>();

            for(int[] dir : dirs) {
                int ny = dir[0] + yx[0];
                int nx = dir[1] + yx[1];

                if(ny >= 0 && ny < R && nx >= 0 && nx < C
                        && arr[ny][nx] == 0
                        && map.containsKey(v[ny][nx])
                        && !set.contains(v[ny][nx])) {
                    total += map.get(v[ny][nx]);
                    set.add(v[ny][nx]);
                }
            }

            arr[yx[0]][yx[1]] = (total + 1) % 10;
        }

        for(int[] nums : arr) {
            for(int num : nums) {
                sb.append(num);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int[][] arr, int[][] v, int R, int C,
                   int y, int x, int minus) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        v[y][x] = minus;

        int total = 0;
        while(!queue.isEmpty()) {
            int[] ints = queue.poll();
            int py = ints[0];
            int px = ints[1];

            total++;

            for(int[] dir : dirs) {
                int ny = py + dir[0];
                int nx = px + dir[1];

                if(ny >= 0 && ny < R && nx >= 0 && nx < C
                        && arr[ny][nx] == 0 && v[ny][nx] == 0) {
                    queue.offer(new int[]{ny,nx});
                    v[ny][nx] = minus;
                }
            }
        }

        return total;
    }
}