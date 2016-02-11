package principal;

public class Level {

	private int actualLevel;

	private long timer;
	private float birdVel;
	private float brickVel;
	private float ralphVel;
	
	private long ralphTime;
	
	private static Level level = new Level();
	
	private Level() {
		actualLevel = 1;
		initLevel();
	}
	
	private void initLevel() {
		brickVel = 2.0f;
		birdVel = 1.5f;
		ralphVel = 0.8f;
		ralphTime = 3000;
	}
	
	public static Level getLevel(){
		return level;
	}
	
	public void levelUp() {
		actualLevel++;
		ralphVel += ralphVel * 15/100;
		birdVel += birdVel * 15/100;
		brickVel += brickVel * 15/100;
	}
	
	public void resetGame() {
		actualLevel = 1;
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


	public long getRalphTime() {
		return ralphTime;
	}

	public void setRalphTime(long ralphTime) {
		this.ralphTime = ralphTime;
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

	
	public long getTime() {
		return timer;
	}
	
	
	public void chooseLevel(String level) {
		switch(level){
		case "Level 1":
			setLevelVelocities(1);
			actualLevel = 1;
			break;
		case "Level 2":
			setLevelVelocities(2);
			actualLevel = 2;
			break;
		case "Level 3":
			setLevelVelocities(3);
			actualLevel = 3;
			break;
		case "Level 4":
			setLevelVelocities(4);
			actualLevel = 4;
			break;
		case "Level 5":
			setLevelVelocities(5);
			actualLevel = 5;
			break;
		case "Level 6":
			setLevelVelocities(6);
			actualLevel = 6;
			break;
		case "Level 7":
			setLevelVelocities(7);
			actualLevel = 7;
			break;
		case "Level 8":
			setLevelVelocities(8);
			actualLevel = 8;
			break;
		case "Level 9":
			setLevelVelocities(9);
			actualLevel = 9;
			break;		
		case "Level 10":
			setLevelVelocities(10);
			actualLevel = 10;
			break;	
		default:
			break;
			
		}
	}
	
	
	public void setLevelVelocities(int level) {
		initLevel();
		
		
		for (int i = 1; i < level; i++) {
			ralphVel += ralphVel * 15/100;
			birdVel += birdVel * 15/100;
			brickVel += brickVel * 15/100;
			ralphTime -= ralphTime*15/100;
		}

	}
	
	

}
