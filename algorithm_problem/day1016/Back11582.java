import java.util.*;
import java.io.*;

class Back11582 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int freq = Integer.parseInt(br.readLine());
		
		int divideLen = len / freq;
		for (int i = 0; i < len; i+= divideLen) {
			int[] copyArr = Arrays.copyOfRange(arr, i, i + divideLen);
			Arrays.sort(copyArr);

			for (int num : copyArr) {
				sb.append(num).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}
