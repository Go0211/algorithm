import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
	  Set<Character> sets = new HashSet<>(Arrays.asList('M', 'O', 'B', 'I', 'S'));
    String str = br.readLine();
    for (int i = 0; i < str.length(); i++) {
      if (sets.contains(str.charAt(i))) {
        sets.remove(str.charAt(i));
      }
    }

    System.out.println(sets.isEmpty() ? "YES" : "NO");
  }
}

