package principal.statemachine.characterstates.cake;

import java.awt.Image;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class CakeAnimation extends State{

	private static CakeAnimation cake = new CakeAnimation();	
	
	private CakeAnimation() {
		animation =  GameManager.animations.getCake();
		animUpdate = 700;
	}
	
	public static CakeAnimation getCake(){
		return cake;
	}
	
		
	@Override
	public Image getImage(int dir) {
		return animation.getActualFrame();
	}
}
