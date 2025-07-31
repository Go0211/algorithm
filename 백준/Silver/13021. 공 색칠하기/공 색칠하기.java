import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    Set<Integer> set = new HashSet<>();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N + 1];

    for(int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      Arrays.fill(arr, Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()) + 1, i);
    }

    int count = 0;
    for(int num : arr) {
      if(num != 0 && !set.contains(num)) {
        set.add(num);
        count++;
      }
    }

    System.out.println((long) Math.pow(2, count));
  }
}