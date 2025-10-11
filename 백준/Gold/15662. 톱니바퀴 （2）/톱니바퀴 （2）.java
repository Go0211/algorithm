import java.io.*;
import java.util.*;

public class Main {
    static class Cogwheel {
        int leftIdx = 6, rightIdx = 2, topIdx = 0;
        boolean[] arr;
        StringBuilder sb;

        Cogwheel(String str) {
            this.arr = new boolean[str.length()];

            for(int i = 0; i < str.length(); i++) {
                arr[i] = (str.charAt(i) == '1');
            }
        }

        boolean top() {
            return arr[topIdx];
        }
        boolean left() {
            return arr[leftIdx];
        }
        boolean right() {
            return arr[rightIdx];
        }

        void turnRight() {
            leftIdx = (leftIdx == 0) ? arr.length - 1 : leftIdx - 1;
            rightIdx = (rightIdx == 0) ? arr.length - 1 : rightIdx - 1;
            topIdx = (topIdx == 0) ? arr.length - 1 : topIdx - 1;
        }

        void turnLeft() {
            leftIdx = (leftIdx == arr.length - 1) ? 0 : leftIdx + 1;
            rightIdx = (rightIdx == arr.length - 1) ? 0 : rightIdx + 1;
            topIdx = (topIdx == arr.length - 1) ? 0 : topIdx + 1;
        }

        public String toString() {
            return zeroToSeven().toString() + "left" + leftIdx + "/right" + rightIdx;
        }

        StringBuilder zeroToSeven() {
            sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append(arr[(topIdx + i) % 8]).append(",");
            }
            sb.append("/");
            return sb;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Cogwheel[] wheels = new Cogwheel[T];

        for(int i = 0; i < T; i++) {
            wheels[i] = new Cogwheel(br.readLine());
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            action(wheels, num, d, T);
        }

        int answer = 0;
        for(Cogwheel cw : wheels) {
            answer += cw.top()? 1 : 0;
        }

        System.out.println(answer);
    }

    static void action(Cogwheel[] wheels, int num, int d, int T) {
        int[] arr = new int[T];
        leftAction(wheels, num, d, arr, T);
        rightAction(wheels, num, d, arr, T);

        for(int i = 0; i < T; i++) {
            if(arr[i] == 1) {
                wheels[i].turnRight();
            } else if(arr[i] == -1) {
                wheels[i].turnLeft();
            }
        }
    }
    static void leftAction(Cogwheel[] wheels, int num, int d, int[] arr, int T) {
        arr[num] = d;

        if(num == 0) {
            return;
        }

        if(wheels[num].left() != wheels[num - 1].right()) {
            leftAction(wheels, num - 1, -d, arr, T);
        }
    }
    static void rightAction(Cogwheel[] wheels, int num, int d, int[] arr, int T) {
        arr[num] = d;

        if(num == T - 1) {
            return;
        }

        if(wheels[num].right() != wheels[num + 1].left()) {
            rightAction(wheels, num + 1, -d, arr, T);
        }
    }
}