import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq =
        new PriorityQueue<>((x, y) -> x - y);

    int[] arr =
        Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    map.put(arr[0], -1);
    pq.add(arr[0]);

    for(int i = 0; i < N - 1; i++) {
      int a = arr[i];
      int b = arr[i + 1];

      if(!map.containsKey(b)) {
        map.put(b, a);
        pq.add(b);
      }
    }

    System.out.println(map.size());
    while(!pq.isEmpty()) {
      sb.append(map.get(pq.poll())).append(" ");
    }
    System.out.println(sb);
  }
}