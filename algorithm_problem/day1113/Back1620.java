package day1113;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Back1620 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int seq1 = Integer.parseInt(st.nextToken());
		int seq2 = Integer.parseInt(st.nextToken());
		Map<String, String> maps = new HashMap<>();
		
		for (int i = 0; i < seq1; i++) {
			String pocketMon = br.readLine();
			String idx = (i + 1) + "";
			maps.put(idx, pocketMon);
			maps.put(pocketMon, idx);
		}
		
		for (int i = 0; i < seq2; i++) {
			sb.append(maps.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
}
