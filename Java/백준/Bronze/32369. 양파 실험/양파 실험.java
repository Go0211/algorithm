import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =
			new StringTokenizer(br.readLine());
		int day = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		boolean change = false;
		int aa = 1;
		int bb = 1;

		while(day-- > 0) {
			if(!change) {
				aa += a;
				bb += b;
			} else {
				aa += b;
				bb += a;
			}

			if(!change && aa < bb) {
				change = true;
			}
			if(change && aa > bb) {
				change = false;
			}

			if(aa == bb) {
				if(!change) {
					bb--;
				} else {
					aa--;
				}
			}
		}

		System.out.println(!change ? aa + " " + bb : bb + " " + aa);
	}
}