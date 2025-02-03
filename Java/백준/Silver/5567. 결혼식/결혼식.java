import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nodeCount = Integer.parseInt(br.readLine());
    int freq = Integer.parseInt(br.readLine());
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < nodeCount + 1; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < freq; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    boolean[] v = new boolean[nodeCount + 1];
    ArrayDeque<int[]> q = new ArrayDeque<>();
    v[1] = true;
    q.offer(new int[]{1, 0});


    int result = 0;
    while (!q.isEmpty()) {
      int[] arr = q.poll();
      int start = arr[0];
      int count = arr[1];

      if (count == 2) {
        continue;
      }

      for(int next : list.get(start)) {
        if (!v[next]) {
          v[next] = true;
          q.add(new int[]{next, count + 1});
          result++;
        }
      }
    }

    System.out.println(result);
  }
}

