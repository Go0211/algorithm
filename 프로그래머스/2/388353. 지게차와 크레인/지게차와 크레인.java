import java.util.*;

class Solution {
    static int[][] dirs = 
        {{1, 0},{-1, 0},{0, -1},{0, 1}};
    
    public int solution(String[] storage, String[] requests) {
        int R = storage.length;
        int C = storage[0].length();
        char[][] arr = new char[R][C];
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                arr[i][j] = storage[i].charAt(j);
            }
        }
        
        for(String str : requests) {
            List<int[]> list = new ArrayList<>();
            
            char c = str.charAt(0);
            if(str.length() == 1) {
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(c == arr[i][j]) {
                            if(bfs(arr, i, j, R, C, new boolean[R][C])) {
                                list.add(new int[]{i, j});
                            }
                        }
                    }
                }
                
                for(int[] ints : list) {
                    arr[ints[0]][ints[1]] = ' ';
                }
            } else {
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(c == arr[i][j]) {
                            arr[i][j] = ' ';
                        }
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] != ' ') answer++;
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
        
        return answer;
    }
    
    static boolean bfs(char[][] arr, int r, int c, int R, int C, boolean[][] v) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        v[r][c] = true;
        
        while(!queue.isEmpty()) {
            int[] ints = queue.poll();
            int pr = ints[0];
            int pc = ints[1];
            
            for(int[] dir : dirs) {
                int nr = dir[0] + pr;
                int nc = dir[1] + pc;
                
                if(nr >= 0 && nr < R
                  && nc >= 0 && nc < C
                  && arr[nr][nc] == ' ' && !v[nr][nc]) {
                    queue.offer(new int[]{nr, nc});
                    v[nr][nc] = true;
                }
                
                if(!(nr >= 0 && nr < R
                  && nc >= 0 && nc < C)) {
                    return true;
                }
            }
        }
            
        return false;
    }
}