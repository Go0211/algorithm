import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");

    int[] lis = new int[N];
    Arrays.fill(lis, -1);
    lis[0] = Integer.parseInt(st.nextToken());

    int idx = 0;

    while(st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());

      if(lis[idx] < num) {
        lis[++idx] = num;
        continue;
      }

      int start = 0;
      int end = idx;
      while(start < end) {
        int mid = start + ((end - start) >>> 1);

        // num이 더 큼
        if(lis[mid] < num) {
          start = mid + 1;
        }
        // num이 더 작음
        else {
          end = mid ;
        }
      }

      lis[start] = num;
    }

    System.out.println(idx + 1);
  }
}