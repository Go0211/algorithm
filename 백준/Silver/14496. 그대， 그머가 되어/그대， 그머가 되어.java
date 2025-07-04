import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =
				new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine(), " ");
		int nodes = Integer.parseInt(st.nextToken());
		int seq = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;

		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i < nodes; i++) {
			list.add(new ArrayList<>());
		}

		for(int i = 0; i < seq; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			list.get(a).add(b);
			list.get(b).add(a);
		}

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		boolean[] v = new boolean[nodes];
		queue.add(new int[]{start, 0});
		v[start] = true;

		while (!queue.isEmpty()) {
			int[] ints = queue.pop();

			int index = ints[0];
			int count = ints[1];

			if (end == index) {
				answer = count;
				break;
			}

			List<Integer> set = list.get(index);
			for (int idx : set) {
				if (!v[idx]) {
					v[idx] = true;
					queue.add(new int[]{idx, count + 1});
				}
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}