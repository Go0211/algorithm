import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int len, limit;

    Node(int len, int limit) {
      this.len = len;
      this.limit = limit;
    }

    public String toString() {
      return "len : " + len + " / limit : " + limit;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    PriorityQueue<Node> pq =
        new PriorityQueue<>(
            (x, y) -> y.limit - x.limit == 0 ?
                x.len - y.len :
                y.limit - x.limit);

    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;

    for(int i = 0; i < seq; i++) {
      StringTokenizer st =
          new StringTokenizer(br.readLine());
      pq.offer(new Node(
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())));
    }

    while(!pq.isEmpty()) {
      Node node = pq.poll();

      if(max == Integer.MAX_VALUE && min == Integer.MIN_VALUE) {
        max = node.limit;
        min = node.limit - node.len + 1;
        continue;
      }

      if(min <= node.limit && node.limit <= max) {
        min = node.limit - node.len + (min - node.limit);
      } else {
        max = node.limit;
        min = node.limit - node.len + 1;
      }
    }

    System.out.println(min - 1);
  }
}