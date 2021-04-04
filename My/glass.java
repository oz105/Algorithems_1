package My;

public class glass {
	
	/**
	 * returns the nth element in fibonacci series
	 * Complexity: O(n)
	 */
	
	public static int findClosestTringleNum (int x) {
		int y = 0 ;
		int i = 1 ;
		while (x > y) {
			y = i + y ; 
			i++ ;
		}
		return i ;
	}
	/**
	 * 2 glass ball problem
	 * Complexity: O(n^2)
	 */
	
	public static int findFloor (int a , int[]arr) {
		int numOfCheck = 0 ;
		int floors = arr.length ;
		int currntFloor = findClosestTringleNum(floors);
		int step = currntFloor -1 ; 
		while (a > arr [currntFloor]) {
			numOfCheck++;
			step = step - 1 ;
			currntFloor = currntFloor + step ;
		}
		System.out.println("first break "+currntFloor);
		currntFloor = currntFloor - (step) ;
		while (a>arr[currntFloor]) {
			numOfCheck++;
			currntFloor ++ ;
		}
		System.out.println("secound break "+currntFloor);
		System.out.println("num of checks is "+numOfCheck);
		return currntFloor ;
	}
	
	public static void main(String[] args) {
		int [] arr = new int [100] ;
		for (int i = 0; i < arr.length; i++) {
			arr [i] = i ;
		}
		findFloor(90, arr);
	}

}
