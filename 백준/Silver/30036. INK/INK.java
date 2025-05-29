import java.io.*;
import java.util.*;

public class Main {
  static int[][] dirs =
      {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static class Location {
    int y, x, count;

    Location(int y, int x, int count) {
      this.y = y;
      this.x = x;
      this.count = count;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int colorLen = Integer.parseInt(st.nextToken());
    int len = Integer.parseInt(st.nextToken());
    int moveLen = Integer.parseInt(st.nextToken());
    int jumpIdx = 0;
    String colors = br.readLine();
    char[][] maps = new char[len][len];
    Location start = null;

    for(int i = 0; i < len; i++) {
      String str = br.readLine();
      for(int j = 0; j < len; j++) {
        char c = str.charAt(j);

        maps[i][j] = c;

        if(c == '@') {
          start = new Location(i, j, 0);
        }
      }
    }
    String actives = br.readLine();

    for(int i = 0; i < moveLen; i++) {
      char active = actives.charAt(i);

      if(active != 'j' && active != 'J') {
        moves(maps, start, active, len);
      } else if(active == 'j') {
        start.count++;
      } else {
        painting(maps, start, len, colors.charAt(jumpIdx % colorLen));
        jumpIdx++;
        start.count = 0;
      }
    }

    for (int i = 0; i < len; i++) {
      char[] cc = maps[i];
      for (char c : cc) {
        System.out.print(c);
      }
      if (i != len - 1) {
        System.out.println();
      }
    }
  }

  static void painting(char[][] arr, Location location, int len, char color) {
    ArrayDeque<Location> queue = new ArrayDeque<>();
    boolean[][] v = new boolean[len][len];
    queue.add(location);
    v[location.y][location.x] = true;

    while (!queue.isEmpty()) {
      Location now = queue.poll();

      int count = now.count;
      int y = now.y;
      int x = now.x;

      if (arr[y][x] != '.' && arr[y][x] != '@') {
        arr[y][x] = color;
      }

      for(int[] dir : dirs) {
        int ny = y + dir[0];
        int nx = x + dir[1];

        if(ny >= 0 && ny < len
            && nx >= 0 && nx < len
            && !v[ny][nx] && count > 0) {
          v[ny][nx] = true;
          queue.add(new Location(ny, nx, count - 1));
        }
      }
    }
  }

  static void moves(char[][] arr, Location start, char active, int len) {
    int y = start.y;
    int x = start.x;

    arr[y][x] = '.';

    switch(active) {
      case 'U':
        y += dirs[0][0];
        x += dirs[0][1];
        break;
      case 'D':
        y += dirs[1][0];
        x += dirs[1][1];
        break;
      case 'L':
        y += dirs[2][0];
        x += dirs[2][1];
        break;
      case 'R':
        y += dirs[3][0];
        x += dirs[3][1];
        break;
    }

    if(y >= 0 && y < len
        && x >= 0 && x < len
        && arr[y][x] == '.') {
      start.y = y;
      start.x = x;
    }

    arr[start.y][start.x] = '@';
  }
}