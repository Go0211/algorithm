import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =
				new StringTokenizer(br.readLine(), " ");
		int seq = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		int count = 0;
		int box = limit;

		if (seq != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < seq; i++) {
				int book = Integer.parseInt(st.nextToken());
				if(box - book < 0) {
					box = limit - book;
					count++;
					continue;
				}

				box -= book;
			}

			System.out.println(count + 1);
		} else {
			System.out.println(0);
		}
	}
}