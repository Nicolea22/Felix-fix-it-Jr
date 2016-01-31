package principal;

import java.util.PriorityQueue;

public class Score {

	private PriorityQueue<Integer> bestScores;
	private int actualScore;
	
	
	public Score (){
		bestScores = new PriorityQueue<Integer>();
		actualScore = 0;
	}
	
	
	public void add(int score) {
		bestScores.add(score);
	}
	
	public void checkBestScores() {
		bestScores.add(actualScore);
	}
	
	
	public void inc(){
		actualScore += 100;
	}
	
	public void incMore(){
		actualScore += 500;
	}
	
	
	public void reset() {
		actualScore = 0;
	}
	
	
	public  Object[] getScores() {
		return bestScores.toArray();
	}
	
}
