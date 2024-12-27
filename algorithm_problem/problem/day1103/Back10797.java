package problem.day1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back10797 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[5];
        int count = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : arr) {
            if (i == num) {
                count ++;
            }
        }

        System.out.println(count);
    }
}
