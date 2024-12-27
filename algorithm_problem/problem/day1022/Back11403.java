package problem.day1022;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Back11403 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> list = new ArrayList<>();
		
		int seq = Integer.parseInt(br.readLine());
		int[][] maps = new int[seq][seq];
		for (int i = 0; i < seq; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < maps.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < maps.length; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps.length; j++) {
				if(maps[i][j] == 1) {
					list.get(i).add(j);
				}
			}
		}
		
		for (int i = 0; i < maps.length; i++) {
			bfs(maps, list, i, seq);
		}
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps.length; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs(int[][] maps, List<List<Integer>> list, int i, int seq) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[seq];
		for (int j : list.get(i)) {
			q.add(j);
		}
		
		while (!q.isEmpty()) {
			int num = q.poll();
			
			for (int j : list.get(num)) {
				if(!v[j]) {
					v[j] = true;
					maps[i][j] = 1;
					q.add(j);
				}
			}
		}
	}
}
