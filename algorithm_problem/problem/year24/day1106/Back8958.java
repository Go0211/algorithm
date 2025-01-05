package problem.year24.day1106;

import java.io.*;

public class Back8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int seq = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        for(int z = 0; z < seq; z++) {
            String str = br.readLine();
            int count = 1;
            int score = 0;
            
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'O') {
                    score += count;
                    count++;
                } else {
                    count = 1;
                }
            }
            
            sb.append(score).append("\n");
        }
        
        System.out.println(sb);
	}
}

