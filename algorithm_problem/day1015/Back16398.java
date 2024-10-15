package day1015;

import java.util.*;
import java.io.*;

class Back16398 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());
    int[][] g = new int[len][len];
    boolean[] v = new boolean[len];
    int[] cost = new int[len];
    Arrays.fill(cost, Integer.MAX_VALUE);

    StringTokenizer st;
    for (int i = 0; i < len; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < len; j++) {
        g[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    long mst = 0; int cnt = 0;
    cost[0] = 0;
    for (int i = 0; i < len; i++) {
      int minVertex = -1;
      int min = Integer.MAX_VALUE;

      for (int j = 0; j < len; j++) {
        if(!v[j] && min > cost[j]) {
          minVertex = j;
          min = cost[j];
        }
      }

      v[minVertex] = true;
      mst += min;
      if(cnt++ == len - 1) break;
      for (int j = 0; j < len; j++) {
        if(!v[j] && g[minVertex][j] != 0 && cost[j] > g[minVertex][j]) {
          cost[j] = g[minVertex][j];
        }
      }
    }

    System.out.println(mst);
  }
}
