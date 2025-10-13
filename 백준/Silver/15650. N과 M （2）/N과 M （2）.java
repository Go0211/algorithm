import java.io.*;
import java.util.*;

public class Main{
	static int N, R;
	static int[] a, b;
	static StringBuffer sb;
	
    public static void main(String[] args) throws Exception {
		BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = 
            new StringTokenizer(br.readLine(), " ");
		sb = new StringBuffer();
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		b = new int[R];
		for (int i = 0; i < N; i++) {
			a[i] = i + 1;
		}
		
		comb(0, 0);
		
		System.out.println(sb);
	}

	static void comb(int cnt, int start) {
		if(cnt == R) {
			for (int i : b) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			b[cnt] = a[i];
			comb(cnt + 1, i + 1);
		}
	}
}