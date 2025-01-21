import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    
    int result = 0;
    while (true) {
      int num = Integer.parseInt(br.readLine());
      if (num == -1) {
        break;
      }

      result += num;
    }

    System.out.println(result);
  }
}
