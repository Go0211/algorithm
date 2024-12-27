package problem.day1106;

import java.io.*;

public class Back2577 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String total = String.valueOf(a * b * c);
        int[] arr = new int[10];
        for(int i = 0; i < total.length(); i++) {
            int idx = total.charAt(i) - '0';
            arr[idx]++;
        }
        
        for(int i : arr) {
            System.out.println(i);
        }
	}
}
