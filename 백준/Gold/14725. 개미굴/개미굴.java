import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    
    static class Node {
        Map<String, Node> nodes;
        
        Node() {
            nodes = new TreeMap<>();
        }
    }
    
    static class Trie {
        Node trie;
        
        Trie() {
            trie = new Node();
        }
        
        void insert(String[] arr) {
            Node n = trie;
            
            for(int i = 1; i < arr.length; i++) {
                if(!n.nodes.containsKey(arr[i])) {
                    n.nodes.put(arr[i], new Node());
                }
                n = n.nodes.get(arr[i]);
            }
        }
        
        void searchAll(Node n, int count) {
            for(String key : n.nodes.keySet()) {
                for(int i = 0; i < count; i++) {
                    sb.append("--");
                }
                
                sb.append(key).append("\n");
                if(!n.nodes.get(key).nodes.isEmpty()) {
                    searchAll(n.nodes.get(key), count + 1);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int seq = Integer.parseInt(br.readLine());
        PriorityQueue<String[]> pq = 
            new PriorityQueue<>((x, y) -> sortStringArray(x, y));
        Trie t = new Trie();
        
        // 순서대로 pq에 담기
        for(int z = 0; z < seq; z++) {
            pq.add(br.readLine().split(" "));
        }
        
        //pq 전체 poll해서 trie에 삽입
        while(!pq.isEmpty()) {
            t.insert(pq.poll());
        }
        
        //search all을 통해 출력
        t.searchAll(t.trie, 0);
        
        System.out.println(sb);
    }
    
    // 입력받은 배열을 1번 idx부터 사전순으로 비교
    // 안되면 그냥 길이가 작은 걸로
    static int sortStringArray(String[] x, String[] y) {
        int min = Math.min(x.length, y.length);
        
        for(int i = 1; i < min; i++) {
            if(x[i].compareTo(y[i]) != 0) {
                return x[i].compareTo(y[i]);
            }
        }
        
        return x.length < y.length ? -1 : 1;
    }
}