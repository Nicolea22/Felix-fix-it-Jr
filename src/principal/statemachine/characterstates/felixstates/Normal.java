package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;

public class Normal extends State {
	
	private final static Normal normal = new Normal();
	
	private String[] paths = {
		"images/felix/normal/0.png",
	};
	
	
	private Normal(){
		animation  = new Animation(paths);
		animUpdate = 1;
	}
	
	public static Normal getNormal(){
		return normal;
	}

	@Override
	public Image getImage() {
		return animation.getActualFrame();
	}


	
}
