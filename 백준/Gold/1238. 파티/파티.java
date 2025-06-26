import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int idxCount = Integer.parseInt(st.nextToken());
    int seq = Integer.parseInt(st.nextToken());
    int arrived = Integer.parseInt(st.nextToken());

    //초기세팅
    int[][] graph = new int[idxCount + 1][idxCount + 1];
    int[][] reverseGraph = new int[idxCount + 1][idxCount + 1];
    for(int i = 0; i < seq; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int depth = Integer.parseInt(st.nextToken());

      graph[start][end] = depth;
      reverseGraph[end][start] = depth;
    }

    // 최소값 탐색
    int[] to = new int[idxCount + 1];
    Arrays.fill(to, Integer.MAX_VALUE);
    int[] from = new int[idxCount + 1];
    Arrays.fill(from, Integer.MAX_VALUE);

    dijkstra(graph, to, idxCount, arrived);
    dijkstra(reverseGraph, from, idxCount, arrived);

    int max = 0;
    for (int i = 1; i < idxCount + 1; i++) {
      max = Math.max(max, to[i] + from[i]);
    }

    System.out.println(max);
  }

  static void dijkstra(int[][] g, int[] cost, int idxCount, int arrived) {
    boolean[] v = new boolean[idxCount + 1];
    cost[arrived] = 0;
    for(int i = 0; i < idxCount; i++) {
      int minIdx = -1;
      int minValue = Integer.MAX_VALUE;

      for(int j = 1; j < idxCount + 1; j++) {
        if(!v[j] && cost[j] < minValue) {
          minIdx = j;
          minValue = cost[j];
        }
      }

      v[minIdx] = true;

      for(int j = 1; j < idxCount + 1; j++) {
        if(!v[j] && g[minIdx][j] != 0 && minValue + g[minIdx][j] < cost[j]) {
          cost[j] = minValue + g[minIdx][j];
        }
      }
    }
  }
}