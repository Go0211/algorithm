import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    String answer = null;

    for (int i = 1; i < word.length() - 1; i++) {
      for (int j = i + 1; j < word.length(); j++) {
        String part1 = new StringBuilder(word.substring(0, i)).reverse().toString();
        String part2 = new StringBuilder(word.substring(i, j)).reverse().toString();
        String part3 = new StringBuilder(word.substring(j)).reverse().toString();
        String candidate = part1 + part2 + part3;

        if (answer == null || candidate.compareTo(answer) < 0) {
          answer = candidate;
        }
      }
    }

    System.out.println(answer);
  }
}
