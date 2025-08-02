import java.util.*;
import java.io.*;

public class Main {
  static class Node implements Comparable<Node> {
    int idx;
    int cost;

    Node(int idx, int cost) {
      this.idx = idx;
      this.cost = cost;
    }

    public int compareTo(Node node) {
      return node.cost > this.cost ? -1 : 1;
    }
  }

  static List<List<Integer>> list;

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    list = new ArrayList<>();
    PriorityQueue<Node> pq = new PriorityQueue<>();
    boolean[] v = new boolean[N];
    int answer = 0;

    for(int i = 0; i < N; i++) {
      list.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine(), " ");
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      pq.add(new Node(i, Integer.parseInt(st.nextToken())));
    }

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      list.get(a).add(b);
      list.get(b).add(a);
    }



    while(!pq.isEmpty()) {
      Node node = pq.poll();
      int index = node.idx;
      int cost = node.cost;

      if(v[index]) {
        continue;
      }

      if(answer + cost > K) {
        break;
      }

      answer += cost;

      dfs(index, list.get(index), v);
    }

    for (boolean isTrue : v) {
      if (!isTrue) {
        answer = 0;
      }
    }

    System.out.println(answer == 0 ? "Oh no" : answer);
  }

  static void dfs(int index, List<Integer> l, boolean[] v) {
    v[index] = true;

    for(int i : l) {
      if(!v[i]) {
        dfs(i, list.get(i), v);
      }
    }
  }
}