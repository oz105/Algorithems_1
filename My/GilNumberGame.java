package My;

public class GilNumberGame {
	/**
	 * Game Numbers - dynamic algorithm Complexity: O(n^2)
	 */
	private int[][] mat;
	private int n;

	public GilNumberGame(int[] a) {
	        buildMatrix(a);
	    }

	public void buildMatrix(int[] a) {
		n = a.length;
		mat = new int[n][n];
		for (int i = 0; i < n; i++) {
			mat[i][i] = a[i];
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				mat[i][j] = Math.max(a[i] - mat[i + 1][j], a[j] - mat[i][j - 1]);
			}
		}
	}

	/**
	 * Returns the difference between the first player and the second player if both
	 * playing optimal
	 */
	public int getDifference() {
		return mat[0][mat[0].length - 1];
	}

	public String getOptimalPathRec() {
		return getOptimalPath(0, n - 1);
	}

	/**
	 * Returns the game's optimal path for both players
	 */
	private String getOptimalPath(int i, int j) {
		if (i == j)
			return "(" + i + ")" + mat[i][i];
		if (mat[i][i] - mat[i + 1][j] > mat[j][j] - mat[i][j - 1]) {
			return "(" + i + ")" + mat[i][i] + "->" + getOptimalPath(i + 1, j);
		} else {
			return "(" + j + ")" + mat[j][j] + "->" + getOptimalPath(i, j - 1);
		}
	}

//	    gameStrategy(int[] a){
//	        int i=0, n=a.length, j=n-1;
//	        int first=0, second=0, firstSum=0, secondSum=0;
//	        int[][] mat = new int[n][n];
//	        for (int k = 0; k < n/2; k++) {
//	            if (a[i]-mat[i+1][j] > a[j]-mat[i][j-1]){ // first pick
//	                firstSum = firstSum+a[i];
//	                first = i++;
//	            }
//	            else {
//	                firstSum = firstSum+a[j];
//	                first = j--;
//	            }
	//
//	            if (i != j){ // second pick
//	                if (a[i]-mat[i+1][j] > a[j]-mat[i][j-1]){
//	                    secondSum = secondSum+a[i];
//	                    second = i++;
//	                }
//	                else {
//	                    secondSum = secondSum+a[j];
//	                    second = j--;
//	                }
//	            }
//	            else { // second the last pick, j=0 or i=n-1
//	                second = j;
//	                secondSum = secondSum + a[j];
//	            }
	//
//	            System.out.println("first: a[" + first + "] = " + a[first] + ", second: a[" + second + "] = " + a[second]);
//	        }
//	        System.out.println("firstSum = " + firstSum + ", secondSum = " + secondSum
//	                            + ", diff = " + (firstSum-secondSum));
//	    }

	public static void main(String[] args) {
		System.out.println(new GilNumberGame(new int[] { 1, 3, 6, 1, 3, 6 }).getOptimalPathRec());
	}
}
