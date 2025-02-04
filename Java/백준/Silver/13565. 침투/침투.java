import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  static boolean result = false;
  static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public static void main(String[] args) throws Exception{
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    boolean zero = false;
    Set<Integer> startSets = new HashSet<>();

    char[][] maps = new char[M][N];
    for (int i = 0; i < M; i++) {
      String str = br.readLine();

      for (int j = 0; j < str.length(); j++) {
        maps[i][j] = str.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      char c = maps[M - 1][i];

      if (c == '1') {
        zero = false;
        continue;
      }

      if (c == '0' && !zero) {
        startSets.add(i);
        zero = true;
      }
    }

    for (int startNum : startSets) {
      if (result) {
        break;
      }

      dfs(maps, startNum, M - 1,new boolean[M][N], M, N);
    }

    System.out.println(result ? "YES" : "NO");
  }

  private static void dfs(char[][] maps, int startNum, int row, boolean[][] v, int M, int N) {
    if (row == 0) {
      result = true;
      return;
    }

    if (result) {
      return;
    }

    for (int[] dir : dirs) {
      int nextY = row + dir[0];
      int nextX = startNum + dir[1];

      if (nextY >= 0 && nextY < M
          && nextX >= 0 && nextX < N
          && !v[nextY][nextX] && maps[nextY][nextX] == '0') {
        v[nextY][nextX] = true;
        dfs(maps, nextX, nextY, v, M, N);
      }
    }
  }
}

