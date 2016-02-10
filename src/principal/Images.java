package principal;

import principal.graphics.Animation;
import principal.graphics.Sprite;
import principal.util.ResourceLoader;

public class Images {
	
	// FELIX'S PATHS
	private String[] felixMovingLeftPaths = {
		"images/felix/moving/movingLeft/0.png",
		"images/felix/moving/movingLeft/1.png",
		"images/felix/moving/movingLeft/2.png",
		"images/felix/moving/movingLeft/3.png",
	};
	
	
	private String[] felixMovingRightPaths = {
		"images/felix/moving/movingRight/0.png",
		"images/felix/moving/movingRight/1.png",
		"images/felix/moving/movingRight/2.png",
		"images/felix/moving/movingRight/3.png",
	};

	
	private String[] felixFixingLeftPaths = {
		"images/felix/fixing/fixingLeft/0.png",
		"images/felix/fixing/fixingLeft/1.png",
	};
	
	
	private String[] felixFixingRightPaths = {
		"images/felix/fixing/fixingRight/0.png",
		"images/felix/fixing/fixingRight/1.png",
	};
	
	
	private String[] felixNormalRightPaths = {
		"images/felix/normal/normalRight/0.png",	
	};
	
	
	private String[] felixNormalLeftPaths = {
		"images/felix/normal/normalLeft/0.png",	
	};
	
	
	private String[] felixFallingPaths = {
		"images/felix/falling/0.png",
		"images/felix/falling/1.png",
	};
	
	// RALPH'S ANIMATIONS
	private String[] ralphDemolishing = {
		"images/ralph/Demolishing/0.png",	
		"images/ralph/Demolishing/1.png",
		"images/ralph/Demolishing/2.png",
		"images/ralph/Demolishing/3.png",
	};
	
	
	private String[] ralphClimbingPath = {
		"images/ralph/Climbing/0.png",
		"images/ralph/Climbing/1.png",
	};

	
	String[] ralphMovePath = {
		"images/ralph/Moving/0.png",
		"images/ralph/Moving/1.png",
	};
	
	// OBJECTS PATHS
	private final String[] birdLeftPaths = {
		"images/entities/bird/birdLeft/0.png",
		"images/entities/bird/birdLeft/1.png"
	};
	
	
	private final String[] birdRightPaths = {
		"images/entities/bird/birdRight/0.png",
		"images/entities/bird/birdRight/1.png"
	};
	
	
	private final String[] brickPaths = {
		"images/entities/brick/0.png",
		"images/entities/brick/1.png"
	};
	
	private final String[] nicelanderPaths = {
		"images/entities/nicelander/0.png",
		"images/entities/nicelander/1.png"
	};
	
	private final String[] cakePaths= {
		"images/entities/cake/0.png",
		"images/entities/cake/1.png"
	};
	
	
	
	
	//	Ralph Animations
	private Animation ralphClimbing;
	private Animation ralphDemolition;
	private Animation ralphMove;
	
	
	// Felix Animations
	private Animation felixMoveLeft;
	private Animation felixMoveRight;
	
	private Animation felixNormalRight;
	private Animation felixNormalLeft;
	
	private Animation felixFixingRight;
	private Animation felixFixingLeft;
	
	private Animation felixFalling;
	
	// OBJECTS
	private final Sprite flowerPot;
	private final Sprite roof;
	
	private final Sprite twoPanels; 
	
	private final Animation brick;
	
	private final Animation birdLeft;
	private final Animation birdRight;
	
	private final Animation nicelander;
	
	private final Animation cake;
	
	private final Sprite life;
	
	private final Sprite bush;
	
	private final Sprite cloud;
	
	private final Sprite building;
	
