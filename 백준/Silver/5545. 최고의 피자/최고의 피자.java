import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int dMoney = Integer.parseInt(st.nextToken());
    int tMoney = Integer.parseInt(st.nextToken());
    int dk = Integer.parseInt(br.readLine());
    int[] mArr = new int[seq + 1];
    int[] tArr = new int[seq + 1];
    Integer[] imsi = new Integer[seq];
    mArr[0] = dk;
    tArr[0] = dMoney;
    int answer = 0;

    for (int i = 0; i < seq; i++) {
      imsi[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(imsi, (x, y) -> y - x);

    for(int i = 1; i <= seq; i++) {
      mArr[i] += mArr[i - 1] + imsi[i - 1];
      tArr[i] += tArr[i - 1] + tMoney;
    }

    for(int i = 0; i <= seq; i++) {
      answer = Math.max(answer, mArr[i] / tArr[i]);
    }

    System.out.println(answer);
  }
}