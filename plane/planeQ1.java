package algo;

class Node {
	int x, y, distance, num;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.distance = 0;
		this.num = 0;
	}
}

public class planeQ1 {

	public static int numOfPaths(Node[][] nodes) {
		int n = nodes.length, m = nodes[0].length;
		nodes[0][0].distance = 0;
		nodes[0][0].num = 1;
		for (int i = 1; i < n; i++) {
			nodes[i][0].distance = nodes[i - 1][0].distance + nodes[i - 1][0].y;
			nodes[i][0].num = 1;
		}
		for (int j = 1; j < m; j++) {
			nodes[0][j].distance = nodes[0][j - 1].distance + nodes[0][j - 1].x;
			nodes[0][j].num = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int fromDown = nodes[i - 1][j].distance + nodes[i - 1][j].y;
				int fromLeft = nodes[i][j - 1].distance + nodes[i][j - 1].x;
				nodes[i][j].distance = Math.min(fromDown, fromLeft);
				if (fromDown < fromLeft) {
					nodes[i][j].num = nodes[i - 1][j].num;
				} else if (fromDown > fromLeft) {
					nodes[i][j].num = nodes[i][j - 1].num;
				} else
					nodes[i][j].num = nodes[i - 1][j].num + nodes[i][j - 1].num;// when there equals we need to sum
																				// them up.
			}
		}
		return nodes[n - 1][m - 1].num;
	}
}
