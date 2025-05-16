import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String target = br.readLine();
    int tLen = target.length();

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      result.append(str.charAt(i));

      // 마지막 부분이 폭탄 문자열과 같다면 삭제
      if (result.length() >= tLen) {
        boolean isMatch = true;

        for (int j = 0; j < tLen; j++) {
          if (result.charAt(result.length() - tLen + j) != target.charAt(j)) {
            isMatch = false;
            break;
          }
        }

        if (isMatch) {
          result.delete(result.length() - tLen, result.length());
        }
      }
    }

    System.out.println(result.length() == 0 ? "FRULA" : result);
  }
}