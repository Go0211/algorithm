package problem.year24.day1014;

import java.util.*;

class Edge {
  String node1;
  String node2;
  Edge(String n1, String n2) {
    node1 = n1;
    node2 = n2;
  }
}

public class Back10204 {
  private static int solveNeighborhoods(int numNodes, ArrayList<Edge> edges, String n) {
    int startNode = Integer.parseInt(n.replace("v", ""));
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < numNodes + 1; i++) {
      list.add(new ArrayList<>());
    }

    for (Edge edge : edges) {
      int a = Integer.parseInt(edge.node1.replace("v", ""));
      int b = Integer.parseInt(edge.node2.replace("v", ""));

      list.get(a).add(b);
      list.get(b).add(a);
    }

    ArrayDeque<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{startNode, 0});
    boolean[] v = new boolean[numNodes + 1];
    v[startNode] = true;
    int cnt = 0;

    while (!q.isEmpty()) {
      int[] arr = q.poll();
      int node = arr[0];
      int count = arr[1];

      if(count == 2) {
        return cnt;
      }

      for (int num : list.get(node)) {
        if(!v[num]) {
          cnt++;
          v[num] = true;
          q.offer(new int[]{num, count + 1});
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int numTests = sc.nextInt();		// number of test cases

    for (int t = 0; t < numTests; t++) {
      int numNodes = sc.nextInt();
      int numEdges = sc.nextInt();
      ArrayList<Edge> edges = new ArrayList<Edge>();

      for(int i = 0; i < numEdges; i++)
        edges.add(new Edge(sc.next(), sc.next()));

      String n = sc.next();
      int res = solveNeighborhoods(numNodes, edges, n);

      System.out.println("The number of supervillains in 2-hop neighborhood of " + n + " is " + res);
    }

    sc.close();
  }
}
