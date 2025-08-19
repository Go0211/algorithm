import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = 
        new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String input;
    StringTokenizer st;
    while ((input = (br.readLine())) != null) {
      ArrayList<Integer> arr = new ArrayList<>();
      st = new StringTokenizer(input);

      int t = Integer.parseInt(st.nextToken());

      for (int i = 0; i < t; i++) {
        arr.add(Integer.valueOf(st.nextToken()));
      }

      if (arr.size() == 1) {
        sb.append("Jolly").append("\n");
        continue;
      }

      int[] num = new int[arr.size()];

      for (int i = 0; i < arr.size() - 1; i++) {
        int temp = (Math.abs(arr.get(i) - arr.get(i + 1)));
        if (temp > 0 && temp < arr.size()) {
          num[temp]++;
        }
      }

      boolean right = true;

      for (int i = 1; i < arr.size(); i++) {
        if (num[i] == 0) {
          right = false;
          break;
        }
      }

      sb.append(right ? "Jolly" : "Not jolly").append("\n");
    }

    System.out.println(sb);
  }
}