import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    ArrayDeque<String> bStack = new ArrayDeque<>();
    ArrayDeque<String> fStack = new ArrayDeque<>();
    String nowPage = null;

    for(int z = 0; z < Q; z++) {
      st = new StringTokenizer(br.readLine(), " ");
      char order = st.nextToken().charAt(0);

      switch(order) {
        // 뒤로가기
        // 현재 페이지를 fStack + bStack의 peek를 현재 페이지로
        case 'B':
          // 뒤로가기 이전 작업 유무 파악 후, bStack에 pop
          if(!bStack.isEmpty()) {
            // 현재 페이지 유무 + 있다면 fStack에 push
            if(nowPage != null) {
              fStack.push(nowPage);
            }

            nowPage = bStack.pop();
          }
          break;
        // 앞으로가기
        // 현재 페이지를 bStack + fStack의 peek를 현재 페이지로
        case 'F':
          // 앞으로가기 이전 작업 유무 파악 후 fStack에 pop
          if(!fStack.isEmpty()) {
            // 현재 페이지 유무 + 있다면 bStack에 push
            if(nowPage != null) {
              bStack.push(nowPage);
            }

            nowPage = fStack.pop();
          }
          break;
        // 웹 접속
        // fStack 다 clear + 현재 페이지를 입력값으로 세팅
        case 'A':
          fStack.clear();

          String str = st.nextToken();

          if (nowPage != null) {
            bStack.push(nowPage);
          }

          nowPage = str;
          break;
        // 압축
        // TreeSet에 다 삽입 후, ArrayDeque으로 전환
        case 'C':
          List<String> list = new ArrayList<>();
          String s = null;
          while(!bStack.isEmpty()) {
            String popStr = bStack.pop();
            if (!popStr.equals(s)) {
              list.add(popStr);
              s = popStr;
            }
          }
          bStack = new ArrayDeque<>();
          for (int i = list.size() - 1; i >= 0; i--) {
            bStack.push(list.get(i)); // 최신 → 오래된 순서 유지
          }
          break;
      }
    }

    // 출력 (현재 페이지, bStack All, fStack All)
    sb.append(nowPage).append("\n");
    if(bStack.isEmpty()) {
      sb.append(-1);
    } else {
      while(!bStack.isEmpty()) {
        sb.append(bStack.pop()).append(" ");
      }
    }
    sb.append("\n");
    if(fStack.isEmpty()) {
      sb.append(-1);
    } else {
      while(!fStack.isEmpty()) {
        sb.append(fStack.pop()).append(" ");
      }
    }

    System.out.println(sb);
  }
}