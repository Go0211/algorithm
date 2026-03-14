import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int ten = a / 10;
        int one = a % 10;
        int count = 1;

        while(((one * 10) + ((ten + one) % 10)) != a) {
            int tmp = one;
            one = (ten + one) % 10;
            ten = tmp;
            count++;
        }

        System.out.println(count);
    }
}