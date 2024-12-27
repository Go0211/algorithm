package problem.day1029;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back4779 {
	static StringBuffer sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		sb = new StringBuffer();
		
		while ((str = br.readLine()) != null && !str.isEmpty()) {
			int seq = Integer.parseInt(str);
			
			long three = (long)Math.pow(3, seq);
			
			writeBar(three, three / 3, true);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
 	}

	private static void writeBar(long three, long divideLen, boolean check) {
		if(!check) {
			if(three >= 1) {
				for (int i = 0; i < three; i++) {
					sb.append(" ");
				}
			}
			return;
		}
		if (three == 1) {
			sb.append("-");
			return;
		}
		
		writeBar(divideLen, divideLen / 3, true);
		writeBar(divideLen, divideLen / 3, false);
		writeBar(divideLen, divideLen / 3, true);
	}
}
