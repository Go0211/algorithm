import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
    int answer = 0;
    int count = 0;

    for(int i = 0; i < N; i++) {
      pq.add(Integer.parseInt(br.readLine()));
    }

    while(pq.size() != 1) {
      int node = pq.poll();
      count++;

      long cal = (long)(pq.peek() - node) * count;
      if(cal <= K) {
        K -= cal;
        continue;
      }

      answer = node + K / count;
      break;
    }

    System.out.println(answer != 0 ? answer : pq.peek() + K / (count + 1));
  }
}