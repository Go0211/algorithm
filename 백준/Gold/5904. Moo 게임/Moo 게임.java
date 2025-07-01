import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    List<Long> list =
        new ArrayList<>();
    list.add(3L);
    int idx = 1;

    while(list.get(list.size() - 1) < 1_000_000_000) {
      list.add(list.get(idx - 1) * 2 + idx + 3);
      idx++;
    }

    idx = list.size() - 1;
    int value = Integer.parseInt(br.readLine());
    char answer;

    while(true) {
      if(idx == 0) {
        answer = value == 1 ? 'm' : 'o';
        break;
      }

      idx--;

      if(value < list.get(idx)) {
        continue;
      } else if(value < list.get(idx) + (idx + 3)) {
        answer = value == list.get(idx) + 1 ? 'm' : 'o';
        break;
      } else {
        value -= list.get(idx) + idx + 4;
      }
    }

    System.out.println(answer);
  }
}