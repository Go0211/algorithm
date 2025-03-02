import java.util.*;
import java.io.*;

public class Main {
  static class Node {
    int n2, d;

    Node(int n2, int d) {
      this.n2 = n2;
      this.d = d;
    }
  }

  public static void main(String[] args) throws Exception {
    //입력
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());

    //nodeCount, seq, node array, 이중 List, visited, cost Setting
    int nodeCount = Integer.parseInt(st.nextToken());
    int seq = Integer.parseInt(st.nextToken());
    String[] nodes = new String[nodeCount + 1];
    List<List<Node>> list = new ArrayList<>();
    boolean[] v = new boolean[nodeCount + 1];
    int[] cost = new int[nodeCount + 1];

    //node array에 성별 입력
    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= nodeCount; i++) {
      nodes[i] = st.nextToken();
    }

    //cost arraySetting
    Arrays.fill(cost, Integer.MAX_VALUE);

    //이중 List에 초반 세팅
    for(int i = 0; i <= nodeCount; i++) {
      list.add(new ArrayList<>());
    }
    //이중 List에 데이터 입력
    for(int i = 0; i < seq; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      list.get(a).add(new Node(b, d));
      list.get(b).add(new Node(a, d));
    }

    //mst
    int mstCount = 0;
    int total = 0;
    cost[1] = 0;
    while(true) {
      //초기 변수값 세팅
      int minVertex = -1;
      int minValue = Integer.MAX_VALUE;

      // mstCount + 1이랑 nodeCount랑 같다 -> 그럼 break;
      if(mstCount == nodeCount) {
        break;
      }
      // cost가 가장 낮은 걸 찾음
      for(int i = 1; i <= nodeCount; i++) {
        if(cost[i] != Integer.MAX_VALUE && minValue > cost[i] && !v[i]) {
          minVertex = i;
          minValue = cost[i];
        }
      }

      if (minVertex == -1) {
        break;
      }

      total += minValue;
      mstCount++;
      v[minVertex] = true;
      // 거기서 반복문으로 최소 d를 찾음
      for(int i = 0; i < list.get(minVertex).size(); i++) {
        Node nextNode = list.get(minVertex).get(i);

        if(!v[nextNode.n2] && !nodes[minVertex].equals(nodes[nextNode.n2])
            && cost[nextNode.n2] > nextNode.d) {
          cost[nextNode.n2] = nextNode.d;
        }
      }
    }

    //출력
    if(mstCount == nodeCount) {
      System.out.println(total);
    } else {
      System.out.println(-1);
    }
  }
}