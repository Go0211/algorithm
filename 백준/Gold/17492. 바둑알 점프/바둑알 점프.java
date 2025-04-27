import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return y == node.y && x == node.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
    
    static int[][] dirs = 
        {
            {1, 0},{1, 1},{0, 1},
            {-1, 1},{-1, 0},{-1, -1},
            {0, -1},{1, -1}
        };
    
    static String answer;
    public static void main(String[] args) throws Exception {
        answer = "Impossible";
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[][] map = new int[len][len];
        List<Node> stones = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < len; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 2) {
                    stones.add(new Node(i, j));
                }
            }
        }
        
        dfs(map, stones, len, stones.size() - 1);
        
        System.out.println(answer);
    }
    
    static void dfs(int[][] map, List<Node> stones, int len, int move) {
        if(move == 0) {
            answer = "Possible";
            return;
        }
        
        next:
        for(int i = 0; i < stones.size(); i++) {
            for(int[] dir : dirs) {
                if(answer.equals("Possible")) {
                    return;
                }
                
                int ny = stones.get(i).y + dir[0];
                int nx = stones.get(i).x + dir[1];
                int nny = ny + dir[0];
                int nnx = nx + dir[1];
            
                if(map[stones.get(i).y][stones.get(i).x] == 2 && map[ny][nx] == 2 && map[nny][nnx] == 0) {
                    List<Node> clone = new ArrayList<>(stones);
                    
                    map[stones.get(i).y][stones.get(i).x] = 0;
                    map[ny][nx] = 0;
                    map[nny][nnx] = 2;
                    
                    clone.add(new Node(nny, nnx));
                    
                    dfs(map, clone, len, move - 1);
                    map[stones.get(i).y][stones.get(i).x] = 2;
                    map[ny][nx] = 2;
                    map[nny][nnx] = 0;
                    // stones.remove(n);
                    // stones.add(nn);
                }  
            }
        }
    }
}