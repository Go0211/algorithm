import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		final long N = 1_000_000_009;
		StringBuilder sb = new StringBuilder();
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		int seq = Integer.parseInt(br.readLine());
		long[] arr = new long[1_000_000];

		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		for(int i = 3; i < 1_000_000; i++) {
			arr[i] = (arr[i - 3] + arr[i - 2] + arr[i - 1]) % N;
		}

		for(int i = 0; i < seq; i++) {
			sb.append(arr[Integer.parseInt(br.readLine()) - 1]).append("\n");
		}

		System.out.print(sb);
	}
}