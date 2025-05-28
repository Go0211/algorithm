import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        boolean sk = true;
        while (num != 0) {
            if (num > 3) {
                num -= 3;
                sk = !sk;
            } else {
                num -= 1;
                sk = !sk;
            }
        }

        if (!sk) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
