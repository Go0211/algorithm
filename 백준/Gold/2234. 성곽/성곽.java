import java.util.*;
import java.io.*;

public class Main {
  static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int col = Integer.parseInt(st.nextToken());
    int row = Integer.parseInt(st.nextToken());
    int idx = 1;
    int count = 0;
    int max = 0;
    int mix = 0;

    int[][] arr = new int[row][col];
    int[][] v = new int[row][col];
    Set<String> sets = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < row; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < col; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(v[i][j] == 0) {
          int value = bfs(arr, i, j, row, col, v, idx);
          map.put(idx, value);
          max = Math.max(max, value);
          count++;
          idx++;
        }
      }
    }

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        int index = v[i][j];

        for(int[] dir : dirs) {
          int ny = dir[0] + i;
          int nx = dir[1] + j;

          if(ny >= 0 && ny < row
              && nx >= 0 && nx < col
              && index != v[ny][nx]
              && (!sets.contains(index+"|"+v[ny][nx]) || !sets.contains(v[ny][nx]+"|"+index)
          )) {
            int otherIdx = v[ny][nx];
            mix = Math.max(mix, map.get(index) + map.get(otherIdx));
            sets.add(index+"|"+otherIdx);
            sets.add(otherIdx+"|"+index);
          }
        }
      }
    }

    System.out.println(count);
    System.out.println(max);
    System.out.println(mix);
  }

  static int bfs(int[][] arr, int y, int x, int row, int col, int[][] v, int idx) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{y, x});
    v[y][x] = idx;
    int count = 0;

    while(!queue.isEmpty()) {
      int[] polls = queue.poll();
      int preY = polls[0];
      int preX = polls[1];
      int value = arr[preY][preX];
      count++;

      for (int i = 0; i < 4; i++) {
        if((value >> i & 1) == 0) {
          int ny = preY + dirs[i][0];
          int nx = preX + dirs[i][1];

          if(ny >= 0 && ny < row
              && nx >= 0 && nx < col
              && v[ny][nx] == 0) {
            v[ny][nx] = idx;
            queue.add(new int[]{ny, nx});
          }
        }
      }
    }

    return count;
  }
}