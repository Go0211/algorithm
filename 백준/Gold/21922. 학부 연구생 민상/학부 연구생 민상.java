import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] turns = 
        { { 0, 2, 0, 3, 1 }, 
          { 1, 1, 3, 2, 0 }, 
          { 2, 0, 2, 1, 3 }, 
          { 3, 3, 1, 0, 2 } };

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        List<Node> airController = new ArrayList<>();
        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                if (value == 9) {
                    airController.add(new Node(i, j));
                }
            }
        }

        byte[][] v = new byte[row][col];

        int result = 0;
        for (Node air : airController) {
            bfs(arr, v, air.y, air.x, row, col);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (v[i][j] != 0) result++;
            }
        }

        System.out.println(result);
    }

    static void bfs(int[][] arr, byte[][] v, int preY, int preX, int row, int col) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            queue.offer(new int[]{preY, preX, i});
            v[preY][preX] |= (1 << i); 
        }

        while (!queue.isEmpty()) {
            int[] qr = queue.poll();
            int d = qr[2];
            int ny = qr[0] + dirs[d][0];
            int nx = qr[1] + dirs[d][1];

            if (ny >= 0 && ny < row && nx >= 0 && nx < col) {
                if(arr[ny][nx] == 9) {
                    continue;
                }
                
                int nd = turns[d][arr[ny][nx]];

                if ((v[ny][nx] & (1 << nd)) != 0) {
                    continue;
                }

                queue.add(new int[]{ny, nx, nd});
                v[ny][nx] |= (1 << nd);
            }
        }
    }
}