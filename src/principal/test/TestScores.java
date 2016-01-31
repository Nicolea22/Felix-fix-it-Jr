package principal.test;

import principal.Score;

public class TestScores {
	
	private static Score score;
	
	public TestScores(){
		score = new Score();
	}
	
	
	public static void main (String [] args) {
		TestScores test = new TestScores();
		score.add(1000);
		score.add(3);
		score.add(199);
		score.add(500);
		score.add(300);
		
	}
}
