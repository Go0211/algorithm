package problem.year25.day0109;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1072 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algorithm_problem/input.txt"));
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int totalGamePlay = Integer.parseInt(st.nextToken());
        long win = Long.parseLong(st.nextToken());
        long targetPercent = win * 100 / totalGamePlay;
        long answer = -1;

        if (win != totalGamePlay || targetPercent != 99) {
            answer = divideFind(0, 2000000000, win, totalGamePlay, targetPercent);
        }
        System.out.println(answer == -1 || answer * 100 / (totalGamePlay - win + answer) <= targetPercent ?
                -1 : answer - win);
    }

    private static long divideFind(long min, long max, long win, long totalGamePlay, long targetPercent) {
        long mid = (max + min) / 2;
        long percent = mid * 100 / (totalGamePlay - win + mid);

        if (max < min) {
            return min;
        }

        if (percent <= targetPercent) {
            return divideFind(mid + 1, max, win, totalGamePlay, targetPercent);
        } else {
            return divideFind(min, mid - 1, win, totalGamePlay, targetPercent);
        }
    }
}
