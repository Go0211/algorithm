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

    Arrays.sort(abrr);
    Arrays.sort(cdrr);

    int start = 0;
    int end = n * n - 1;

    while(start < n * n && end >= 0) {
      int num = abrr[start] + cdrr[end];

      if (num < 0) {
        start++;
      } else if (num > 0) {
        end--;
      } else {
        long countAB = findSameNum(abrr, start, abrr[start], 1);
        long countCD = findSameNum(cdrr, end, cdrr[end], -1);
        start += (int) countAB;
        end -= (int) countCD;
        answer += countAB * countCD;
      }
    }

    System.out.println(answer);
  }

  static long findSameNum(int[] arr, int idx, int target, int add) {
    long count = 0;

    while(idx >= 0 && idx < arr.length && target == arr[idx]) {
      idx += add;
      count++;
    }

    return count;
  }
}