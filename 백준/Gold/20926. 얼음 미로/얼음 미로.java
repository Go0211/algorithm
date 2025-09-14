import java.io.*;
import java.util.*;

public class Main {
  static class Node implements Comparable<Node>{
    int y, x, depth;

    Node(int y, int x, int depth) {
      this.y = y;
      this.x = x;
      this.depth = depth;
    }

    public int compareTo(Node n) {
      return n.depth < this.depth ? 1 : -1;
    }
  }

  static int[][] dirs =
      {{1,0},{-1,0},{0,1},{0,-1}};

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int C = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    char[][] arr = new char[R][C];
    PriorityQueue<Node> pq = new PriorityQueue<>();

    for(int i = 0; i < R; i++) {
      String str = br.readLine();
      for(int j = 0; j < C; j++) {
        arr[i][j] = str.charAt(j);

        if(arr[i][j] == 'T') {
          pq.offer(new Node(i, j, 0));
        }
      }
    }

    int answer = -1;
    boolean[][] v = new boolean[R][C];
    while(!pq.isEmpty()) {
      Node node = pq.poll();

      if (v[node.y][node.x]) {
        continue;
      }

      if (arr[node.y][node.x] == 'E') {
        answer = node.depth;
        break;
      }

      v[node.y][node.x] = true;

      next:
      for(int[] dir : dirs) {
        int ny = node.y + dir[0];
        int nx = node.x + dir[1];
        int nc = node.depth;

        while(ny >= 0 && ny < R && nx >= 0 && nx < C && !v[ny][nx] && arr[ny][nx] != 'H') {
          if (arr[ny][nx] == 'E') {
            pq.offer(new Node(ny, nx, nc));
            continue next;
          }
          if (arr[ny][nx] == 'R') {
            pq.offer(new Node(ny - dir[0], nx - dir[1], nc));
            continue next;
          }

          nc += arr[ny][nx] - '0';
          ny += dir[0];
          nx += dir[1];
        }
      }
    }


    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
  }
}