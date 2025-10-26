import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine(), " ");

    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int start = 0;
    int end = 1_000_000_000;

    while(start < end) {
      int mid = start + ((end - start) >>> 1);

      if(mid == 0) {
        break;
      }

      if(arr[arr.length - 1] < mid) {
        end = mid;
        continue;
      }

//      int S = 0;
//      int E = arr.length - 1;
//
//      while(S < E) {
//        int mm = S + ((E - S) >>> 1);
//
//        if(S <= mid) {
//          S = mm + 1;
//        } else {
//          E = mm;
//        }
//      }

      int count = 0;
      for(int i = 0; i < arr.length; i++) {
        count += arr[i] / mid;
      }

      if(count >= M) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    System.out.println(start == 0 ? start : start - 1);
  }
}