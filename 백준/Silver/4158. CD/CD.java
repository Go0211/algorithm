import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(!(str = br.readLine()).equals("0 0")) {
            StringTokenizer st =
                    new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            int answer = 0;

            for(int i = 0; i < M; i++) {
                if(set.contains(Integer.parseInt(br.readLine()))) {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}