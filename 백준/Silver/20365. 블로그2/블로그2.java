import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());
    String str = br.readLine();
    int answer = 1;

    // 양 끝이 동일 하면, 그냥 거기서 다른 것의 연속성 판단 후 count
    if (str.charAt(0) == str.charAt(len - 1)) {
      char c = str.charAt(0);
      boolean notC = false;

      for (int i = 1; i < len - 1; i++) {
        if (str.charAt(i) != c) {
          if (!notC) {
            notC = true;
            answer++;
          }
        } else if (notC) {
          notC = false;
        }
      }

      System.out.println(answer);
    } else {
      int[] twoPointer_B = {-1, -1};
      int[] twoPointer_R = {-1, -1};

      for (int i = 0; i < len; i++) {
        if (twoPointer_B[0] != -1 && twoPointer_R[0] != -1) {
          break;
        } else if (str.charAt(i) == 'B' && twoPointer_B[0] == -1) {
          twoPointer_B[0] = i;
        } else if (str.charAt(i) == 'R' && twoPointer_R[0] == -1) {
          twoPointer_R[0] = i;
        }
      }

      for (int i = len - 1; i >= 0; i--) {
        if (twoPointer_B[1] != -1 && twoPointer_R[1] != -1) {
          break;
        } else if (str.charAt(i) == 'B' && twoPointer_B[1] == -1) {
          twoPointer_B[1] = i;
        } else if (str.charAt(i) == 'R' && twoPointer_R[1] == -1) {
          twoPointer_R[1] = i;
        }
      }

      int answerB = 2;
      int answerR = 2;
      int startB = twoPointer_B[0];
      int endB = twoPointer_B[1];
      boolean isB = true;
      for (int i = startB + 1; i < endB; i++) {
        if (str.charAt(i) != 'B') {
          if (isB) {
            isB = false;
            answerB++;
          }
        } else if (!isB) {
          isB = true;
        }
      }

      int startR = twoPointer_R[0];
      int endR = twoPointer_R[1];
      isB = false;
      for (int i = startR; i < endR; i++) {
        if (str.charAt(i) != 'R') {
          if (!isB) {
            isB = true;
            answerR++;
          }
        } else if (isB) {
          isB = false;
        }
      }

      System.out.println(Math.min(answerR, answerB));
    }
  }
}