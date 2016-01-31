package principal;

import principal.graphics.Animation;

public class Images {
	
	private final String birdPaths[] = {
		"images/entities/bird/0.png",
		"images/entities/bird/1.png"
	};
	
	private final String brickPaths[] = {
		"images/entities/brick/0.png",
		"images/entities/brick/1.png"
	};
	
	private Animation brick;
	private Animation bird;
	
	public Images(){
		brick = new Animation(brickPaths);
		bird = new Animation(birdPaths);
	}

	public Animation getBrick(){
		return brick;
	}
	
	public Animation getBird(){
		return bird;
	}
	
}
