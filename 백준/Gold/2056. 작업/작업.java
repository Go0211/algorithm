import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    // time들 저장 arr
    int[] times = new int[N];
    // depth들 저장 arr
    int[] dp = new int[N];
    // 선행들 count 저장 arr
    int[] counts = new int[N];
    // 다음 idx를 가지는 list
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < N; i++) {
      StringTokenizer st =
          new StringTokenizer(br.readLine(), " ");
      times[i] = Integer.parseInt(st.nextToken());
      dp[i] = times[i];
      int count = Integer.parseInt(st.nextToken());

      for(int j = 0; j < count; j++) {
        int idx = Integer.parseInt(st.nextToken()) - 1;
        counts[i]++;
        list.get(idx).add(i);
      }
    }

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for(int i = 0; i < N; i++) {
      if(counts[i] == 0) {
        queue.offer(i);
      }
    }

    while(!queue.isEmpty()) {
      int idx = queue.poll();

      for(int i : list.get(idx)) {
        if(dp[i] < dp[idx] + times[i]) {
          dp[i] = dp[idx] + times[i];
        }
        counts[i]--;

        if(counts[i] <= 0) {
          queue.offer(i);
        }
      }
    }

    int total = 0;
    for(int i : dp) {
      total = Math.max(total, i);
    }

    System.out.println(total);
  }
}