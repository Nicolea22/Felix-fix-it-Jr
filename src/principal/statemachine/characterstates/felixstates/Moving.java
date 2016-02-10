package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.Game;
import principal.statemachine.characterstates.State;


public class Moving extends State{
	
	private final static Moving moving = new Moving();
	
	
	
	private Moving() {
		animation  = Game.animations.getFelixMoveRight();
		animUpdate = 200;
	}
	
	public static Moving getMoving(){
		return moving;
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

