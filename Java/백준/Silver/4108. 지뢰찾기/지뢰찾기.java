import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs =
            {{0, 1}, {0, -1},
                    {1, 1}, {1, 0}, {1, -1},
                    {-1, 1}, {-1, 0}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            if (row == 0 && col == 0) {
                break;
            }

            char[][] arr = new char[row][col];

            for (int i = 0; i < row; i++) {
                String[] strArr = br.readLine().split("");
                for (int j = 0; j < col; j++) {
                    arr[i][j] = strArr[j].charAt(0);
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (arr[i][j] == '.') {
                        countBomb(arr, i, j, row, col, sb);
                    } else {
                        sb.append(arr[i][j]);
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void countBomb(
            char[][] arr, int i, int j,
            int row, int col, StringBuilder sb) {
        int count = 0;

        for (int[] dir : dirs) {
            int ny = i + dir[0];
            int nx = j + dir[1];

            if (ny >= 0 && ny < row
                    && nx >= 0 && nx < col
                    && arr[ny][nx] == '*') {
                count++;
            }
        }

        sb.append(count);
    }
}