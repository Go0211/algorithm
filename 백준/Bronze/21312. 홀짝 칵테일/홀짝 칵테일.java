import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(a%2==0 && b%2==0 && c%2==0)
            System.out.println(a*b*c);
        else {
            System.out.println(checkOddEven(a)* checkOddEven(b) *checkOddEven(c));
        }
    }

    private static int checkOddEven(int num) {
        if(num%2==1) // 홀수면
            return num;
        else return 1;
    }

}