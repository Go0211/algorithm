package problem.year24.day1109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2869 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int reach = Integer.parseInt(st.nextToken()) - down;

        System.out.println(reach / (up - down) + (reach % (up - down) == 0 ? 0 : 1));
    }
}
