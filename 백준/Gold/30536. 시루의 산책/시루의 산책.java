import java.util.*;
import java.io.*;

public class Main {
  static class Pillar {
    int y, x;
    boolean type;

    Pillar(int y, int x, boolean type) {
      this.y = y;
      this.x = x;
      this.type = type;
    }

    public String toString() {
      return "y:" + y + " x:" + x + " type:" + (type ? "T":"F");
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int pillarCount = Integer.parseInt(st.nextToken());
    int myPeeRange = 0;
    int otherPeeCount = Integer.parseInt(st.nextToken());
    List<Pillar> list = new ArrayList<>();
    List<Integer> idxSet = new ArrayList<>();

    for(int z = 0; z < pillarCount; z++) {
      st = new StringTokenizer(br.readLine());
      list.add(new Pillar(
          Integer.parseInt(st.nextToken()) - 1,
          Integer.parseInt(st.nextToken()) - 1,
          false
      ));
    }

    // other 소변을 지정할 기둥을 배열에 저장
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < otherPeeCount; i++) {
      idxSet.add(Integer.parseInt(st.nextToken()) - 1);
    }

    // 소변 범위 저장 및 other 소변 범위를 true로 변경
    st = new StringTokenizer(br.readLine());
    myPeeRange = Integer.parseInt(st.nextToken());
    for(int idx : idxSet) {
      pee(list, idx, true, Integer.parseInt(st.nextToken()));
    }

    // 가능한 경우가 없을 때까지, 내 소변 + false로 변환 무한 반복
    boolean isOkNext = true;
    int answer = 0;
    while(isOkNext) {
      isOkNext = false;

      for(int i = 0; i < list.size(); i++) {
        Pillar pillar = list.get(i);

        if(pillar == null || pillar.type) {
          continue;
        }

        pee(list, i, false, myPeeRange);
        list.set(i, null);
        answer++;
        isOkNext = true;
      }
    }

//    System.out.println(list);
    System.out.println(answer);
  }

  //소변의 범위 파악 및 true or false로 저장
  static void pee(List<Pillar> list,  int index, boolean type, int peeRange) {
    Pillar pillar = list.get(index);

    for (Pillar p : list) {
      if (p != null &&
          (p.y - pillar.y) * (p.y - pillar.y) + (p.x - pillar.x) * (p.x - pillar.x) <= peeRange * peeRange) {
        p.type = type;
      }
    }
  }
}