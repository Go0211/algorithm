package problem.day1206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back1075 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < 99; i++) {
            String aa = i < 10 ? "0" + i : String.valueOf(i);
            if (Long.parseLong(string.substring(0, string.length() - 2).concat(aa)) % a == 0) {
                System.out.println(aa);
                break;
            }
        }
    }
}
