package problem.year25.day0112;

import java.util.*;
import java.io.*;

public class Back15700 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long a = Integer.parseInt(st.nextToken());
    long b = Integer.parseInt(st.nextToken());
    System.out.println(a * b / 2);
  }
}