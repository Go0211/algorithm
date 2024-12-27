package problem.day1130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back15059 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int a3 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int b3 = Integer.parseInt(st.nextToken());

        System.out.println((b1 - a1 >= 0 ? b1 - a1 : 0) + (b2 - a2 >= 0 ? b2 - a2 : 0) + (b3 - a3 >= 0 ? b3 - a3 : 0));
    }
}
