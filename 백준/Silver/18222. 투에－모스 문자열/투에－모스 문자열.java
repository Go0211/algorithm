import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    System.out.println(Long.bitCount(Long.parseLong(br.readLine()) - 1) % 2 == 0 ? 0 : 1);
  }
}