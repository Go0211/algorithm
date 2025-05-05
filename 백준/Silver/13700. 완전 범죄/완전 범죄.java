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
    dfs(arr, 0, start, front, back, home, len);

    System.out.println(
        arr[home] == Integer.MAX_VALUE ?
            "BUG FOUND" : arr[home]
    );
  }

  static void dfs(
      int[] arr, int count, int start,
      int front, int back, int home, int len)
  {
    if(home == start) {
      return;
    }

    int fm = start + front;
    int bm = start - back;

    if(0 <= fm && fm < len && arr[fm] > count + 1) {
      arr[fm] = count + 1;
      dfs(arr, count + 1, fm, front, back, home, len);
    }

    if(0 <= bm && bm < len && arr[bm] > count + 1) {
      arr[bm] = count + 1;
      dfs(arr, count + 1, bm, front, back, home, len);
    }
  }
}