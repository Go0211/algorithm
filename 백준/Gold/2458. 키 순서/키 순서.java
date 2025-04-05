import java.util.*;
import java.io.*;

public class Main {
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int nodeCount = Integer.parseInt(st.nextToken());
    int seq = Integer.parseInt(st.nextToken());
    int total = 0;
    arr = new int[nodeCount + 1];

    List<List<Integer>> list = new ArrayList<>();
    for(int i = 0; i < nodeCount + 1; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < seq; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
    }

    for(int i = 1; i <= nodeCount; i++) {
      bfs(list, i, nodeCount);
    }
    for (int i = 1; i <= nodeCount; i++) {
      total += arr[i] >= nodeCount ? 1 : 0;
    }

    System.out.println(total);
  }

  public static void bfs(List<List<Integer>>list, int start, int nodeCount) {
    boolean[] v = new boolean[nodeCount + 1];
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.addLast(start);
    v[start] = true;
    arr[start]++;

    while(!q.isEmpty()) {
      int idx = q.removeFirst();
      List<Integer> preL = list.get(idx);

      for(int i = 0; i < preL.size(); i++) {
        int num = preL.get(i);

        if(!v[num]) {
          q.addLast(num);
          v[num] = true;
          arr[num]++;
          arr[start]++;
        }
      }
    }
  }
}