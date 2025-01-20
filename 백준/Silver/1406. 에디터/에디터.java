import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();

    ArrayDeque<Character> lStack = new ArrayDeque<>();
    ArrayDeque<Character> rStack = new ArrayDeque<>();

    for (int i = 0; i < str.length(); i++) {
      lStack.push(str.charAt(i));
    }

    int seq = Integer.parseInt(br.readLine());
    for (int i = 0; i < seq; i++) {
      String[] logic = br.readLine().split(" ");

      if (logic.length == 1) {
        switch (logic[0].charAt(0)) {
          case 'L':
            if (!lStack.isEmpty()) {
              rStack.push(lStack.pop());
            }
            break;
          case 'D':
            if (!rStack.isEmpty()) {
              lStack.push(rStack.pop());
            }
            break;
          case  'B':
            if (!lStack.isEmpty()) {
              lStack.remove();
            }
            break;
        }
      } else {
        lStack.push(logic[1].charAt(0));
      }
    }

    while (!lStack.isEmpty()) {
      sb.append(lStack.pollLast());
    }
    for (char c : rStack) {
      sb.append(c);
    }

    System.out.println(sb);
  }
}
