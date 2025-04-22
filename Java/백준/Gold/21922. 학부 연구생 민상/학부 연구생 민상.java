import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

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

        boolean[][][] v = new boolean[row][col][4];

        int result = 0;
        for (Node air : airController) {
            bfs(arr, v, air.y, air.x, row, col);
        }

        for (boolean[][] vv : v) {
            next:
            for (boolean[] vvv : vv) {
                for (boolean vvvv : vvv) {
                    if (vvvv) {
                        result++;
                        continue next;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int[][] arr, boolean[][][] v, int preY, int preX, int row, int col) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            queue.offer(new int[]{preY, preX, i});
            v[preY][preX][i] = true;
        }

        while (!queue.isEmpty()) {
            int[] qr = queue.poll();
            int d = qr[2];
            int ny = qr[0] + dirs[d][0];
            int nx = qr[1] + dirs[d][1];

            if (ny >= 0 && ny < row && nx >= 0 && nx < col) {
                int nd = changeDir(arr, ny, nx, d);

                if (v[ny][nx][nd]) {
                    continue;
                }

                queue.add(new int[]{ny, nx, nd});
                v[ny][nx][nd] = true;
            }
        }
    }

    static int changeDir(int[][] arr, int y, int x, int d) {
        if (arr[y][x] == 0) {
            return d;
        }

        switch (arr[y][x]) {
            case 1:
                if (d == 0) {
                    d = 2;
                } else if (d == 2) {
                    d = 0;
                }
                break;
            case 2:
                if (d == 3) {
                    d = 1;
                } else if (d == 1) {
                    d = 3;
                }
                break;
            case 3:
                if (d == 0) {
                    d = 3;
                } else if (d == 1) {
                    d = 2;
                } else if (d == 2) {
                    d = 1;
                } else if (d == 3) {
                    d = 0;
                }
                break;
            case 4:
                if (d == 0) {
                    d = 1;
                } else if (d == 1) {
                    d = 0;
                } else if (d == 2) {
                    d = 3;
                } else if (d == 3) {
                    d = 2;
                }
                break;
        }

        return d;
    }
}