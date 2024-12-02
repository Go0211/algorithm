package day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back32775 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        System.out.println(a > b ? "flight" : "high speed rail");
    }
}
