package problem.year24.day1104;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back14425 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int gijun = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(st.nextToken());
		int count = 0;
		List<String> gijunList = new ArrayList<>();
		for (int i = 0; i < gijun; i++) {
			gijunList.add(br.readLine());
		}
		for (int i = 0; i < find; i++) {
			if(gijunList.contains(br.readLine())) count++;
		}
		
		System.out.println(count);
	}
}
