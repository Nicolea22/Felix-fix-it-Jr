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
	
	// RALPH'S ANIMATIONS
	private String[] ralphDemolishing = {
		"images/ralph/Demolishing/0.png",	
		"images/ralph/Demolishing/1.png",
		"images/ralph/Demolishing/2.png",
		"images/ralph/Demolishing/3.png",
	};
	
	
	private String[] ralphClimbing = {
		"images/ralph/Climbing/0.png",
		"images/ralph/Climbing/1.png",
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
	private Animation ralphClimb;
	private Animation ralphDemolition;
	
	
	// Felix Animations
	private Animation felixMoveLeft;
	private Animation felixMoveRight;
	
	private Animation felixNormalRight;
	private Animation felixNormalLeft;
	
	private Animation felixFixingRight;
	private Animation felixFixingLeft;
	
	
	// OBJECTS
	private final Sprite flowerPot;
	private final Sprite roof;
	
	private Animation brick;
	
	private Animation birdLeft;
	private Animation birdRight;
	
	private Animation nicelander;
	
	private Animation cake;
	
	public Images() {
		
		ralphDemolition = new Animation (ralphDemolishing);
		
		felixMoveLeft = new Animation(felixMovingLeftPaths);
		felixMoveRight = new Animation (felixMovingRightPaths);
		
		felixNormalRight = new Animation(felixNormalRightPaths);
		felixNormalLeft = new Animation(felixNormalLeftPaths);
		
		felixFixingLeft = new Animation(felixFixingLeftPaths);
		felixFixingRight = new Animation(felixFixingRightPaths);
		
		// OBJECTS
		flowerPot =  new Sprite(ResourceLoader.getLoader().
				loadImage("images/window/obstacles/flowerpot.png"));
		
		roof =  new Sprite(ResourceLoader.getLoader().
				loadImage("images/window/obstacles/roof.png"));
		
		brick = new Animation(brickPaths);
		
		birdLeft = new Animation(birdLeftPaths);
		birdRight = new Animation(birdRightPaths);
		
		nicelander = new Animation(nicelanderPaths);
		
		cake = new Animation(cakePaths);
	}
	
	public Animation getBrick() {
		return brick;
	}
	
	
	// RALPH'S ANIMATION
	public Animation getClimbing() {
		return ralphClimb;
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
	
	
	
	
}
