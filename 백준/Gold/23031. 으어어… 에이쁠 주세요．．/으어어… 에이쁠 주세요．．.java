import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs8 = {
        {-1, -1},{-1, 0},{-1, 1},
        {0, -1},{0, 0},{0, 1},
        {1, -1},{1, 0},{1, 1}
    };
    
    static class Node {
        int y, x, d;
        int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
        
        Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
        
        void turnR() {
            d = d - 1 < 0 ? 3 : d - 1;
        }
        void turnL() {
            d = (d + 1) % 4;
        }
        void forward(int N) {
            int ny = y + dirs[d][0];
            int nx = x + dirs[d][1];
            
            if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                y = ny;
                x = nx;
            }
        }
        
        void turnZombie(int N) {
            int ny = y + dirs[d][0];
            int nx = x + dirs[d][1];
            
            if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                y = ny;
                x = nx;
            } else {
                d = (d + 2) % 4;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] moves = br.readLine().toCharArray();
        // 0 -> 아래쪽보는 좀비 유무
        // 1 -> 오른쪽보는 좀비 유무
        // 2 -> 위쪽보는 좀비 유무
        // 3 -> 왼쪽보는 좀비 유무
        // 4 -> 불빛 유무
        // 5 -> 스위치 유무
        boolean[][][] arr = new boolean[N][N][6];
        List<Node> zombies = new ArrayList<>();
        Node ari = new Node(0, 0, 0);
        boolean isAh = false;
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                char c = str.charAt(j);
                if(c == 'Z') {
                    zombies.add(new Node(i, j, 0));
                    arr[i][j][0] = true;
                } else if (c == 'S') {
                    arr[i][j][5] = true;
                }
            }
        }
        
        
        for(char c : moves) {
            // 아리 이동
            if(c == 'R') {
                ari.turnR();
            } else if(c == 'L') {
                ari.turnL();
            } else {
                ari.forward(N);
            }
            
            // 스위치가 있다면 불빛 키기
            if(arr[ari.y][ari.x][5]) {
                for(int[] dir : dirs8) {
                    int ny = dir[0] + ari.y;
                    int nx = dir[1] + ari.x;
                    
                    if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                        arr[ny][nx][4] = true; 
                    }
                }
            }
            
            // 현재 같은 위치 좀비? + 불빛 유무
            if((arr[ari.y][ari.x][0] || arr[ari.y][ari.x][1] 
                || arr[ari.y][ari.x][2] || arr[ari.y][ari.x][3]) 
               && !arr[ari.y][ari.x][4]) {
                isAh = true;
                break;
            }
            
            // 좀비 이동
            for(Node zombie : zombies) {
                arr[zombie.y][zombie.x][zombie.d] = false;
                zombie.turnZombie(N);
                arr[zombie.y][zombie.x][zombie.d] = true;
            }
            
            // 현재 같은 위치 좀비? + 불빛 유무
            if((arr[ari.y][ari.x][0] || arr[ari.y][ari.x][1] 
                || arr[ari.y][ari.x][2] || arr[ari.y][ari.x][3]) 
               && !arr[ari.y][ari.x][4]) {
                isAh = true;
                break;
            }
        }
        
        System.out.println(isAh ? "Aaaaaah!" : "Phew...");
    }
}