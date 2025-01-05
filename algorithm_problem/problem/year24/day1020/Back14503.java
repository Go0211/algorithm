package problem.year24.day1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back14503 {
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] maps = new int[R][C];

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        next :
        while (true) {
            //1. 현재 칸 청소 X -> 현재 칸 청소
            if(maps[r][c] == 0) {
                maps[r][c] = -1;
                answer++;
            }

            if(findFourBlock(maps, r, c, R, C)) {
                //2. 칸 주변 4칸 청소 O -> 반 시계 90도 or 방향보고 청소안되있으면 전진 후 1번
                for (int i = 1; i <= 4; i++) {
                    int row = dirs[(d + 4 - i) % 4][0] + r;
                    int col = dirs[(d + 4 - i) % 4][1] + c;

                    if(row >= 0 && row < R && col >= 0 && col < C && maps[row][col] == 0) {
                        r = row;
                        c = col;
                        d = (d + 4 - i) % 4;
                        continue next;
                    }
                }
            } else {
                //3. 칸 주변 4칸 청소 X-> 방향 유지하면 후진 후 1번 or 작동 X
                int back = (d + 2) % 4;
                int row = dirs[back][0] + r;
                int col = dirs[back][1] + c;

                if (row >= 0 && row < R && col >= 0 && col < C) {
                    if (maps[row][col] != 1) {
                        r = row;
                        c = col;
                        continue next;
                    } else {
                        break next;
                    }
                } else {
                    break next;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean findFourBlock(int[][] maps, int r, int c, int R, int C) {
        for (int[] dir : dirs) {
            int row = dir[0] + r;
            int col = dir[1] + c;

            if(row >= 0 && row < R && col >= 0 && col < C && maps[row][col] == 0) {
                return true;
            }
        }

        return false;
    }
}
