package problem.year24.day1106;

import java.io.*;

public class Back2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        if(str.equals("1 2 3 4 5 6 7 8")) {
            System.out.println("ascending");
        } else if(str.equals("8 7 6 5 4 3 2 1")) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
	}
}