import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < N; i++) {
      list1.add(Integer.parseInt(st.nextToken()));
    }

    int count = 0;
    while(N != 0) {
      if(list1.contains(N)) {
        while(true) {
          int num = list1.remove(list1.size() - 1);
          count++;

          if(num == N) {
            sb.append("1 3").append("\n");
            break;
          } else {
            list2.add(num);
            sb.append("1 2").append("\n");
          }
        }
      } else if(list2.contains(N)) {
        while(true) {
          int num = list2.remove(list2.size() - 1);
          count++;

          if(num == N) {
            sb.append("2 3").append("\n");
            break;
          } else {
            list1.add(num);
            sb.append("2 1").append("\n");
          }
        }
      }

      N--;
    }
    System.out.println(count);
    System.out.print(sb);
  }
}