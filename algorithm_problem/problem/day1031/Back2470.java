package problem.day1031;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back2470 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int seq = Integer.parseInt(br.readLine());
		int[] arr = new int[seq];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < seq; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int startIdx = 0;
		int endIdx = seq - 1;
		long answer = Long.MAX_VALUE;
		int[] ra = new int[2];
		
		while (startIdx != endIdx) {
			int value = arr[startIdx] + arr[endIdx];

			if(Math.abs(value) < answer) {
				answer = Math.min(Math.abs(value), answer);
				ra[0] = arr[startIdx];
				ra[1] = arr[endIdx];
			}
			
			if(value < 0) {
				startIdx++;
			} else if(value > 0) {
				endIdx--;
			} else {
				break;
			}
		}
		
		System.out.println(ra[0] + " " + ra[1]);
	}
}
