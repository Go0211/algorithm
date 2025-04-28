import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        String str;
        int count;
        
        Node(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws Exception {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        for(int i = 0; i < seq; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            queue.add(
                new Node(
                    st.nextToken(), 
                    Integer.parseInt(st.nextToken())
                )
            );
        }
        
        while(queue.size() != 1) {
            Node node = queue.poll();
            int counts = node.count - 1;
            
            while(counts-- != 0) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        
        System.out.println(queue.peek().str);
    }
}