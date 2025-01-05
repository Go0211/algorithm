package problem.year24.day1228;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Back2210 {
    static int[][] dirs =
            {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        Set<String> sets = new HashSet<>();

        char[][] maps = new char[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                maps[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(maps, sets, new char[6], i, j, 0);
            }
        }

//        System.out.println(sets);
        System.out.println(sets.size());
    }

    private static void dfs(char[][] maps, Set<String> sets, char[] arr,
                            int nowY, int nowX, int idx) {
        if (idx == 6) {
            sets.add(new String(arr));
            return;
        }

//        System.out.println(idx + " nowY : " + nowY + " nowX : " + nowX + Arrays.toString(arr));

        for (int[] dir : dirs) {
            int nextY = nowY + dir[0];
            int nextX = nowX + dir[1];

            if (nextY >= 0 && nextY < 5
                    && nextX >= 0 && nextX < 5
                    && !(nextY == nowY && nextX == nowX)) {
                char[] copyArr = arr.clone();
                copyArr[idx] = maps[nextY][nextX];

                dfs(maps, sets, copyArr, nextY, nextX, idx + 1);
            }
        }
    }
}