package principal.util;

public class Random {
	
	
	public static int value(int n, int m) {
		return (int)(Math.random()*(m-n+1)+n); 
	}
	
	
	public static boolean pairValue() {
		if (value(1, 10) % 2 == 0){
			return true;
		}
		else return false;
	}
	
}