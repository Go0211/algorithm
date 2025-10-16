import java.io.*;
import java.util.*;

public class Main{
	static StringBuffer sb;
	public static void main(String[] args) throws Exception{
		sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		int seq = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[num + 1];
		
		List<Integer>[] list = new ArrayList[num + 1];
		for (int i = 1; i <= num; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < seq; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 1; i < list.length; i++) {
			list[i].sort((x, y) -> Integer.compare(x, y));
		}
		
		dfs(list, start, new boolean[num + 1]);
		sb.append("\n");
		bfs(list, start, v);
		
		System.out.println(sb);
	}

	static void dfs(List<Integer>[] list, int idx, boolean[] v) {
		v[idx] = true;
		sb.append(idx).append(" ");
		
		for(int a : list[idx]) {
			if(!v[a]) {
				dfs(list, a, v);
			}
		}
	}

	static void bfs(List<Integer>[] list, int start, boolean[] v) {
		// TODO Auto-generated method stub
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		v[start] = true;
		sb.append(start).append(" ");
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			
			for(int a : list[idx]) {
				if(!v[a]) {
					q.offer(a);
					sb.append(a).append(" ");
					v[a] = true;
				}
			}
		}
	}
} 