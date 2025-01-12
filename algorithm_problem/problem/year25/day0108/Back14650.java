package problem.year25.day0108;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Back14650 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[] arr = new char[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = String.valueOf(i).charAt(0);
        }

        List<char[]> list = new ArrayList<>();
        perm(arr, new char[size], list, 0, size);
        int result = 0;

        for (char[] chars : list) {
            if (chars[0] == '0') {
                continue;
            }

            int num = Integer.parseInt(new String(chars));

            if (num % 3 == 0) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void perm(char[] arr, char[] chars, List<char[]> list, int charsIdx, int size) {
        if (charsIdx == size) {
            list.add(chars);
            return;
        }

        for (int i = 0; i < 3; i++) {
            chars[charsIdx] = arr[i];
            perm(arr, chars.clone(), list, charsIdx + 1, size);
        }
    }
}
