import java.util.*;
import java.io.*;

class Back2206_use3dArray {
	static int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws Exception{
		int answer = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] maps = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				maps[i][j] = c;
			}
		}

		answer = Math.min(bfs(maps, 0, 0, R-1, C-1, R, C), answer);
		answer = Math.min(bfs(maps, R-1, C-1, 0, 0, R, C), answer);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static int bfs(char[][] maps, int startY, int startX, int endY, int endX, int R, int C) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startY, startX, 1, 0});
		boolean[][][] v = new boolean[R][C][2];
		v[startY][startX][0] = true;			// 그냥 접근 0, 부수고 이동 1
		int answer = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] val = q.poll();
			int y = val[0];
			int x = val[1];
			int moveCount = val[2];
			int brokeCount = val[3];
			
			if(y == endY && x == endX) {
				answer = Math.min(answer, moveCount);
			}
			
			for(int[] dir : dirs) {
				int nextY = dir[0] + y;
				int nextX = dir[1] + x;
				
				if(nextY >= 0 && nextY < R && nextX >= 0 && nextX < C && !v[nextY][nextX][0]) {
					if(maps[nextY][nextX] == '1' && !v[nextY][nextX][1] && brokeCount == 0) {
						q.offer(new int[] {nextY, nextX, moveCount + 1, brokeCount + 1});
						v[nextY][nextX][0] = true;
						v[nextY][nextX][1] = true;
					} else if(maps[nextY][nextX] == '0') {
						q.offer(new int[] {nextY, nextX, moveCount + 1, brokeCount});
						v[nextY][nextX][0] = true;
					}
				}
			}
		}
		
		return answer;
	}
}
