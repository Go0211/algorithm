import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
		HashMap<Integer, Integer> problemToLevel = new HashMap<>();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			map.putIfAbsent(l, new TreeSet<>());
			map.get(l).add(p);
			problemToLevel.put(p, l);
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());

				map.putIfAbsent(l, new TreeSet<>());
				map.get(l).add(p);
				problemToLevel.put(p, l);
			} else if (command.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					int maxLevel = map.lastKey();
					int maxProblem = map.get(maxLevel).last();
					sb.append(maxProblem).append("\n");
				} else {
					int minLevel = map.firstKey();
					int minProblem = map.get(minLevel).first();
					sb.append(minProblem).append("\n");
				}
			} else if (command.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());
				int level = problemToLevel.get(p);
				map.get(level).remove(p);
				if (map.get(level).isEmpty()) {
					map.remove(level);
				}
				problemToLevel.remove(p);
			}
		}

		System.out.print(sb);
	}
}
