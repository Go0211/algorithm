import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =
        new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    long[] arr = new long[N];

    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    SegmentTree segmentTree = new SegmentTree(arr);

    for(int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int start = Integer.parseInt(st.nextToken()) - 1;
      int end = Integer.parseInt(st.nextToken()) - 1;
      int idx = Integer.parseInt(st.nextToken()) - 1;
      long value = Long.parseLong(st.nextToken());

      sb.append(segmentTree.sum(1, 0, N - 1, Math.min(start, end), Math.max(start, end)))
          .append("\n");
      segmentTree.change(1, 0, N - 1, idx, value - arr[idx]);
      arr[idx] = value;
    }

    System.out.println(sb);
  }

  static class SegmentTree {
    int len;
    long[] basic, tree;

    SegmentTree(long[] arr) {
      int len = arr.length;
      basic = Arrays.copyOf(arr, len);
      int h = (len == 0) ? 0
          : (32 - Integer.numberOfLeadingZeros(len - 1));
      int size = 1 << (h + 1);
      tree = new long[size];
      build(1, 0, len - 1);
    }

    void build(int idx, int start, int end) {
      if(start == end) {
        tree[idx] = basic[start];
        return;
      }

      int mid = start + ((end - start) >>> 1);
      int left = idx << 1;
      int right = left | 1;

      build(left, start, mid);
      build(right, mid+1, end);
      tree[idx] = tree[left] + tree[right];
    }

    long sum(int idx, int S, int E, int start, int end) {
      if(E < start || end < S) {
        return 0;
      }
      if(start <= S && E <= end) {
        return tree[idx];
      }

      int mid = S + ((E - S) >>> 1);
      int left = idx << 1;
      int right = left | 1;

      return sum(left, S, mid, start, end)
          + sum(right, mid+1, E, start, end);
    }

    void change(int idx, int S, int E, int index, long value) {
      if(E < index || index < S) {
        return;
      }

      tree[idx] += value;

      if(S == E) {
        return;
      }

      int mid = S + ((E - S) >>> 1);
      int left = idx << 1;
      int right = left | 1;
      change(left, S, mid, index, value);
      change(right, mid+1, E, index, value);
    }
  }
}