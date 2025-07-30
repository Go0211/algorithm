import java.util.*;
import java.io.*;

public class Main {
  static int count = 0;
  static int time = Integer.MAX_VALUE;

  static class Node {
    int n, t;

    Node(int n, int t) {
      this.n = n;
      this.t = t;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] v = new int[100_001];
    Arrays.fill(v, Integer.MAX_VALUE);
    bfs(N, K, v);

    System.out.println(time);
    System.out.println(count);
  }

  static void bfs(int N, int K, int[] v) {
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.offer(new Node(N, 0));

    while(!queue.isEmpty() && queue.peek().t <= time) {
      Node node = queue.poll();
      int n = node.n;
      int t = node.t;

      if (K == n) {
        if (t == time) {
          count++;
        } else if (t < time) {
          count = 1;
          time = t;
        }
      }

      if(n - 1 >= 0 && v[n - 1] >= t + 1) {
        v[n - 1] = t + 1;
        queue.offer(new Node(n - 1, t + 1));
      }
      if(n + 1 <= 100_000 && v[n + 1] >= t + 1) {
        v[n + 1] = t + 1;
        queue.offer(new Node(n + 1, t + 1));
      }
      if(n != 0 && n * 2 <= 100_000 && v[n * 2] >= t + 1) {
        v[n * 2] = t + 1;
        queue.offer(new Node(n * 2, t + 1));
      }
    }
  }
}