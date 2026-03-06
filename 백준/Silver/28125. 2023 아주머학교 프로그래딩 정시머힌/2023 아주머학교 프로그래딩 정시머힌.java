import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] chArr = br.readLine().toCharArray();

            int passwordCnt = 0;
            int slashCount = 0;

            StringBuilder tempString = new StringBuilder();
            for (char ch : chArr) {

                if (ch == '@') {
                    passwordCnt++;
                    tempString.append('a');
                } else if (ch == '[') {
                    passwordCnt++;
                    tempString.append('c');
                } else if (ch == '!') {
                    passwordCnt++;
                    tempString.append('i');
                } else if (ch == ';') {
                    passwordCnt++;
                    tempString.append('j');
                } else if (ch == '^') {
                    passwordCnt++;
                    tempString.append('n');
                } else if (ch == '0') {
                    passwordCnt++;
                    tempString.append('o');
                } else if (ch == '7') {
                    passwordCnt++;
                    tempString.append('t');
                } else if (ch == '\\') {
                    slashCount++;
                } else if (slashCount == 1 && ch == '\'') {
                    slashCount = 0;
                    passwordCnt++;
                    tempString.append('v');
                } else if (slashCount == 1 && ch == '\\') {
                    slashCount++;
                } else if (slashCount == 2 && ch == '\'') {
                    slashCount = 0;
                    passwordCnt++;
                    tempString.append('w');
                } else {
                    // 암호가 아닌 경우
                    tempString.append(ch);
                }
            }

            int tempLen = tempString.length();
            if(tempLen % 2 == 1) {
                tempLen += 1;
            }

            if (tempLen / 2 <= passwordCnt) {
                sb.append("I don't understand").append('\n');
            } else {
                sb.append(tempString).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main
} // End of Main class