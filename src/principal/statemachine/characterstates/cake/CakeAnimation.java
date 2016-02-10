package principal.statemachine.characterstates.cake;

import java.awt.Image;
import principal.Game;
import principal.statemachine.characterstates.State;


public class CakeAnimation extends State{

	private static CakeAnimation cake = new CakeAnimation();	
	
	private CakeAnimation() {
		animation =  Game.animations.getCake();
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
