package BallGlass;

public class GlassBall {
	static int compares=0;

	/**
	 *complexity: O(2 * sqrt (n))
	 */
	public static int break_ball (int [] floor, int ball)
	{
		if (ball>=floor[floor.length-1]) return -1; // doesn't break
		compares=0;
		int index=1; 
		int d=(int)Math.sqrt(floor.length);
		int i=d;
		while (i<=floor.length){
			compares++;
			if (ball<floor[i-1]){ 
				index=i-d+1;
				while (ball>=floor[index-1]) { 
					compares++; 
					index++;
				}
				break;
			}
			i+=d;
			if (i>floor.length) i=floor.length;	
		}
		return index;
	}

	/**
	 *complexity: O(sqrt (2) * sqrt (n))
	 */
	public static int break_ball2 (int [] floor, int ball)
	{
		if (ball>=floor[floor.length-1]) return -1;  // doesn't break
		compares=0;
		int index=1; 
		int d=0;

		while (floor.length > d*(d+1)/2){
			d++;
		}
		int i=d;

		while (i<=floor.length){
			compares++;
			if (ball<floor[i-1]){ 
				index=i-d+1;
				while (ball>=floor[index-1]) {
					compares++;
					index++;
				}
				break;
			}
			d--;
			i+=d;
			if (i>floor.length) i=floor.length;	
		}
		return index;
	}


	public static void main(String[] args) {
		int []array={10,20,40,50,70,80};
		int b=5;
		System.out.println(break_ball(array,b));
		System.out.println(compares);
		int [] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int a = 2;
		System.out.println(break_ball(arr,a));
		System.out.println(compares);
		int []array2={10,20,30,40,50,60,70};
		int b2=25;
		System.out.println(break_ball(array2,b2));

	}

}
