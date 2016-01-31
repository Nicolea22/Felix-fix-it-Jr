package principal.statemachine.characterstates;

import java.awt.Image;

import principal.graphics.Animation;

public abstract class State {
	
	protected String[] paths;
	protected int animationTickCounter = 0;
	protected int animUpdate;
	protected Animation animation;
	
	
	public abstract Image getImage();

	public void update(){
		animationTickCounter++;
		if (animationTickCounter % animUpdate == 0) {
			animation.tick();
			animationTickCounter = 0;
		}	
	}	

}
