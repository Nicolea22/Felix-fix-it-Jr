package principal.statemachine.characterstates.felixstates;

import java.awt.Image;

import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class Moving extends State{
	
	private final static Moving moving = new Moving();
	
	
	
	private Moving() {
		animation  = GameManager.animations.getFelixMoveRight();
		animUpdate = 300;
	}
	
	public static Moving getMoving(){
		return moving;
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

