package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.Game;
import principal.statemachine.characterstates.State;

public class Immune extends State{
	
private final static Immune inmmune = new Immune();
	
	private Immune() {
		animation  = Game.animations.getFelixMoveRight();
		animUpdate = 2;
	}
	
	public static Immune getImmune(){
		return inmmune;
	}
	
		
	@Override
	public Image getImage(int dir) {
		if (dir == -1){
			animation = Game.animations.getFelixMoveLeft();
		}else
			animation = Game.animations.getFelixMoveRight();
		return animation.getActualFrame();
	}
	
}
