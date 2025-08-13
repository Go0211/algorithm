import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    for(int i = 1; i <= N; i++) {
      deque.offerLast(i);
    }

    for(int i = 0; i < N; i++) {
      int count = N - (i + 1);

      if(K == 0) {
        int idx = i;

        while(!deque.isEmpty()) {
          arr[idx] = deque.pollFirst();
          idx++;
        }

        break;
      }

      if(K - count >= 0) {
        K -= count;
        arr[i] = deque.pollLast();
      } else {
        arr[i] = deque.pollFirst();
      }
    }

    for (int a : arr) {
      sb.append(a).append(" ");
    }

    System.out.println(sb);
  }
}