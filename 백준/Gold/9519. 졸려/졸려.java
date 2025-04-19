import java.util.*;
import java.io.*;

public class Main {
  static Map<Integer, String> map = new HashMap<>();
  static Set<String> set = new HashSet<>();
  static ArrayDeque<Character> stack = new ArrayDeque<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int seq = Integer.parseInt(br.readLine());
    String str = br.readLine();
    set.add(str);
    map.put(0, str);
    char[] arr = new char[str.length()];

    for(int i = 0; i < arr.length; i++) {
      arr[i] = str.charAt(i);
    }

    for(int i = 1; i <= seq; i++) {
      //뒤로 갈 놈들 앞에서 부터 stack으로 이동
      backChoose(arr);
      //글자들 자리 재배치
      wordFront(arr);
      //stack에 있는 놈들 뒤로 보내기
      goBack(arr);

      if(set.contains(String.valueOf(arr))) {
        break;
      }

      set.add(String.valueOf(arr));
      map.put(i, String.valueOf(arr));
    }

//    System.out.println(map);
//    System.out.println(set);

    System.out.println(map.size() == seq + 1 ?
        map.get(seq) :
        map.get(seq % map.size()));
  }

  static void backChoose(char[] arr) {
    for(int i = 1; i < arr.length; i+=2) {
      stack.push(arr[i]);
    }
  }

  static void wordFront(char[] arr) {
    int idx = 1;

    for(int i = 2; i < arr.length; i+=2) {
      arr[idx] = arr[i];
      idx++;
    }
  }

  static void goBack(char[] arr) {
    int idx = arr.length - stack.size();

    for(int i = idx; i < arr.length; i++) {
      arr[i] = stack.pop();
    }
  }
}