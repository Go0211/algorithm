package problem.day1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back13752 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            int b = Integer.parseInt(br.readLine());
            for (int j = 0; j < b; j++) {
                sb.append("=");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
