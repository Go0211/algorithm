import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
  static int[][] dirs = {{0, 1}, {1, 0}};

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());
    int[][] maps = new int[len][len];

    for (int i = 0; i < len; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < len; j++) {
        maps[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(bfs(maps, len) ? "HaruHaru" : "Hing");
  }

  private static boolean bfs(int[][] maps, int len) {
    ArrayDeque<int[]> q = new ArrayDeque<>();
    boolean[][] v = new boolean[len][len];
    q.add(new int[]{0, 0});
    v[0][0] = true;

    while (!q.isEmpty()) {
      int[] yx = q.poll();
      int preY = yx[0];
      int preX = yx[1];
      int mul = maps[preY][preX];

      if (preY == len - 1 && preX == len - 1) {
        return true;
      }

      for (int[] dir : dirs) {
        int nextY = dir[0] * mul + preY;
        int nextX = dir[1] * mul + preX;

        if (nextY >= 0 && nextY < len
            && nextX >= 0 && nextX < len
            && !v[nextY][nextX]) {
          q.add(new int[]{nextY, nextX});
          v[nextY][nextX] = true;
        }
      }
    }

    return false;
  }
}
