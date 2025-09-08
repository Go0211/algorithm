import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    long answer = 0L;
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] brr = new int[n];
    int[] crr = new int[n];
    int[] drr = new int[n];
    for(int i = 0; i < n; i++) {
      StringTokenizer st =
          new StringTokenizer(br.readLine(), " ");
      arr[i] = Integer.parseInt(st.nextToken());
      brr[i] = Integer.parseInt(st.nextToken());
      crr[i] = Integer.parseInt(st.nextToken());
      drr[i] = Integer.parseInt(st.nextToken());
    }

    int[] abrr = new int[n * n];
    int[] cdrr = new int[n * n];

    int idx = 0;
    for(int a : arr) {
      for(int b : brr) {
        abrr[idx++] = a + b;
      }
    }
    idx = 0;
    for(int c : crr) {
      for(int d : drr) {
        cdrr[idx++] = c + d;
      }
    }

    Arrays.sort(cdrr);
    for(int ab : abrr) {
      answer += upper(cdrr, ab * -1) - lower(cdrr, ab * -1);
    }

    System.out.println(answer);
  }

  static int upper(int[] arr, int target) {
    int start = 0;
    int end = arr.length;

    while(start < end) {
      int mid = start + ((end - start) >>> 1);

      if(arr[mid] <= target) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return start;
  }

  static int lower(int[] arr, int target) {
    int start = 0;
    int end = arr.length;

    while(start < end) {
      int mid = start + ((end - start) >>> 1);

      if(arr[mid] < target) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return start;
  }
}