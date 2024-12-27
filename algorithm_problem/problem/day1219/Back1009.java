package problem.day1219;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1009 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < seq; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int mul = Integer.parseInt(st.nextToken());
            int freq = Integer.parseInt(st.nextToken());
            int result = 1;

            for (int j = 0; j < freq; j++) {
                result = result * mul % 10;
            }

            sb.append(result == 0 ? 10 : result).append("\n");
        }

        System.out.println(sb);
    }
}