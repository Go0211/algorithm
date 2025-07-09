import java.util.*;
import java.io.*;

public class Main {
  static class Node implements Comparable<Node> {
    long num;
    int plus;

    Node(long num, int plus) {
      this.num = num;
      this.plus = plus;
    }

    public int compareTo(Node n) {
      return this.num > n.num ? 1 : -1;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    long answer = 0;
    PriorityQueue<Node> pq =
        new PriorityQueue<Node>();
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < N; i++) {
      long num = Long.parseLong(st.nextToken());
      pq.add(new Node(num, (int)num));
    }

    while (M > 0) {
      M--;
      Node node = pq.poll();
      answer = node.num;
      node.num += node.plus;
      pq.offer(node);
    }

    System.out.println(answer);
  }
}