import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    long[] arr = new long[N];

    for(int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }

    SegmentTree segment = new SegmentTree(arr);

    for(int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());

      if(st.nextToken().equals("1")) {
        int idx = Integer.parseInt(st.nextToken()) - 1;
        long value = Long.parseLong(st.nextToken());

        segment.change(1, 0, N - 1, idx, value);
        segment.basic[idx] = value;
      } else {
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        sb.append(segment.find(1, 0, N - 1, start, end))
            .append("\n");
      }
    }

    System.out.println(sb);
  }

  static class SegmentTree {
    int len;
    long[] basic, tree;

    SegmentTree(long[] arr) {
      len = arr.length;
      basic = Arrays.copyOf(arr, len);
      int h = (len == 0) ? 0
          : (32 - Integer.numberOfLeadingZeros(len - 1));
      int size = 1 << (h + 1);
      tree = new long[size];

      build(1, 0, len - 1);
    }

    void build(int idx, int S, int E) {
      if(S == E) {
        tree[idx] = basic[S] % 1_000_000_007;
        return;
      }

      int mid = S + ((E - S) >>> 1);
      int left = idx << 1;
      int right = left | 1;

      build(left, S, mid);
      build(right, mid+1, E);
      tree[idx] = tree[left] * tree[right] % 1_000_000_007;
    }

    void change(int idx, int S, int E, int index, long value) {
      if(index < S || E < index) {
        return;
      }

      tree[idx] = value % 1_000_000_007;

      if(S == E) {
        return;
      }

      int mid = S + ((E - S) >>> 1);
      int left = idx << 1;
      int right = left | 1;

      change(left, S, mid, index, value);
      change(right, mid+1, E, index, value);
      tree[idx] = tree[left] * tree[right] % 1_000_000_007;
    }

    long find(int idx, int S, int E, int start, int end) {
      if(E < start || end < S) {
        return 1;
      }
      if(start <= S && E <= end) {
        return tree[idx] % 1_000_000_007;
      }

      int mid = S + ((E - S) >>> 1);
      int left = idx << 1;
      int right = left | 1;

      return find(left, S, mid, start, end) * find(right, mid+1, E, start, end) % 1_000_000_007;
    }
  }
}