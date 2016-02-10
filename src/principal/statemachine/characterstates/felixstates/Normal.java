package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.Game;
import principal.statemachine.characterstates.State;

public class Normal extends State {
	
	private final static Normal normal = new Normal();
	
//	private String[] paths = {
//		"images/felix/normal/normalLeft/0.png",
//	};
	
	
	private Normal(){
		animation  = Game.animations.getFelixNormalRight();
		animUpdate = 1;
	}
	
	public static Normal getNormal(){
		return normal;
	}

	@Override
	public Image getImage(int dir) {
		if (dir == -1){
			animation = Game.animations.getFelixNormalLeft();
		}else
			animation = Game.animations.getFelixNormalRight();
		return animation.getActualFrame();
	}


	
}
