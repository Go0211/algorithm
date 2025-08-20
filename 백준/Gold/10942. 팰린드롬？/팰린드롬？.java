import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    List<Set<Integer>> list = new ArrayList<>();
    for(int i = 0; i < N + 1; i++) {
      list.add(new HashSet<>());
    }

    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    for(int i = 1; i < N + 1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    isPalindrome(arr, list, N);

    int M = Integer.parseInt(br.readLine());
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if(list.get(a).contains(b)) {
        sb.append(1).append("\n");
      } else {
        sb.append(0).append("\n");
      }
    }

    System.out.println(sb);
  }

  static void isPalindrome(int[] arr, List<Set<Integer>> list, int N) {
    for(int i = 1; i < N + 1; i++) {
      next:
      for(int j = i; j < N + 1; j++) {
        int start = i;
        int end = j;

        if(start == end) {
          list.get(i).add(j);
          continue;
        }

        while(start < end) {
          if(arr[start] != arr[end]) {
            continue next;
          }

          start++;
          end--;
        }

        list.get(i).add(j);
      }
    }
  }
}