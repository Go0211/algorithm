package day1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back10987 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'o' || c == 'i' || c == 'u' || c == 'e') {
                count++;
            }
        }

        System.out.print(count);
    }
}
