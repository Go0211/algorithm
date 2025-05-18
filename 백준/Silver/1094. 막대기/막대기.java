import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        
		int num = Integer.parseInt(br.readLine());
		int stick = 64;
		int count = 0;

		while (num > 0) {
			if (stick > num) {
				stick /= 2;
			} else {
				num -= stick;
				count++;
			}
		}
		System.out.println(count);
		
	}
}
 