import java.util.*;
import java.io.*;

public class Main {
    static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static class Location {
        int y, x, count;
        
        Location(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        int answer = -1;
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] arr = new char[row][col];
        ArrayDeque<Location> q = new ArrayDeque<>();
        boolean[][] v = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            String str = br.readLine();
            
            for(int j = 0; j < col; j++) {
                char c = str.charAt(j);
                
                arr[i][j] = c;
                
                if(c == '2') {
                    q.offer(new Location(i, j, 0));
                    v[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Location location = q.poll();
            
            char target = arr[location.y][location.x];
            if(target == '5' || target == '4' || target == '3') {
                answer = location.count;
                break;
            }
            
            for(int[] dir : dirs) {
                int ny = location.y + dir[0];
                int nx = location.x + dir[1];
                
                if(ny >= 0 && ny < row
                  && nx >= 0 && nx < col
                  && !v[ny][nx] && arr[ny][nx] != '1') {
                    q.offer(new Location(ny, nx, location.count + 1));
                    v[ny][nx] = true;
                }
            }
        }
        
        
        if(answer == -1) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(answer);
        }
    }
}