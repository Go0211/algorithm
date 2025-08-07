import java.io.*;
import java.util.*;

public class Main {
  static final String QUACK = "quack";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    List<Integer> ducks = new ArrayList<>();
    int result = 0;

    for (char c : input.toCharArray()) {
      boolean matched = false;

      for (int i = 0; i < ducks.size(); i++) {
        int pos = ducks.get(i);

        if (QUACK.charAt(pos) == c) {
          ducks.set(i, (pos + 1) % 5);

          matched = true;

          // 오리 한 마리 종료
          if (ducks.get(i) == 0) {
            ducks.remove(i);
          }

          break;
        }
      }

      if (!matched) {
        if (c == 'q') {
          ducks.add(1);
          result = Math.max(result, ducks.size());
        } else {
          System.out.println(-1);
          return;
        }
      }
    }

    if (!ducks.isEmpty()) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }
  }
}
