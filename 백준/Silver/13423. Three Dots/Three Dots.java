import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int z = 0; z < T; z++) {
      int N = Integer.parseInt(br.readLine());
      int answer = 0;
      int[] arr = new int[N];
      StringTokenizer st =
          new StringTokenizer(br.readLine(), " ");

      for(int i = 0; i < N; i++) {
        int num = Integer.parseInt(st.nextToken());;
        arr[i] = num;
      }
      Arrays.sort(arr);

      for(int i = 0; i < N; i++) {
          for(int j = i + 1; j < N; j++) {
              int left = arr[i];
              int right = arr[j];
              int mid = (left + right) / 2;
              
              if((left + right) % 2 == 0 
                 && Arrays.binarySearch(arr, mid) >= 0) {
                  answer++;
              }
          }
      }

      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }
}