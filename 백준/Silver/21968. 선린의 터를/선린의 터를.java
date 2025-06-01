import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int seq = Integer.parseInt(br.readLine());

    for(int i = 0; i < seq; i++) {
      long num = Long.parseLong(br.readLine());
      long three = 1;
      long value = 0;

      while(num > 0) {
        if((num & 1) == 1) {
          value += three;
        }
        num >>= 1;
        three *= 3;
      }

      sb.append(value).append("\n");
    }

    System.out.println(sb);
  }
}