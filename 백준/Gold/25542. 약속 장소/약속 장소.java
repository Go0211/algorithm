import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = 
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    List<String> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      list.add(br.readLine());
    }

    for (int i = 0; i < L; i++) {
      for (char c = 'A'; c <= 'Z'; c++) {
        StringBuilder sb = new StringBuilder(list.get(0));
        sb.setCharAt(i, c);
        String candidate = sb.toString();

        if (isValid(candidate, list, L)) {
          System.out.println(candidate);
          return;
        }
      }
    }

    System.out.println("CALL FRIEND");
  }

  static boolean isValid(String candidate, List<String> list, int L) {
    for (String s : list) {
      int diff = 0;
      for (int i = 0; i < L; i++) {
        if (candidate.charAt(i) != s.charAt(i)) diff++;
        if (diff > 1) return false;
      }
    }
    return true;
  }
}