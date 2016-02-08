package principal.statemachine.characterstates.nicelander;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class NicelanderAnimation extends State{
	
	
	private final String[] nicelanderPaths = {
		"images/entities/nicelander/0.png",
		"images/entities/nicelander/1.png"
	};
	
	private static NicelanderAnimation nicelander = new NicelanderAnimation();
	
	private NicelanderAnimation() {
		animUpdate = 1200;
		animation = new Animation(nicelanderPaths);
	}
	
	public static NicelanderAnimation getNicelander(){
		return nicelander;
	}

	@Override
	public Image getImage(int dir) {
		return animation.getActualFrame();
	}
	
	
}
