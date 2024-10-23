package day1023;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Back1987 {
	static int answer = 0;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		boolean[][] v = new boolean[R][C];
		v[0][0] = true;
		dfs(arr, 0, 0, new HashMap<>(), v, 1);
		
		System.out.println(answer);
	}

	private static void dfs(char[][] arr, int y, int x, Map<Character, Integer> maps, boolean[][] v, int count) {
		maps.put(arr[y][x], (maps.containsKey(arr[y][x]) ? maps.get(arr[y][x]) + 1 : 1));
		
		if(maps.get(arr[y][x]) != 1) {
			answer = Math.max(answer, count - 1);
			
//			System.out.println("map : " + maps);
//			for (boolean[] vv : v) {
//				System.out.println(Arrays.toString(vv));
//			}
//			System.out.println();
			
			return;
		}
		
		for (int[] dir : dirs) {
			int nextY = y + dir[0];
			int nextX = x + dir[1];
			
			if(nextY >= 0 && nextY < arr.length && nextX >= 0 && nextX < arr[0].length && !v[nextY][nextX]) {
				v[nextY][nextX] = true;
				dfs(arr, nextY, nextX, maps, v, count + 1);
				maps.put(arr[nextY][nextX], maps.get(arr[nextY][nextX]) - 1);
				v[nextY][nextX] = false;
			}
		}
		
		answer = Math.max(answer, count);
	}
}
