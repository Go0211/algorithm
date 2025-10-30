import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};

    static class Node implements Comparable<Node>{
        int idx, d;

        Node(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }

        public int compareTo(Node n) {
            return n.d < this.d ? 1 : -1;
        }

        public String toString() {
            return idx + " " + d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        boolean[][] sample = new boolean[R][C];
        int[][] arr = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < C; j++) {
                sample[i][j] = (st.nextToken().charAt(0) == '1');
            }
        }

        int index = 1;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(sample[i][j] && arr[i][j] == 0) {
                    numbering(arr, sample, i, j, R, C, index);
                    index++;
                }
            }
        }

        List<List<Node>> list = new ArrayList<>();
        for(int i = 0; i <= index; i++) {
            list.add(new ArrayList<>());
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] != 0) {
                    //가로 다리 가능여부
                    Node n1 = findRow(arr, i, j, R, C, arr[i][j]);
                    //세로 다리 가능여부
                    Node n2 = findCol(arr, i, j, R, C, arr[i][j]);

                    if(n1.idx != -1) {
                        list.get(arr[i][j]).add(n1);
                        list.get(n1.idx).add(new Node(arr[i][j], n1.d));
                    }
                    if(n2.idx != -1) {
                        list.get(arr[i][j]).add(n2);
                        list.get(n2.idx).add(new Node(arr[i][j], n2.d));
                    }
                }
            }
        }

        pq.offer(new Node(1, 0));
        boolean[] v = new boolean[index];
        int count = 1;
        int answer = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int idx = n.idx;
            int d = n.d;

            if (v[n.idx]) {
                continue;
            }

            v[n.idx] = true;
            count++;

            answer += d;

            if(count == index) {
                break;
            }

            for(Node node : list.get(idx)) {
                if(!v[node.idx]) {
                    pq.offer(node);
                }
            }
        }

        for(int i = 1; i < v.length; i++) {
            if(!v[i]) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }

    //가로
    static Node findRow(int[][] arr, int y, int x,
                        int R, int C, int idx) {
        for(int i = x+1; i < C; i++) {
            if (arr[y][i] == idx) {
                return new Node(-1, -1);
            }

            if(arr[y][i] != 0 && arr[y][i] != idx) {
                if(i <= x + 2) {
                    return new Node(-1, -1);
                }

                return new Node(arr[y][i], i - x - 1);
            }
        }

        return new Node(-1, -1);
    }

    //세로
    static Node findCol(int[][] arr, int y, int x,
                        int R, int C, int idx) {
        for(int i = y+1; i < R; i++) {
            if (arr[i][x] == idx) {
                return new Node(-1, -1);
            }

            if(arr[i][x] != 0 && arr[i][x] != idx) {
                if(i <= y + 2) {
                    return new Node(-1, -1);
                }

                return new Node(arr[i][x], i - y - 1);
            }
        }

        return new Node(-1, -1);
    }

    // 숫자 넣기
    static void numbering(int[][] arr, boolean[][] sample,
                          int y, int x, int R, int C, int idx) {
        arr[y][x] = idx;

        for(int[] dir : dirs) {
            int ny = y + dir[0];
            int nx = x + dir[1];

            if(ny >= 0 && ny < R && nx >= 0 && nx < C
                    && sample[ny][nx] && arr[ny][nx] == 0) {
                numbering(arr, sample, ny, nx, R, C, idx);
            }
        }
    }
}