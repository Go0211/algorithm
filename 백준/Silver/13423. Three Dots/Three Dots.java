import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int z = 0; z < T; z++) {
      int N = Integer.parseInt(br.readLine());
      int answer = 0;
      int[] arr = new int[N];
      Set<Integer> sets = new HashSet<>();
      StringTokenizer st =
          new StringTokenizer(br.readLine(), " ");

      for(int i = 0; i < N; i++) {
        int num = Integer.parseInt(st.nextToken());;
        arr[i] = num;
        sets.add(num);
      }
      Arrays.sort(arr);

      for(int i = 0; i < N - 1; i++) {
        for(int j = N - 1; j > i; j--) {
          if((arr[i] + arr[j]) % 2 == 0 && sets.contains((arr[i] + arr[j]) / 2)) {
            answer++;
          }
        }
      }

      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }
}