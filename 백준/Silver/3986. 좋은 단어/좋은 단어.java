import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int z = 0; z < N; z++) {
            String str = br.readLine();

            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if(stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            answer += stack.isEmpty() ? 1 : 0;
        }

        System.out.println(answer);
    }
}