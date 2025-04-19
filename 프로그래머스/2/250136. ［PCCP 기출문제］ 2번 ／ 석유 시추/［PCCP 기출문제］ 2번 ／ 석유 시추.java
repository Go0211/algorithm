import java.util.*;
import java.io.*;

class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0},{0, 1},{0, -1}};
    static int[] arr;
    
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        arr = new int[col];
        
        boolean[][] v = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(land[i][j] == 1 && !v[i][j]) {
                    bfs(land, i, j, v);
                }
            }
        }
        
        Arrays.sort(arr);
        
        return arr[col - 1];
    }
    
    static void bfs(int[][] land, int rowIdx, int colIdx, boolean[][] v) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        Set<Integer> colSet = new HashSet<>();
        int count = 0;
        queue.offer(new int[]{rowIdx, colIdx});
        v[rowIdx][colIdx] = true;
        colSet.add(colIdx);
        
        while(!queue.isEmpty()) {
            count++;
            int[] ints = queue.poll();
            int r = ints[0];
            int c = ints[1];
            
            for(int[] dir : dirs) {
                int nextR = dir[0] + r;
                int nextC = dir[1] + c;
                
                if(nextR >= 0 && nextR < land.length
                  && nextC >= 0 && nextC < land[0].length
                  && !v[nextR][nextC] && land[nextR][nextC] == 1) {
                    queue.add(new int[]{nextR, nextC});
                    v[nextR][nextC] = true;
                    colSet.add(nextC);
                }
            }
        }
        
        for(int idx : colSet) {
            arr[idx] += count;
        }
    }
}