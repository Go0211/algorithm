import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int z, y, x, count;

    Node(int z, int y, int x, int count) {
      this.z = z;
      this.y = y;
      this.x = x;
      this.count = count;
    }

    boolean same(Node node) {
      return node.z == z && node.y == y && node.x == x;
    }
  }

  static int[][] dirs =
      {
          {0, 0, 1}, {0, 1, 0},
          {0, -1, 0}, {0, 0, -1},
          {1, 0, 0}, {-1, 0, 0}
      };

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while(true) {
      // 초반 입력
      StringTokenizer st =
          new StringTokenizer(br.readLine());
      int Z = Integer.parseInt(st.nextToken());
      int Y = Integer.parseInt(st.nextToken());
      int X = Integer.parseInt(st.nextToken());
      boolean finish = true;

      // 끝나는 거 조건으로 check
      if(Z == 0 && Y == 0 && X == 0) {
        break;
      }

      //초기 세팅
      char[][][] maps = new char[Z][Y][X];
      boolean[][][] v = new boolean[Z][Y][X];
      Node startNode = new Node(0, 0, 0, 0);
      Node endNode = new Node(0, 0, 0, 0);
      for(int i = 0; i < Z; i++) {
        for(int j = 0; j <= Y; j++) {
          String str = br.readLine();

          if (str.isEmpty()) {
            continue;
          }

          for(int k = 0; k < X; k++) {
            char c = str.charAt(k);
            maps[i][j][k] = c;

            if(c == 'S') {
              startNode = new Node(i, j, k, 0);
            } else if(c == 'E') {
              endNode = new Node(i, j, k, 0);
            }
          }
        }
      }

      //시작
      ArrayDeque<Node> queue = new ArrayDeque<>();
      queue.offer(new Node(startNode.z, startNode.y, startNode.x, 0));
      v[startNode.z][startNode.y][startNode.x] = true;

      while(!queue.isEmpty()) {
        // startNode에서 endNode와 same 비교
        Node sNode = queue.poll();
        if(sNode.same(endNode)) {
          finish = false;
          sb.append("Escaped in ").append(sNode.count).append(" minute(s).").append("\n");
          break;
        }

        // 다르다면 지나왔던 곳을 제외한 곳을 6방탐색
        for(int[] dir : dirs) {
          int nextZ = sNode.z + dir[0];
          int nextY = sNode.y + dir[1];
          int nextX = sNode.x + dir[2];
          int plusCount = sNode.count + 1;

          // .이고 새로 오는 곳인 지 check
          if(nextZ >= 0 && nextZ < Z
              && nextY >= 0 && nextY < Y
              && nextX >= 0 && nextX < X
              && (maps[nextZ][nextY][nextX] == '.' || maps[nextZ][nextY][nextX] == 'E')
              && !v[nextZ][nextY][nextX]) {
            queue.offer(new Node(nextZ, nextY, nextX, plusCount));
            v[nextZ][nextY][nextX] = true;
          }
        }
      }

      if(finish) {
        sb.append("Trapped!").append("\n");
      }
    }

    System.out.println(sb);
  }
}