package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.Game;
import principal.statemachine.characterstates.State;

public class FelixWin extends State{

	private static FelixWin felixWin = new FelixWin();
	
	private FelixWin() {
		animation = Game.animations.getFelixWin();
		animUpdate = 800;
	}
	
	
	public static FelixWin getFelixWin(){
		return felixWin;
	}
	
	
	@Override
	public Image getImage(int dir) {
		return animation.getActualFrame();
	}

}
