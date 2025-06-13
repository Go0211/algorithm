import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    int answer = 240;

    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    List<Integer> list = new ArrayList<>();
    List<PriorityQueue<Integer>> pqList = new ArrayList<>();
    for(int i = 0; i < 5; i++) {
      list.add(Integer.parseInt(st.nextToken()));
      pqList.add(new PriorityQueue<>((x, y) -> x - y));
    }

    for(int i = 0; i < seq; i++) {
      st = new StringTokenizer(br.readLine());
      pqList.get(Integer.parseInt(st.nextToken()) - 1)
          .offer(Integer.parseInt(st.nextToken()));
    }

    for(int i = 0; i < 5; i++) {
      int freq = list.get(i);
      int before = 0;

      while(freq > 0) {
        freq--;

        int outer = pqList.get(i).poll();
        answer += outer;
        if(before != 0) {
          answer += Math.abs(outer - before);
        }
        before = outer;
      }
    }

    System.out.println(answer);
  }
}