import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean[][] v = new boolean[100][100];
        int answer = 0;

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        for (int z = 0; z < 4; z++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    v[i][j] = true;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                answer += v[i][j] ? 1 : 0;
            }
        }

        System.out.println(answer);
    }
}