import java.io.*;
import java.util.*;

public class Main {
  static class Node {
    int idx, d;

    Node(int idx, int d) {
      this.idx = idx;
      this.d = d;
    }

    public String toString() {
      return "idx +> " + idx + " | d +> " + d;
    }
  }

  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    while(true) {
      String str = br.readLine();

      if (str == null || str.isEmpty()) continue;
      if(str.equals("0")) {
        break;
      }

      StringTokenizer st =
          new StringTokenizer(str, " ");
      int nodeCount = Integer.parseInt(st.nextToken());
      int seq = Integer.parseInt(st.nextToken());

      List<List<Node>> list = new ArrayList<>();
      for(int i = 0; i < nodeCount + 1; i++) {
        list.add(new ArrayList<>());
      }

      for(int i = 0; i < seq; i++) {
        st = new StringTokenizer(br.readLine());
        int idx1 = Integer.parseInt(st.nextToken());
        int idx2 = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        list.get(idx1).add(new Node(idx2, d));
        list.get(idx2).add(new Node(idx1, d));
      }

      int mst = 0;
      boolean[] v = new boolean[nodeCount + 1];
      PriorityQueue<Node> pq =
          new PriorityQueue<>((x, y) -> x.d - y.d);
      for(Node n : list.get(1)) {
        pq.add(n);
      }
      v[1] = true;
      int totalCount = 0;

      while(!pq.isEmpty()) {
        if(totalCount == nodeCount) {
          break;
        }

        Node preN = pq.remove();

        if(!v[preN.idx]) {
          mst += preN.d;
          totalCount++;
          v[preN.idx] = true;

          for(Node n : list.get(preN.idx)) {
            pq.add(new Node(n.idx, n.d));
          }
        }
      }

      sb.append(mst).append("\n");
    }

    System.out.println(sb);
  }
}