package problem.year24.day1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Back4949 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuffer sb = new StringBuffer();
		
		next :
		while((str = br.readLine()) != null && !str.isEmpty() && !str.equals(".")) {
			ArrayDeque<Character> stack  = new ArrayDeque<>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						sb.append("no\n");
						continue next;
					}
				} else if (c == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						sb.append("no\n");
						continue next;
					}
				} else if (c == '.') {
					if(stack.size() == 0) {
						sb.append("yes\n");
						continue next;
					} else {
						sb.append("no\n");
						continue next;
					}
				}
			}
		}
		
		System.out.println(sb);
	}
}
