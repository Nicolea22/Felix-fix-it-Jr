package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class Normal extends State {
	
	private final static Normal normal = new Normal();
	
//	private String[] paths = {
//		"images/felix/normal/normalLeft/0.png",
//	};
	
	
	private Normal(){
		animation  = GameManager.animations.getFelixNormalRight();
		animUpdate = 1;
	}
	
	public static Normal getNormal(){
		return normal;
	}

	@Override
	public Image getImage(int dir) {
		if (dir == -1){
			animation = GameManager.animations.getFelixNormalLeft();
		}else
			animation = GameManager.animations.getFelixNormalRight();
		return animation.getActualFrame();
	}


	
}
