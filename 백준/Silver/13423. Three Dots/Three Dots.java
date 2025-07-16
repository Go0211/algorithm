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
      StringTokenizer st =
          new StringTokenizer(br.readLine(), " ");

      for(int i = 0; i < N; i++) {
        int num = Integer.parseInt(st.nextToken());;
        arr[i] = num;
      }
      Arrays.sort(arr);

      for (int mid = 1; mid < N - 1; mid++) {
        int left = mid - 1;
        int right = mid + 1;
        int target = arr[mid] * 2;

        while (left >= 0 && right < N) {
          int sum = arr[left] + arr[right];
          if (sum == target) {
            answer++;
            left--;
            right++;
          } else if (sum < target) {
            right++;
          } else {
            left--;
          }
        }
      }

      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }
}