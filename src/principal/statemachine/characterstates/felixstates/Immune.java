package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class Immune extends State{
	
private final static Immune inmmune = new Immune();
	
	private Immune() {
		animation  = GameManager.animations.getFelixMoveRight();
		animUpdate = 2;
	}
	
	public static Immune getImmune(){
		return inmmune;
	}
	
		
	@Override
	public Image getImage(int dir) {
		if (dir == -1){
			animation = GameManager.animations.getFelixMoveLeft();
		}else
			animation = GameManager.animations.getFelixMoveRight();
		return animation.getActualFrame();
	}
	
}
