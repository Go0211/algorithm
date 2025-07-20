import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static class Node {
    int idx, depth;

    Node(int idx, int depth) {
      this.idx = idx;
      this.depth = depth;
    }

    public String toString() {
      return "idx" + idx + " depth" + depth;
    }
  }

  static long gigaToLeafDepth = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int startNode = Integer.parseInt(st.nextToken()) - 1;
    int seq = N - 1;
    List<Node>[] la = new ArrayList[N];
    for(int i = 0; i < N; i++) {
      la[i] = new ArrayList<>();
    }

    for(int i = 0; i < seq; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int start = Integer.parseInt(st.nextToken()) - 1;
      int end = Integer.parseInt(st.nextToken()) - 1;
      int depth = Integer.parseInt(st.nextToken());

      la[start].add(new Node(end, depth));
      la[end].add(new Node(start, depth));
    }

//    for(List<Node> list : la) {
//      System.out.println(list);
//    }

    boolean[] v = new boolean[N];
    v[startNode] = true;
    long[] returnArr = findLen_rootToGigaDepth(startNode, la, 0, v, true);
    int gigaNode = (int) returnArr[0];
    long rootToGigaDepth = returnArr[1];
    findMaxLen(gigaNode, la, v, 0);

    System.out.println(rootToGigaDepth + " " + gigaToLeafDepth);
  }

  // root -> giga까지 구하는 dfs 함수
  static long[] findLen_rootToGigaDepth(int node, List<Node>[] la, int depth, boolean[] v, boolean isRoot) {
    if ((isRoot && la[node].size() != 1) || !isRoot && la[node].size() != 2) {
      return new long[]{node, depth};
    }

    List<Node> list = la[node];
    for(Node n : list) {
      if (!v[n.idx]) {
        v[n.idx] = true;
        return findLen_rootToGigaDepth(n.idx, la, depth + n.depth, v,false);
      }
    }

    return new long[]{0, 0};
  }

  // giga -> root까지 구하는 dfs 함수
  static void findMaxLen(int node, List<Node>[] la, boolean[] v, int depth) {
    if(la[node].size() == 1) {
      gigaToLeafDepth = Math.max(depth, gigaToLeafDepth);
      return;
    }

    List<Node> list = la[node];
    for(Node n : list) {
      if(!v[n.idx]) {
        v[n.idx] = true;
        findMaxLen(n.idx, la, v,depth + n.depth);
      }
    }
  }
}