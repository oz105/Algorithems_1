package My;

import java.util.Arrays;

class Node {
	int x , y , lowPrice , highPrice , price ;
	public Node (int x, int y) {
		this.x = x ;
		this.y = y ;
		price = 0 ;
		lowPrice = 0 ;
		highPrice = 0 ;
	}
}


public class PlaneProblem {
	
	
	/**
	 * return the low price
	 * Complexity: O(n^2)
	 */
	public static int minPrice (Node [][] plane) {
		int n = plane.length , m = plane[0].length;
		plane[0][0].price = 0 ;
		for (int i = 1; i < n; i++) {plane[i][0].price = plane[i-1][0].price + plane[i-1][0].y;}
		for (int j = 1; j < m; j++) { 
			plane[0][j].price = plane[0][j-1].price + plane[0][j-1].x;}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int fromDown = plane[i-1][j].price+plane[i-1][j].y;
				int fromLeft = plane[i][j-1].price+plane[i][j-1].x;
				plane[i][j].price = Math.min(fromDown, fromLeft);
			}
		}
		return plane[n-1][m-1].price;
	}
	
	/**
	 * return the path for low price
	 * Complexity: O(n*m)
	 */
	public static String minPricePath (Node [][] plane) {
		int n = plane.length , m = plane[0].length;
		plane[0][0].price = 0 ;
		for (int i = 1; i < n; i++) {plane[i][0].price = plane[i-1][0].price + plane[i-1][0].y;}
		for (int j = 1; j < m; j++) { 
			plane[0][j].price = plane[0][j-1].price + plane[0][j-1].x;}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int fromDown = plane[i-1][j].price+plane[i-1][j].y;
				int fromLeft = plane[i][j-1].price+plane[i][j-1].x;
				plane[i][j].price = Math.min(fromDown, fromLeft);
			}
		}
		return path(plane);
	}
	
	/**
	 * path function
	 * Complexity: O(i+j)
	 */
	
	private static String path(Node[][] plane) {
		int i = plane.length-1, j = plane[0].length-1;
		String res = "";
		while (i!=0 && j !=0) {
			int fromDown = plane[i-1][j].price+plane[i-1][j].y;
			int fromLeft = plane[i][j-1].price+plane[i][j-1].x;
			if(fromDown < fromLeft) {
				res = 1 + res ;
				i--;
			}
			else {
				res = 0 + res ; 
				j-- ;
			}
		}
		while(i!=0) {
			res = 1 + res ;
			i--;
		}
		while(j!=0) {
			res = 0 + res ; 
			j-- ;
		}
		return res;
	}

	public static void main(String[] args) {
		Node[][] mat = {
			{new Node(1,5),new Node(4,1),new Node(0,6)},
			{new Node(4,7),new Node(2,5),new Node(0,3)},
			{new Node(1,0),new Node(2,0),new Node(0,0)}};
		System.out.println(minPrice(mat));
		System.out.println(minPricePath(mat));
	}

}
