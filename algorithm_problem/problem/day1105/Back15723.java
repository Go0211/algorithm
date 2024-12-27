package problem.day1105;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Back15723 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int freq = Integer.parseInt(br.readLine());
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < freq; i++) {
			String[] arr = br.readLine().split(" is ");
			char c1 = arr[0].charAt(0);
			char c2 = arr[1].charAt(0);
			list.get(c1 - 'a').add(c2 - 'a');
		}

		freq = Integer.parseInt(br.readLine());
		for (int i = 0; i < freq; i++) {
			String[] arr = br.readLine().split(" is ");
			char c1 = arr[0].charAt(0);
			char c2 = arr[1].charAt(0);
			sb.append(bfs(list, c1 - 'a', c2 - 'a')).append("\n");
		}
		
		System.out.println(sb);
	}

	private static String bfs(List<List<Integer>> list, int start, int end) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(start);
		boolean[] v = new boolean[26];
		v[start] = true;
		
		while (!q.isEmpty()) {
			int idx = q.poll();
			
			if(idx == end) {
				return "T";
			}
			
			for (int i = 0; i < list.get(idx).size(); i++) {
				int nextIdx = list.get(idx).get(i);
				
				if(!v[nextIdx]) {
					q.add(nextIdx);
					v[nextIdx] = true;
				}
			}
		}
		
		return "F";
	}
}
