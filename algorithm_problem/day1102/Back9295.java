package day1102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back9295 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= seq; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sb.append("Case ")
                    .append(i)
                    .append(": ")
                    .append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
