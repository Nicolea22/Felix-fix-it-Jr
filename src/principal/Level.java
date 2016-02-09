package principal;

public class Level {

	private int actualLevel;

	private float birdVel;
	private float brickVel;
	private float ralphVel;
	
	private static Level level = new Level();
	
	private Level() {
		initLevel();
	}
	
	private void initLevel() {
		actualLevel = 1;
		brickVel = 0.8f;
		birdVel = 1.5f;
		ralphVel = 0.8f;
	}
	
	public static Level getLevel(){
		return level;
	}
	
	public void levelUp() {
		actualLevel++;
		
		System.out.println(birdVel + birdVel * 15/100);
		System.out.println(ralphVel + ralphVel * 15/100);
		System.out.println(brickVel + brickVel * 15/100);
		
		ralphVel += ralphVel * 15/100;
		birdVel += birdVel * 15/100;
		brickVel += brickVel * 15/100;
		
	}
	
	public void resetGame() {
		initLevel();
	}

	
	// Level
	public int getActualLevel() {
		return actualLevel;
	}


	public void setLevel(int level) {
		actualLevel = level;
	}


	// Bird
	public float getBirdVel() {
		return birdVel;
	}


	public void setBirdVel(float birdVel) {
		this.birdVel = birdVel;
	}


	// Brick
	public float getBrickVel() {
		return brickVel;
	}


	public void setBrickVel(float brickVel) {
		this.brickVel = brickVel;
	}
	
	
	// Ralph
	public float getRalphVel() {
		return ralphVel;
	}
	
	
	public void setRalphVel(float vel) {
		this.ralphVel = ralphVel;
	}

	
	
	

}
