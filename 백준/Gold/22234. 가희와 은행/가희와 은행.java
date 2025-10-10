import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx, time, afterTime;

        Node(int idx, int time, int afterTime) {
            this.idx = idx;
            this.time = time;
            this.afterTime = afterTime;
        }

        public int compareTo(Node n) {
            return this.afterTime > n.afterTime ? 1 : -1;
        }
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int spendTime = 0;

        // 은행업무 처리 Queue
        ArrayDeque<Node> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.offer(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    0
            ));
        }

        int M = Integer.parseInt(br.readLine());
        // 영업 후 사람들 PQ
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pq.offer(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        end:
        while(!queue.isEmpty()) {
            // Queue peek값 가져오기
            Node node = queue.poll();

            // T >= tx면 tx만큼 sb.append(idx).append("\n"); 후 삭제
            if(T >= node.time) {
                for(int i = 0; i < node.time; i++) {
                    sb.append(node.idx).append("\n");
                    spendTime++;

                    // 근데, 입력하는 과정에서 W보다 커지면 break;
                    if(spendTime == W) {
                        break end;
                    }
                }
            }
            // T < tx면 T만큼 sb.append(idx).append("\n");
            else {
                for(int i = 0; i < T; i++) {
                    sb.append(node.idx).append("\n");
                    spendTime++;

                    // 근데, 입력하는 과정에서 W보다 커지면 break;
                    if(spendTime == W) {
                        break end;
                    }
                }
            }

            // PQ에서 해당 시간이랑 같거나 작은 node들을 다 맨뒤에 저장
            while(!pq.isEmpty() && pq.peek().afterTime <= spendTime) {
                queue.offer(pq.poll());
            }

            // T < tx였을 때, node를 뒤에 저장
            if(T < node.time) {
                node.time -= T;
                queue.offer(node);
            }
        }

        System.out.println(sb);
    }
}