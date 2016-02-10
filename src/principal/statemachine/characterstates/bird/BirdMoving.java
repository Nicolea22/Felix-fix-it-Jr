package principal.statemachine.characterstates.bird;

import java.awt.Image;

import principal.Game;
import principal.graphics.Animation;
import principal.statemachine.characterstates.State;
import principal.statemachine.gamestate.GameManager;

public class BirdMoving extends State{


	private static BirdMoving moving = new BirdMoving();
	
	
	private BirdMoving() {
		animUpdate = 300;
	}
	
	public static BirdMoving getMoving(){
		return moving;
	}
	
		
	@Override
	public Image getImage(int dir) {
		if (dir == -1){
			animation = Game.animations.getLeftBird();
		}else
			animation = Game.animations.getRightBird();
		return animation.getActualFrame();
	}
	
	
	

}
	

