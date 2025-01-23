import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder sb = new StringBuilder();
    int seq = Integer.parseInt(br.readLine());
    int result = 0;
    int[] arr = new int[seq];
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < seq; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    next:
    for (int i = 0; i < seq; i++) {
      int findValue = arr[i];

      int minIdx = 0;
      int littleMinIdx = i - 1;
      while (minIdx < littleMinIdx && minIdx != i && littleMinIdx != i) {
        int min = arr[minIdx];
        int max = arr[littleMinIdx];

        if (min + max < findValue) {
          minIdx++;
        } else if (min + max > findValue) {
          littleMinIdx--;
        } else {
//          System.out.println(littleMinIdx + " " + minIdx);
          result++;
          continue next;
        }
      }

      int startIdx = 0;
      int endIdx = seq - 1;
      while (startIdx < endIdx && startIdx != i && endIdx != i) {
        int min = arr[startIdx];
        int max = arr[endIdx];

        if (min + max < findValue) {
          startIdx++;
        } else if (min + max > findValue) {
          endIdx--;
        } else {
//          System.out.println(startIdx + " " + endIdx);
          result++;
          continue next;
        }
      }

      int maxIdx = seq - 1;
      int littleMaxIdx = i + 1;

      while (littleMaxIdx < maxIdx && maxIdx != i && littleMaxIdx != i) {
        int min = arr[littleMaxIdx];
        int max = arr[maxIdx];

        if (min + max < findValue) {
          littleMaxIdx++;
        } else if (min + max > findValue) {
          maxIdx--;
        } else {
//          System.out.println(littleMaxIdx + " " + maxIdx);
          result++;
          continue next;
        }
      }
    }
    System.out.println(result);
  }
}
