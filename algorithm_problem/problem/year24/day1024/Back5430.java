package problem.year24.day1024;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 반복문 변수도 그냥 네이밍해서 하기 -> 변수이름 헷갈림
public class Back5430 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int freq = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		next:
		for (int i = 0; i < freq; i++) {
			String order = br.readLine();
			int seq = Integer.parseInt(br.readLine());
			String inputs = br.readLine();
			inputs = inputs.replace("[", "").replace("]", "").trim();
			
			List<String> list =  Arrays.stream(inputs.split(","))
					.collect(Collectors.toList());
			boolean idx = true;
			
			for (int j = 0; j < order.length(); j++) {
				char c = order.charAt(j);
				if (c == 'R') {
					idx = !idx;
				} else {
					if(list.size() == 0) {
						sb.append("error").append("\n");
						continue next;
					} else {
						if (idx) {
							if(list.get(0).equals("")) {
								sb.append("error").append("\n");
								continue next;
							}
							list.remove(0);
						} else {
							if(list.get(list.size() - 1).equals("")) {
								sb.append("error").append("\n");
								continue next;
							}
							list.remove(list.size() - 1);
						}
					}
				}
			}
			
			sb.append("[");
			if (idx) {
				sb.append(String.join(",", list));
			} else {
				for (int j = 0; j < list.size() / 2; j++) {
					String temp = list.get(j);
					list.set(j, list.get(list.size() - (j + 1)));
					list.set(list.size() - (j + 1), temp);
				}
				sb.append(String.join(",", list));
			}
			sb.append("]").append("\n");
		}
		
		System.out.println(sb);
	}
}