	// WINDOWS & PARTS
	private Sprite[] glasses; 
		
	
	public Images() {
		
		// Ralph's Animations
		
		ralphDemolition = new Animation (ralphDemolishing);
		
		ralphClimbing = new Animation (ralphClimbingPath);
		
		ralphMove = new Animation(ralphMovePath);
		
		// Felix's Animations
		
		felixMoveLeft = new Animation(felixMovingLeftPaths);
		felixMoveRight = new Animation (felixMovingRightPaths);
		
		felixNormalRight = new Animation(felixNormalRightPaths);
		felixNormalLeft = new Animation(felixNormalLeftPaths);
		
		felixFixingLeft = new Animation(felixFixingLeftPaths);
		felixFixingRight = new Animation(felixFixingRightPaths);
		
		felixFalling = new Animation(felixFallingPaths);
		
		// OBJECTS
		flowerPot =  new Sprite(ResourceLoader.getLoader().
				loadImage("images/window/obstacles/flowerpot.png"));
		
		roof =  new Sprite(ResourceLoader.getLoader().
				loadImage("images/window/obstacles/roof.png"));
		
		twoPanels = new Sprite(ResourceLoader.getLoader().
				loadImage("images/window/0.png"));
		
		life = new Sprite(ResourceLoader.getLoader().
				loadImage("images/life.png"));
		
		bush = new Sprite(ResourceLoader.getLoader().
				loadImage("images/bush.png"));
		
		cloud = new Sprite(ResourceLoader.getLoader().
				loadImage("images/entities/cloud/0.png"));
		
		building = new Sprite(ResourceLoader.getLoader().loadImage("images/building/0.png"));
		
		brick = new Animation(brickPaths);
		
		birdLeft = new Animation(birdLeftPaths);
		birdRight = new Animation(birdRightPaths);
		
		nicelander = new Animation(nicelanderPaths);
		
		cake = new Animation(cakePaths);
		
		

		// WINDOWS & PARTS
		initGlasses();
		
	}
	
	
	private void initGlasses() {
		glasses = new Sprite[7];
		for (int i = 0; i < glasses.length; i++) {
			glasses[i] = new Sprite(ResourceLoader.getLoader().loadImage("images/window/glasses/"+i+".png"));
		}
	}
	
	public Animation getBrick() {
		return brick;
	}
	
	
	// RALPH'S ANIMATION
	public Animation getClimbing() {
		return ralphClimbing;
	}
	
	public Animation getRalphDemolition(){
		return ralphDemolition;
	}
	
	
	// FELIX'S ANIMATION
	public Animation getFelixMoveLeft(){
		return felixMoveLeft;
	}
	
	public Animation getFelixMoveRight(){
		return felixMoveRight;
	}
	
	public Animation getFelixNormalLeft(){
		return felixNormalLeft;
	}
	
	public Animation getFelixNormalRight(){
		return felixNormalRight;
	}
	
	public Animation getFelixFixingLeft(){
		return felixFixingLeft;
	}
	
	public Animation getFelixFixingRight(){
		return felixFixingRight;
	}
	
	
	public Animation getFelixFalling(){
		return felixFalling;
	}
	
	// OBJECTS
	public Sprite getFlowerPot() {
		return flowerPot;
	}
	
	public Sprite getRoof() {
		return roof;
	}
	
	
	public Animation getLeftBird(){
		return birdLeft;
	}
	
	
	public Animation getRightBird(){
		return birdRight;
	}

	public Animation getNicelander() {
		return nicelander;
	}

	public Animation getCake() {
		return cake;
	}

	public Sprite getTwoPanels() {
		return twoPanels;
	}
	
	public Sprite getBush() {
		return bush;
	}
	
	public Sprite getCloud(){
		return cloud;
	}
	
	public Sprite getBuilding() {
		return building;
	}
	
	
	// WINDOWS & PARTS
	public Sprite getGlass(int i){
		return glasses[i];
	}


	public Sprite getLife() {
		return life;
	}


	public Animation getRalphMove() {
		return ralphMove;
	}



	
	
	
}
