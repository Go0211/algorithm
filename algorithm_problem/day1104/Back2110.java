package day1104;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Back2110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int node = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		int[] arr = new int[node];
		
		for (int i = 0; i < node; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[node - 1];
		
		while (start <= end) {
			int mid = (end + start) / 2;
			int d = 1;
			int position = 0;
			
			for (int i = 1; i < node; i++) {
				if(arr[i] - arr[position] >= mid) {
					position = i;
					d++;
				}
			}
			
			if(d < count) {
				end  = mid - 1;
				continue;
			}
			
			start = mid + 1;
		}
		
		System.out.println(start - 1);
	}
}
