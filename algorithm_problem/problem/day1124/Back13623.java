package problem.day1124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back13623 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && b == c) {
            System.out.println("*");
        } else if (a == b) {
            System.out.println("C");
        } else if (a == c) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
