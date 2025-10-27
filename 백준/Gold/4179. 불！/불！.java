import java.io.*;
import java.util.*;

public class Main {
  static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    char[][] arr = new char[R][C];
    int answer = Integer.MAX_VALUE;
    List<int[]> fires = new ArrayList<>();
    int[] jihunYX = new int[2];

    for(int i = 0; i < R; i++) {
      String str = br.readLine();

      for(int j = 0; j < C; j++) {
        arr[i][j] = str.charAt(j);

        if(arr[i][j] == 'F') {
          fires.add(new int[]{i, j});
        } else if(arr[i][j] == 'J') {
          jihunYX[0] = i;
          jihunYX[1] = j;
        }
      }
    }

    int[][] v = new int[R][C];

    for (int[] vv : v) {
      Arrays.fill(vv, Integer.MAX_VALUE);
    }

    for(int[] fire : fires) {
      fireBfs(arr, fire[0], fire[1], R, C, v);
    }

    answer = jihunBfs(arr, jihunYX[0], jihunYX[1], R, C, v);
    System.out.println(answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer);
  }

  static void fireBfs(char[][] arr, int y, int x,
      int R, int C, int[][] v) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{y, x, 0});
    v[y][x] = 0;

    while(!queue.isEmpty()) {
      int[] ints = queue.poll();
      int py = ints[0];
      int px = ints[1];
      int count = ints[2];

      for(int[] dir : dirs) {
        int ny = dir[0] + py;
        int nx = dir[1] + px;

        if(ny >= 0 && ny < R && nx >= 0 && nx < C
            && v[ny][nx] > count + 1 && arr[ny][nx] == '.') {
          queue.offer(new int[]{ny, nx, count + 1});
          v[ny][nx] = count + 1;
        }
      }
    }
  }

  static int jihunBfs(char[][] arr, int y, int x, int R, int C, int[][] v) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{y, x, 0});
    v[y][x] = 0;

    while(!queue.isEmpty()) {
      int[] ints = queue.poll();
      int py = ints[0];
      int px = ints[1];
      int count = ints[2];

      for(int[] dir : dirs) {
        int ny = dir[0] + py;
        int nx = dir[1] + px;

        if(!(ny >= 0 && ny < R && nx >= 0 && nx < C)) {
          return count + 1;
        }

        if(arr[ny][nx] == '.' && v[ny][nx] > count + 1) {
          queue.offer(new int[]{ny, nx, count + 1});
          v[ny][nx] = count + 1;
        }
      }
    }

    return Integer.MAX_VALUE;
  }
}