package problem.day1107;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back14499 {
	static final int EAST = 1, WEST = 2, NORTH = 3, SOUTH = 4;
	
	static class Dice {
		int up, down, left, right, front, back;
		
		public Dice() {
			up = 0; left = 0; front = 0;
			down = 0; right = 0; back = 0;
//			up = 0; left = 1; front = 2;
//			down = 3; right = 4; back = 5;
		}
		
		int getUp() {
			return up;
		}
		
		void moveEast() {
			int tmp = up;
			up = left;
			left = down;
			down = right;
			right = tmp;
		}
		void moveWest() {
			int tmp = up;
			up = right;
			right = down;
			down = left;
			left = tmp;		
		}
		void moveNorth() {
			int tmp = up;
			up = back;
			back = down;
			down = front;
			front = tmp;	
		}
		void moveSouth() {
			int tmp = up;
			up = front;
			front = down;
			down = back;
			back = tmp;	
		}
		void copyMethod(int[][] maps, int yIdx, int xIdx) {
			int value = maps[yIdx][xIdx];
			
			if(value == 0) {
				maps[yIdx][xIdx] = down;
			} else {
				down = value;
				maps[yIdx][xIdx] = 0;
			}
		}
		
		public String toString() {
			return "\t" + up + "\n" + left + "\t" + front + "\t"  + right + "\n" + "\t"  + down  + "\n" + "\t" + back;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int yIdx = Integer.parseInt(st.nextToken());
		int xIdx = Integer.parseInt(st.nextToken());
		int seq = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		
		int[][] maps = new int[Y][X];
		List<Integer> list = new ArrayList<>();
		Dice dice = new Dice();
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < X; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < seq; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		

		int nextY = yIdx;
		int nextX = xIdx;
		for (int dir : list) {
			if (dir == EAST) {
				if (nextX + 1 < X) {
					nextX += 1;
					dice.moveEast();
					dice.copyMethod(maps, nextY, nextX);
					sb.append(dice.getUp()).append("\n");
				}
			} else if (dir == WEST ) {
				if (0 <= nextX - 1) {
					nextX -= 1;
					dice.moveWest();
					dice.copyMethod(maps, nextY, nextX);
					sb.append(dice.getUp()).append("\n");
				}
			} else if (dir == NORTH ) {
				if (0 <= nextY - 1) {
					nextY -= 1;
					dice.moveNorth();
					dice.copyMethod(maps, nextY, nextX);
					sb.append(dice.getUp()).append("\n");
				}
			} else if (dir == SOUTH ) {
				if (nextY + 1 < Y) {
					nextY += 1;
					dice.moveSouth();
					dice.copyMethod(maps, nextY, nextX);
					sb.append(dice.getUp()).append("\n");
				}
			}
			
//			System.out.println("yIdx" + nextY + " | xIdx" + nextX + " | up value : " + dice.getUp());
//			System.out.println(dice);
		}
		
		System.out.println(sb);
	}
}
