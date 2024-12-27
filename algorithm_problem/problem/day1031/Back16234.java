package problem.day1031;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back16234 {
	static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	static int min, max, len;
	static boolean check;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		len = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		int[][] arr = new int[len][len];
		int count = 0;
		
		for (int i = 0; i < len; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < len; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			count++;
			check = false;
			boolean[][] v = new boolean[len][len];
			
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if(!v[i][j]) {
						bfs(arr, i, j, v);
					}
				}
			}

			if (!check) {
				break;
			}
		}
		
		System.out.println(count - 1);
	}

	private static void bfs(int[][] arr, int i, int j, boolean[][] v) {
		List<int[]> rcList = new ArrayList<>();
		rcList.add(new int[]{i, j});
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i,j});
		v[i][j] = true;
		
		while (!q.isEmpty()) {
			int[] val  = q.poll();
			int y = val[0];
			int x = val[1];
			
//			System.out.println(y + " " + x);
			
			for (int[] dir : dirs) {
				int nextY = dir[0] + y;
				int nextX = dir[1] + x;
				
				if(nextY >= 0 && nextY < len && nextX >= 0 && nextX < len && !v[nextY][nextX] 
					&& min <= Math.abs(arr[y][x] - arr[nextY][nextX]) && Math.abs(arr[y][x] - arr[nextY][nextX]) <= max) {
					rcList.add(new int[] {nextY, nextX});
					v[nextY][nextX] = true;
					q.add(new int[] {nextY, nextX});
				}
			}
		}
		
		int num = cal(rcList, arr);
		for (int[] rc : rcList) {
			arr[rc[0]][rc[1]] = num;
		}
	}
	
	private static int cal(List<int[]> rcList, int[][] arr) {
		if(rcList.size() != 1 && !check) {
			check = true;
		}
		
		int total = rcList.stream()
				.mapToInt(x -> arr[x[0]][x[1]])
				.sum();
		
		return total / rcList.size();
	}
}
