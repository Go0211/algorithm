import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static class Node {
        int max, min;

        Node(int max, int min) {
            this.max = max;
            this.min = min;
        }

        public String toString() {
            return max + " " + min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(br.readLine());
        int[][] arr = new int[depth][3];
        Node[][] mmArr = new Node[depth][3];
        for (int i = 0; i < depth; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            mmArr[0][i] = new Node(arr[0][i], arr[0][i]);
        }

        for (int i = 1; i < depth; i++) {
            mmArr[i][0] =
                    new Node(
                            Math.max(mmArr[i - 1][0].max + arr[i][0], mmArr[i - 1][1].max + arr[i][0]),
                            Math.min(mmArr[i - 1][0].min + arr[i][0], mmArr[i - 1][1].min + arr[i][0]));
            mmArr[i][1] =
                    new Node(
                            Math.max(mmArr[i - 1][2].max + arr[i][1],
                                    Math.max(mmArr[i - 1][0].max + arr[i][1], mmArr[i - 1][1].max + arr[i][1])),
                            Math.min(mmArr[i - 1][2].min + arr[i][1],
                                    Math.min(mmArr[i - 1][0].min + arr[i][1], mmArr[i - 1][1].min + arr[i][1])));
            mmArr[i][2] =
                    new Node(
                            Math.max(mmArr[i - 1][2].max + arr[i][2], mmArr[i - 1][1].max + arr[i][2]),
                            Math.min(mmArr[i - 1][2].min + arr[i][2], mmArr[i - 1][1].min + arr[i][2])
                    );
        }

        for (Node n : mmArr[depth - 1]) {
            max = Math.max(max, n.max);
            min = Math.min(min, n.min);
        }

        System.out.println(max + " " + min);
    }
}