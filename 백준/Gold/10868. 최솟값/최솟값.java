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
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree segment = new SegmentTree(arr);

        for(int z = 0; z < M; z++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(segment.findMin(1, 0, N - 1, start, end))
                    .append("\n");
        }

        System.out.println(sb);
    }

    static class SegmentTree {
        int len;
        int[] basic, tree;

        SegmentTree(int[] arr) {
            len = arr.length;
            basic = Arrays.copyOf(arr, len);
            int h = (len == 0) ? 0
                    : (32 - Integer.numberOfLeadingZeros(len - 1));
            int size = 1 << (h + 1);
            tree = new int[size];

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
            tree[idx] = Math.min(tree[left], tree[right]);
        }

        int findMin(int idx, int S, int E, int start, int end) {
            if(E < start || end < S) {
                return Integer.MAX_VALUE;
            }
            if(start <= S && E <= end) {
                return tree[idx];
            }

            int mid = S + ((E - S) >>> 1);
            int left = idx << 1;
            int right = left | 1;

            return Math.min(findMin(left, S, mid, start, end),
                    findMin(right, mid+1, E, start, end));
        }
    }
}