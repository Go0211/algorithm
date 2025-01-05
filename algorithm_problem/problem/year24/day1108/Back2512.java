package problem.year24.day1108;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back2512 {
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int seq = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[seq];
		for (int i = 0; i < seq; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int limit = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		if (Arrays.stream(arr).sum() < limit) {
			System.out.println(arr[seq - 1]);
		} else {
			divideSearch(arr, 1, arr[seq - 1], limit);
		}
	}

	private static void divideSearch(int[] arr, int min, int max, int limit) {
		while(min <= max) {
			int mid = (min + max) / 2;	
			int[] va = findSeq(arr, mid);
			int seq = va[0];
			int value = va[1];

//			System.out.println("min : " + min + " | max : " + max + " | mid : " + mid + " | value : " + value + " | seq : " + seq);
			
			if(seq * mid + value > limit) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
	}

	private static int[] findSeq(int[] arr, int mid) {
		int[] va = new int[2];
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > mid) {
				va[0] = arr.length - i;
				break;
			} else {
				va[1] += arr[i];
			}
		}
		
		return va;
	}
}
