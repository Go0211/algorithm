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
        int MK = Integer.parseInt(st.nextToken())
                + Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        SegmentTree tree = new SegmentTree(arr);
        
        for(int i = 0; i < MK; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            if(st.nextToken().equals("1")) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                long value = Long.parseLong(st.nextToken());
                tree.change(1, 0, arr.length - 1, idx, value - tree.basic[idx]);
                tree.basic[idx] = value;
            } else {
                int startIdx = Integer.parseInt(st.nextToken()) - 1;
                int endIdx = Integer.parseInt(st.nextToken()) - 1;
                sb.append(
                        tree.sum(1, 0, arr.length - 1, startIdx, endIdx)
                ).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class SegmentTree {
        int len, size, h;
        long[] basic, tree;

        SegmentTree(long[] arr) {
            len = arr.length;
            basic = Arrays.copyOf(arr, len);
            h = (len == 0) ? 0 : (32 - Integer.numberOfLeadingZeros(len - 1));
            size = 1 << (h + 1);
            tree = new long[size];
            build(1, 0, len - 1);
        }

        void build(int idx, int start, int end) {
            if(start == end) {
                this.tree[idx] = this.basic[start];
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
                return this.tree[idx];
            }

            int mid = S + ((E - S) >>> 1);
            int left = idx << 1;
            int right = left | 1;

            return sum(left, S, mid, start, end)
                    + sum(right, mid+1, E, start, end);
        }

        void change(int idx, int S, int E, int index, long value) {
            //불가능한 경우 check!
            if(index < S || E < index) {
                return;
            }

            tree[idx] += value;

            // 재귀할게 남아있는 지 check!
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