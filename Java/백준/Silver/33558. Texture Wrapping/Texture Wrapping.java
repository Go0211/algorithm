import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int NN = Integer.parseInt(st.nextToken());
        int MM = Integer.parseInt(st.nextToken());

        char[][] resultMap = new char[N][M];
        char[][] tMap = new char[NN][MM];

        //텍스쳐가 모자른 지 판단
//        if (N <= NN && M <= MM) {
//            // 안모자름
//            // resultMap에 tMap을 그대로 대입 (왼왼부터)
//            for (int i = 0; i < NN; i++) {
//                if (N < NN) {
//                    br.readLine();
//                    continue;
//                }
//
//                String str = br.readLine();
//                for (int j = 0; j < M; j++) {
//                    resultMap[i][j] = str.charAt(j);
//                }
//            }
//        }
        // 모자름
//        else {
        for (int i = 0; i < NN; i++) {
            String str = br.readLine();
            for (int j = 0; j < MM; j++) {
                tMap[i][j] = str.charAt(j);
            }
        }

        String jogun = br.readLine();
        // switch로 조건
        switch (jogun) {
            case "clamp-to-edge":
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (i >= NN && j >= MM) {
                            resultMap[i][j] = resultMap[i - 1][j - 1];
                        } else if (i >= NN) {
                            resultMap[i][j] = resultMap[i - 1][j];
                        } else if (j >= MM) {
                            resultMap[i][j] = resultMap[i][j - 1];
                        } else {
                            resultMap[i][j] = tMap[i][j];
                        }
                    }
                }
                break;
            case "repeat":
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        resultMap[i][j] = tMap[i % NN][j % MM];
                    }
                }
                break;
            case "mirrored-repeat":
                char[][] reverseArr = new char[NN * 2][MM * 2];

                for (int i = 0; i < NN; i++) {
                    for (int j = 0; j < MM; j++) {
                        reverseArr[i][j] = tMap[i][j];
                        reverseArr[i][MM * 2 - (j + 1)] = tMap[i][j];
                        reverseArr[NN * 2 - (i + 1)][j] = tMap[i][j];
                        reverseArr[NN * 2 - (i + 1)][MM * 2 - (j + 1)] = tMap[i][j];
                    }
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int ii = i >= NN * 2 ? i % (NN * 2) : i;
                        int jj = j >= MM * 2 ? j % (MM * 2) : j;

                        resultMap[i][j] = reverseArr[ii][jj];
                    }
                }
                break;
        }
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(resultMap[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}