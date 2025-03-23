import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str;

    next:
    while((str = br.readLine()) != null) {
      int gijun = Integer.parseInt(str) * 10_000_000;
      int seq = Integer.parseInt(br.readLine());
      // 배열에 다 받고 정렬
      int[] arr = new int[seq];
      for(int i = 0; i < seq; i++) {
        arr[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(arr);
      // 시작, 끝 변수
      int startIdx = 0;
      int endIdx = seq - 1;

      while(startIdx < endIdx) {
        // 더한 값이 동일하면 끝
        if(arr[startIdx] + arr[endIdx] == gijun) {
          // sb에 yes 시작포인터값 끝포인터값 저장
          sb.append("yes")
              .append(" ")
              .append(arr[startIdx])
              .append(" ")
              .append(arr[endIdx])
              .append("\n");
          continue next;
          // + -> 끝 포인터를 --
        } else if (arr[startIdx] + arr[endIdx] > gijun) {
          endIdx--;
          // - -> 시작 포인터를 ++
        } else {
          startIdx++;
        }
      }

      // 그리고 끝 포인터와 시작 포인터가 same이면 sb에 danger 저장
      sb.append("danger").append("\n");
    }

    System.out.println(sb);
  }
}