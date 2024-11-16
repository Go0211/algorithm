package day1116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11943 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(a1 + b2, b1 + a2));
    }
}
