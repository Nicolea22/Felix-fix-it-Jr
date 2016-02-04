package principal.statemachine.characterstates.bird;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class BirdMoving extends State{


	private static BirdMoving moving = new BirdMoving();
	
	
	private BirdMoving() {
		animation  = GameManager.animations.getBird();
		animUpdate = 300;
	}
	
	public static BirdMoving getMoving(){
		return moving;
	}
	
		
	@Override
	public Image getImage(int dir) {
		return animation.getActualFrame();
	}
	
	
	

}
	

