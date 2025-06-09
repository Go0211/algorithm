import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int id, time, priority;

    Node(int id, int time, int priority) {
      this.id = id;
      this.time = time;
      this.priority = priority;
    }
  }

  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int seq = Integer.parseInt(st.nextToken());
    int size = Integer.parseInt(st.nextToken());
    PriorityQueue<Node> pq =
        new PriorityQueue<>((x, y) -> compares(x, y));

    for(int i = 0; i < size; i++) {
      st = new StringTokenizer(br.readLine());
      pq.add(new Node(Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())));
    }

    while(!pq.isEmpty() && seq-- != 0) {
      Node node = pq.poll();

      sb.append(node.id).append("\n");
      node.time--;
      node.priority--;

      if(node.time == 0) {
        continue;
      }
      pq.offer(node);
    }

    System.out.print(sb);
  }

  static int compares(Node x, Node y) {
    return x.priority == y.priority
        ? (x.id > y.id ? 1 : -1)
        : (x.priority < y.priority ? 1 : -1);
  }
}