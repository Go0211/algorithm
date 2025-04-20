import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int y, x;
    Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
  static int[][] cross =
      {{1, 1},{-1, -1},{1, -1}, {-1, 1}};
  static int[][] dirs =
      {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

  public static void main(String[] args) throws Exception {
//    System.setIn(new FileInputStream("algorithm_problem/input.txt"));
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int len = Integer.parseInt(st.nextToken());
    int seq = Integer.parseInt(st.nextToken());
    int[][] map = new int[len][len];
    List<Node> list = new ArrayList<>();

    firstSetting(list, len);

    for(int i = 0; i < len; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < len; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int z = 0; z < seq; z++) {
      boolean[][] v = new boolean[len][len];
      st = new StringTokenizer(br.readLine());
      int dir = Integer.parseInt(st.nextToken());
      int range = Integer.parseInt(st.nextToken());

      // list에서 가져와서 다 plus, 해당 위치에 다 1씩 증가
      listLocationSetting(list, dir, range, len, v, map);
      // 그 위치에서 대각선 파악 후 1 이상이면 거기 plus 1씩 (max 4)
      crossCheck(list, len, map);
      // 배열 돌면서 2이상인 곳을 list에 저장 -> v에 데이터 넣기 copy후 사용
      list.clear();

//      System.out.println(z + 1);
//      for(int[] m : map) {
//        System.out.println(Arrays.toString(m));
//      }
//      for(boolean[] vv : v) {
//        System.out.println(Arrays.toString(vv));
//      }

      for(int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
          if(map[i][j] >= 2 && !v[i][j]) {
            map[i][j] -= 2;
            list.add(new Node(i, j));
          }
        }
      }
    }
    int answer = 0;

    // 이제 모든 배열에서 값 다 add해서 print
    for(int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        answer += map[i][j];
      }
    }

    System.out.println(answer);
  }

  static void crossCheck(List<Node> list, int len, int[][] map) {
    for(Node n : list) {
      for(int[] d : cross) {
        int cY = n.y + d[0];
        int cX = n.x + d[1];

        if(cY >= 0 && cY < len && cX >= 0 && cX < len && map[cY][cX] > 0) {
          map[n.y][n.x]++;
        }
      }
    }
  }

  static void listLocationSetting(List<Node> list, int dir, int range,
      int len, boolean[][] v, int[][] map) {
    int moveY = dirs[dir - 1][0] * range;
    int moveX = dirs[dir - 1][1] * range;

    for(Node n : list) {
      int nextY = moveY + n.y;
      int nextX = moveX + n.x;

      while(!(nextY >= 0)) {
        nextY += len;
      }
      while(!(nextY < len)) {
        nextY -= len;
      }

      while(!(nextX >= 0)) {
        nextX += len;
      }
      while(!(nextX < len)) {
        nextX -= len;
      }

      n.y = nextY;
      n.x = nextX;
      v[n.y][n.x] = true;
      map[n.y][n.x]++;
    }
  }

  static void firstSetting(List<Node> list, int len) {
    list.add(new Node(len - 1, 0));
    list.add(new Node(len - 1, 1));
    list.add(new Node(len - 2, 0));
    list.add(new Node(len - 2, 1));
  }
}