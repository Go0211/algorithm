import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));
		int seq = Integer.parseInt(br.readLine());
		Map<String, Integer> maps = new HashMap<>();

		for(int i = 0; i < seq; i++) {
			String key = br.readLine();

			if(!maps.containsKey(key)) {
				maps.put(key, 1);
				continue;
			}

			maps.put(key, maps.get(key) + 1);
		}

		List<Map.Entry<String, Integer>> list =
			new ArrayList<>(maps.entrySet());
		list.sort((x, y) -> {
			return y.getValue() - x.getValue() == 0 ?
				x.getKey().compareTo(y.getKey()) :
				y.getValue() - x.getValue();
		});

		System.out.println(list.get(0).getKey());
	}
}