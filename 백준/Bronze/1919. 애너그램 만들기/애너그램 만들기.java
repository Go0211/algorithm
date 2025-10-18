import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];

        String str1 = br.readLine();
        String str2 = br.readLine();

        for(int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i) - 'a']--;
        }

        int answer = 0;
        for(int i : arr) {
            answer += Math.abs(i);
        }

        System.out.println(answer);
    }
}