import java.util.*;
import java.io.*;

public class Main {
    static class YX {
        int y, x;
        
        YX(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int[][] dirs = 
        {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        List<YX> xList = new ArrayList<>();
        List<YX> tList = new ArrayList<>();
        boolean isYes = false;
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < N; j++) {
                char c = st.nextToken().charAt(0);
                
                if(c == 'X') {
                    xList.add(new YX(i, j));
                } else if(c == 'T') {
                    tList.add(new YX(i, j));
                }
                
                arr[i][j] = c;
            }
        }
        
        int size = xList.size();
        
        end:
        for(int i = 0; i < size; i++) {
            YX yx1 = xList.get(i);
            for(int j = i + 1; j < size; j++) {
                YX yx2 = xList.get(j);
                for(int k = j + 1; k < size; k++) {
                    YX yx3 = xList.get(k);
                    
                    arr[yx1.y][yx1.x] = 'w';
                    arr[yx2.y][yx2.x] = 'w';
                    arr[yx3.y][yx3.x] = 'w';
                    if(checkAvoid(arr, tList, N)) {
                        isYes = true;
                        break end;
                    }
                    arr[yx1.y][yx1.x] = 'X';
                    arr[yx2.y][yx2.x] = 'X';
                    arr[yx3.y][yx3.x] = 'X';
                }
            }
        }
        
        System.out.println(isYes ? "YES" : "NO");
    }
    
    static boolean checkAvoid(char[][] arr, List<YX> list, int N) {
        for(YX yx : list) {
            int y = yx.y;
            int x = yx.x;
            
            next:
            for(int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                
                while(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if(arr[ny][nx] == 'S') {
                        return false;
                    } else if (arr[ny][nx] == 'w') {
                        continue next;
                    }
                    
                    ny += dir[0];
                    nx += dir[1];
                }
            }
        }
        
        return true;
    }
}