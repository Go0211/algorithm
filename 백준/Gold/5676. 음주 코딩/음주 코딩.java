import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String str;
        while((str = br.readLine()) != null && !str.isEmpty()) {
            StringTokenizer st =
                    new StringTokenizer(str, " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                arr[i] = oneZeroMinus(Integer.parseInt(st.nextToken()));
            }

            SegmentTree segment = new SegmentTree(arr);

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                if(st.nextToken().equals("C")) {
                    int idx = Integer.parseInt(st.nextToken()) - 1;
                    int value = oneZeroMinus(Integer.parseInt(st.nextToken()));
                    segment.basic[idx] = value;
                    segment.change(1, 0, N-1, idx, value);
                } else {
                    int start = Integer.parseInt(st.nextToken()) - 1;
                    int end = Integer.parseInt(st.nextToken()) - 1;
                    int result = segment.mul(1, 0, N-1, start, end);
                    sb.append(result == 0 ? '0' : result > 0 ? '+' : '-');
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int oneZeroMinus(int value) {
        return Integer.compare(value, 0);
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
            tree[idx] = tree[left] * tree[right];
        }

        int mul (int idx, int S, int E, int start, int end) {
            if(end < S || E < start) {
                return 1;
            }
            if(start <= S && E <= end) {
                return tree[idx];
            }

            int mid = S + ((E - S) >>> 1);
            int left = idx << 1;
            int right = left | 1;

            return mul(left, S, mid, start, end) * mul(right, mid+1, E, start, end);
        }

        void change(int idx, int S, int E, int index, int value) {
            if(index < S || E < index) {
                return;
            }

            tree[idx] = value;

            if(S == E) {
                return;
            }

            int mid = S + ((E - S) >>> 1);
            int left = idx << 1;
            int right = left | 1;

            change(left, S, mid, index, value);
            change(right, mid+1, E, index, value);
            tree[idx] = tree[left] * tree[right];
        }
    }
}