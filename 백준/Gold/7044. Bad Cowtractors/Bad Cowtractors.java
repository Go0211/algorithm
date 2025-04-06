import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int idx, d;

    Node(int idx, int d) {
      this.idx = idx;
      this.d = d;
    }

    public String toString() {
      return "idx : " + idx  + "- d : " + d + " | ";
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int nodeCount = Integer.parseInt(st.nextToken());
    int seq = Integer.parseInt(st.nextToken());
    List<List<Node>> list = new ArrayList<>();
    for(int i = 0; i <= nodeCount; i++) {
      list.add(new ArrayList<>());
    }

    int cost[] = new int[nodeCount + 1];
    Arrays.fill(cost, -1);
    boolean[] v = new boolean[nodeCount + 1];

    for(int i = 0; i < seq; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int idx1 = Integer.parseInt(st.nextToken());
      int idx2 = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      list.get(idx1).add(new Node(idx2, d));
      list.get(idx2).add(new Node(idx1, d));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.d - x.d);
    pq.add(new Node(2, 0));
    cost[2] = 0;
    int mst = 0;

    while(!pq.isEmpty()) {
      Node node = pq.remove();
      int idx = node.idx;
      int d = node.d;
      List<Node> l = list.get(idx);
      if(v[idx]) continue;
      v[idx] = true;
      mst += d;

      for(int i = 0; i < l.size(); i++) {
        Node nextNode = l.get(i);
        if(!v[nextNode.idx] && cost[nextNode.idx] < nextNode.d) {
          cost[nextNode.idx] = nextNode.d;
          pq.add(new Node(nextNode.idx, nextNode.d));
        }
      }
    }

    System.out.println(
        Arrays.stream(cost).filter(x -> x == -1).count() <= 1
        ? mst
        : -1);
  }
}