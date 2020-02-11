package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedCity {

	public static void main(String[] args) {

		System.out.println(minimum_possible_cost("-1@10@-1#10@2@10#-1@10@-1"));
		System.out.println(minimum_possible_cost("1@10@1#10@2@10#1@10@1"));
	}

	public static int minimum_possible_cost(String input1) {

		int dirX[] = { 1, -1, 0, 0, 1, -1, -1, 1 };
		int dirY[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
		String[] row = input1.split("#");
		int length = row.length;
		int breadth = row[0].split("@").length;
		int[][] matrix = new int[length][breadth];
		int[][] tempMatrix = new int[length][breadth];
		int[][] visited = new int[length][breadth];
		ArrayList<Node> connectedCity = new ArrayList<>();
		ArrayList<Node> notConnectedCity = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			String[] col = row[i].split("@");
			for (int j = 0; j < breadth; j++) {
				int weight = Integer.parseInt(col[j]);
				matrix[i][j] = weight;
				tempMatrix[i][j] = weight;
				if (matrix[i][j] == -1) {
					connectedCity.add(new Node(i, j));
				} else {
					notConnectedCity.add(new Node(i, j, weight));
				}
			}
		}
		ArrayList<Integer> weight = new ArrayList<Integer>();
		if (connectedCity.isEmpty()) {
			weight.add(0);
		} else if(notConnectedCity.isEmpty()){
			weight.add(0);
		}else {
			for (int i = 0; i < notConnectedCity.size(); i++) {
				Queue<Node> adjecentNode = new LinkedList<>();
				if (allCityConnected(notConnectedCity.get(i), matrix, dirX, dirY, length, breadth, connectedCity)) {
					weight.add(notConnectedCity.get(i).weight);
					break;
				}
				adjecentNode.add(notConnectedCity.get(i));
				int count = 0;
				while (!adjecentNode.isEmpty()) {
					Node n = adjecentNode.poll();

					if ((count == connectedCity.size())) {
						weight.add(n.weight);
					}
					for (int c = 0; c < 8; c++) {
						int xx = n.x + dirX[c];
						int yy = n.y + dirY[c];
						if (xx >= 0 && xx < length && yy >= 0 && yy < breadth) {
							if (matrix[xx][yy] == -1) {
								count++;
							} else {
								int w = matrix[xx][yy];
								if (visited[xx][yy] == 0) {
									Node nn = new Node(xx, yy, n.weight + w);
									adjecentNode.add(nn);
									visited[xx][yy] = 1;
									tempMatrix[xx][yy] = n.weight + w;
								} else {
									if (w + n.weight < tempMatrix[xx][yy]) {
										Node nn = new Node(xx, yy, n.weight + w);
										adjecentNode.add(nn);
									}
								}
							}
						}
					}
				}
			}
		}
		Collections.sort(weight);
		return weight.get(0);
	}

	static boolean allCityConnected(Node n, int[][] matrix, int[] dirX, int[] dirY, int length, int breadth,
			ArrayList<Node> connectedCity) {

		int count = 0;
		for (int c = 0; c < 8; c++) {
			int xx = n.x + dirX[c];
			int yy = n.y + dirY[c];
			if (xx >= 0 && xx < length && yy >= 0 && yy < breadth) {
				if (matrix[xx][yy] == -1) {
					count++;
				}
			}
		}
		return (count == connectedCity.size());
	}

	static class Node {
		int x;
		int y;
		int weight;

		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
