import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int len1 = Integer.parseInt(st.nextToken());
    int len2 = Integer.parseInt(st.nextToken());
    int len3 = Integer.parseInt(st.nextToken());
    int min = Math.min(len1, Math.min(len2, len3));

    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    List<Integer> l3 = new ArrayList<>();

    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < len1; i++) {
      l1.add(Integer.parseInt(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < len2; i++) {
      l2.add(Integer.parseInt(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < len3; i++) {
      l3.add(Integer.parseInt(st.nextToken()));
    }

    l1.sort((x, y) -> y - x);
    l2.sort((x, y) -> y - x);
    l3.sort((x, y) -> y - x);

    int maxValue = 0;
    int minValue = 0;

    for (int i = 0; i < min; i++) {
      int value = l1.get(i) + l2.get(i) + l3.get(i);
      maxValue += value;
      minValue += value * 9 / 10;
    }

    for (int i = min; i < len1; i++) {
      maxValue += l1.get(i);
      minValue += l1.get(i);
    }
    for (int i = min; i < len2; i++) {
      maxValue += l2.get(i);
      minValue += l2.get(i);
    }
    for (int i = min; i < len3; i++) {
      maxValue += l3.get(i);
      minValue += l3.get(i);
    }

    System.out.println(maxValue);
    System.out.println(minValue);
  }
}