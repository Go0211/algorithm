import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int len = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken()) - 1;
    int home = Integer.parseInt(st.nextToken()) - 1;
    int front = Integer.parseInt(st.nextToken());
    int back = Integer.parseInt(st.nextToken());
    int policeCount = Integer.parseInt(st.nextToken());

    int[] arr = new int[len];
    Arrays.fill(arr, Integer.MAX_VALUE);

    if(policeCount != 0) {
      st = new StringTokenizer(br.readLine());
    }
    for(int i = 0; i < policeCount; i++) {
      arr[Integer.parseInt(st.nextToken()) - 1] = -1;
    }

    arr[start] = 0;
    int result = bfs(arr, start, front, back, home, len);

    System.out.println(
        result == Integer.MAX_VALUE ?
            "BUG FOUND" : result
    );
  }

  static int bfs(
      int[] arr, int start,
      int front, int back,
      int home, int len)
  {
    ArrayDeque<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{start, 0});

    while(!q.isEmpty()) {
      int[] ints = q.poll();
      int preIdx = ints[0];
      int preCount = ints[1];

      if(preIdx == home) {
        return preCount;
      }

      int fm = preIdx + front;
      int bm = preIdx - back;

      if(0 <= fm && fm < len && arr[fm] > preCount + 1) {
        arr[fm] = preCount + 1;
        q.offer(new int[]{fm, preCount + 1});
      }

      if(0 <= bm && bm < len && arr[bm] > preCount + 1) {
        arr[bm] = preCount + 1;
        q.offer(new int[]{bm, preCount + 1});
      }
    }

    return Integer.MAX_VALUE;
  }
}