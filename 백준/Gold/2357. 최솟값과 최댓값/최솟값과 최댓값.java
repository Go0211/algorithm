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

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb.append(segment.find(
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1
            )).append("\n");
        }

        System.out.println(sb);
    }

    static class SegmentTree {
        int len;
        int[] basic;
        int[][] tree;

        SegmentTree(int[] arr) {
            len = arr.length;
            basic = Arrays.copyOf(arr, len);
            int h = (len == 0) ? 0
                    : (32 - Integer.numberOfLeadingZeros(len - 1));
            int size = 1 << (h + 1);
            tree = new int[size][2];
            build(1, 0, len - 1);
        }

        void build(int idx, int start, int end) {
            if(start == end) {
                tree[idx][0] = basic[start];
                tree[idx][1] = basic[start];
                return;
            }

            int mid = start + ((end - start) >>> 1);
            int left = idx << 1;
            int right = left | 1;

            build(left, start, mid);
            build(right, mid+1, end);

            tree[idx][0] = Math.min(tree[left][0],tree[right][0]);
            tree[idx][1] = Math.max(tree[left][1], tree[right][1]);
        }

        String find(int start, int end) {
            int[] node = finder(1, 0, len - 1, start, end);
            return node[0] + " " + node[1];
        }

        int[] finder(int idx, int S, int E, int start, int end) {
            if(E < start || end < S) {
                return new int[]{Integer.MAX_VALUE, 0};
            }
            if(start <= S && E <= end) {
                return tree[idx];
            }

            int mid = S + ((E - S) >>> 1);
            int left = idx << 1;
            int right = left | 1;

            int[] a = finder(left, S, mid, start, end);
            int[] b = finder(right, mid+1, E, start, end);
            return new int[]{Math.min(a[0],b[0]), Math.max(a[1],b[1])};
        }
    }
}