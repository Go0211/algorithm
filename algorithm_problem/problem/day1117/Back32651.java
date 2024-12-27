package problem.day1117;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back32651 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(num <= 100_000 && num % 2024 == 0? "Yes" : "No");
    }
}
