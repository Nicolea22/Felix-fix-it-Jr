package principal;

import principal.graphics.Animation;
import principal.graphics.Sprite;
import principal.util.ResourceLoader;

public class Images {
	
	private String[] felixMovingLeft = {
		"images/felix/movingLeft/0.png",
		"images/felix/movingLeft/1.png",
		"images/felix/movingLeft/2.png",
		"images/felix/movingLeft/3.png",
	};
	
	
	private String[] felixMovingRight = {
		"images/felix/movingRight/0.png",
		"images/felix/movingRight/1.png",
		"images/felix/movingRight/2.png",
		"images/felix/movingRight/3.png",
	};
	
	
	
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

	
	private final String birdPaths[] = {
		"images/entities/bird/0.png",
		"images/entities/bird/1.png"
	};
	
	private final String brickPaths[] = {
		"images/entities/brick/0.png",
		"images/entities/brick/1.png"
	};
	
	//	Ralph Animations
	private Animation ralphClimb;
	private Animation ralphDemolition;
	
	
	// Felix Animations
	private Animation felixMoveLeft;
	private Animation felixMoveRight;
	
	private final Sprite flowerPot;
	private final Sprite roof;
	
	private Animation brick;
	private Animation bird;
	
	public Images() {
		brick = new Animation(brickPaths);
		bird = new Animation(birdPaths);
		
		
		ralphDemolition = new Animation (ralphDemolishing);
		
		felixMoveLeft = new Animation(felixMovingLeft);
		felixMoveRight = new Animation (felixMovingRight);
		
		
		flowerPot =  new Sprite(ResourceLoader.getLoader().
				loadImage("images/window/obstacles/flowerpot.png"));
		roof =  new Sprite(ResourceLoader.getLoader().
				loadImage("images/window/obstacles/roof.png"));
	}
	
	

	
	
	
	
	
	public Animation getBrick() {
		return brick;
	}
	
	public Animation getBird() {
		return bird;
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
	
	public Sprite getFlowerPot() {
		return flowerPot;
	}
	
	public Sprite getRoof() {
		return roof;
	}
	
}
